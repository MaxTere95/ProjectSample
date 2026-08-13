$currentDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$configFile = Join-Path $currentDir ".dumpignore"
$outputFile = Join-Path $currentDir "project_code.txt"
$projectRoot = Split-Path -Parent (Split-Path -Parent $currentDir)

if (Test-Path $outputFile) { Remove-Item $outputFile -Force }
if (-not (Test-Path $configFile)) {
    Write-Error "Configuration file .dumpignore not found!"
    exit
}

$excludePatterns = Get-Content $configFile | Where-Object { $_ -match '\S' -and $_ -notmatch '^#' }

Get-ChildItem -Path $projectRoot -Recurse -File |
Where-Object {
    $file = $_
    $shouldExclude = $false

    $normalizedPath = $file.FullName.Replace($projectRoot, ".").Replace("\", "/")

    foreach ($pattern in $excludePatterns) {
        $cleanPattern = $pattern.Replace("\", "")
        if ($cleanPattern.EndsWith("/")) {
            if ($normalizedPath -match ("/" + $cleanPattern)) {
                $shouldExclude = $true
                break
            }
        } elseif ($normalizedPath -match $pattern -or $file.Name -match $pattern) {
            $shouldExclude = $true
            break
        }
    }
    if ($file.FullName -eq $outputFile) { $shouldExclude = $true }
    -not $shouldExclude
} |
ForEach-Object {
    $relativePath = $_.FullName.Replace($projectRoot, ".").Replace("\", "/")
    "=== FILE: $relativePath ==="
    Get-Content $_.FullName -Raw
    "`n"
} | Out-File -FilePath $outputFile -Encoding utf8
