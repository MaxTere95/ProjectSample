# 1. Определяем пути относительно папки, где лежит сам скрипт
$currentDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$configFile = Join-Path $currentDir ".dumpignore"
$outputFile = Join-Path $currentDir "project_code.txt"

# 2. Находим корень проекта (на два уровня выше: scripts/dump_project -> корень)
$projectRoot = Split-Path -Parent (Split-Path -Parent $currentDir)

# 3. Удаляем старый дамп, если он существовал
if (Test-Path $outputFile) { Remove-Item $outputFile -Force }

# 4. Считываем паттерны исключений из файла конфигурации
if (-not (Test-Path $configFile)) {
    Write-Error "Файл конфигурации .dumpignore не найден!"
    exit
}
$excludePatterns = Get-Content $configFile | Where-Object { $_ -match '\S' }

# 5. Рекурсивно обходим проект
Get-ChildItem -Path $projectRoot -Recurse -File |
Where-Object {
    $file = $_
    $shouldExclude = $false

    # Проверяем файл на соответствие каждому паттерну из конфига
    foreach ($pattern in $excludePatterns) {
        if ($file.FullName -match $pattern -or $file.Name -match $pattern) {
            $shouldExclude = $true
            break
        }
    }
    # Пропускаем сам файл результата, если он совпал по абсолютному пути
    if ($file.FullName -eq $outputFile) { $shouldExclude = $true }

    -not $shouldExclude
} |
ForEach-Object {
    $relativePath = $_.FullName.Replace($projectRoot, ".")
    "=== FILE: $relativePath ==="
    Get-Content $_.FullName -Raw
    "`n"
} | Out-File -FilePath $outputFile -Encoding utf8
