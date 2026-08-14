$currentDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$outputFile = Join-Path $currentDir "gradle_dump.txt"
$projectRoot = Split-Path -Parent (Split-Path -Parent $currentDir)

if (Test-Path $outputFile) { Remove-Item $outputFile -Force }

# Массив масок для поиска конфигурационных файлов
$includePatterns = @("*.gradle.kts", "gradle.properties", "*.toml")

Get-ChildItem -Path $projectRoot -Recurse -File |
Where-Object {
    $file = $_
    $isMatch = $false

    foreach ($pattern in $includePatterns) {
        if ($file.Name -like $pattern) { $isMatch = $true; break }
    }
    # Отдельно проверяем wrapper, так как у него расширение .properties, но нам нужен только он
    if ($file.Name -eq "gradle-wrapper.properties") { $isMatch = $true }

    $isMatch
} |
ForEach-Object {
    $relativePath = $_.FullName.Replace($projectRoot, ".").Replace("\", "/")
    "=== FILE: $relativePath ==="
    Get-Content $_.FullName -Raw
    "`n"
} | Out-File -FilePath $outputFile -Encoding utf8
