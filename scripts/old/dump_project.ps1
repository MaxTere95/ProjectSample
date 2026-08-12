# 1. Запоминаем абсолютный путь к папке scripts, где лежит этот скрипт
$scriptsDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$outputFile = Join-Path $scriptsDir "project_code.txt"

# 2. Удаляем старый файл в самом начале, если он существовал
if (Test-Path $outputFile) {
    Remove-Item $outputFile -Force
}

# 3. Находим абсолютный путь к корню проекта (на один уровень выше папки scripts)
$projectRoot = Split-Path -Parent $scriptsDir

# 4. Ищем файлы строго в корне проекта, но сохраняем результат по абсолютному пути в папку scripts
Get-ChildItem -Path $projectRoot -Recurse -File |
Where-Object {
    $_.FullName -notmatch '\\(\.git|\.gradle|\.idea|build|node_modules|\.kotlin)\\' -and
    $_.Extension -notmatch '\.(png|jpg|jpeg|webp|ico|exe|jar|zip|db|sqlite|db3|klib)$' -and
    $_.Name -notmatch '^gradlew' -and
    $_.FullName -notmatch [regex]::Escape($outputFile)
} |
ForEach-Object {
    # Считаем относительный путь от корня проекта для красивых маркеров в тексте
    $relativePath = $_.FullName.Replace($projectRoot, ".")
    "=== FILE: $relativePath ==="
    Get-Content $_.FullName -Raw
    "`n"
} | Out-File -FilePath $outputFile -Encoding utf8
