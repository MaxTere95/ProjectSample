$currentDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$ignoreFile = Join-Path $currentDir ".dumpignore"
$sortFile = Join-Path $currentDir ".dumpsort"
$outputFile = Join-Path $currentDir "project_code.txt"
$projectRoot = Split-Path -Parent (Split-Path -Parent $currentDir)

if (Test-Path $outputFile) { Remove-Item $outputFile -Force }
if (-not (Test-Path $ignoreFile)) {
    Write-Error "Configuration file .dumpignore not found!"
    exit
}

# Шаг 1: Чтение черного списка .dumpignore
$excludePatterns = Get-Content $ignoreFile | Where-Object { $_ -match '\S' -and $_ -notmatch '^#' }

# Шаг 2: Первичный сбор всех файлов проекта (учитывая .dumpignore)
$allValidFiles = Get-ChildItem -Path $projectRoot -Recurse -File |
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
}

# Списки-корзины для сортировки
$priorityFiles = New-Object System.Collections.Generic.List[System.IO.FileInfo]
$remainingFiles = New-Object System.Collections.Generic.List[System.IO.FileInfo]($allValidFiles)

# Шаг 3: Приоритетная сортировка на основе .dumpsort
if (Test-Path $sortFile) {
    $sortRules = Get-Content $sortFile | Where-Object { $_ -match '\S' -and $_ -notmatch '^#' }

    foreach ($rule in $sortRules) {
        # Превращаем wildcard маску (*) в Regex маску (.*) для стабильной работы
        $regexPattern = [regex]::Escape($rule).Replace("\\*", ".*")

        if ($rule.EndsWith("/")) {
            $regexPattern = [regex]::Escape($rule) + ".*"
        }

        $currentGroup = New-Object System.Collections.Generic.List[System.IO.FileInfo]
        $nextRemaining = New-Object System.Collections.Generic.List[System.IO.FileInfo]

        foreach ($file in $remainingFiles) {
            # 🔄 КРИТИЧЕСКАЯ НОРМАЛИЗАЦИЯ СЛЕНШЕЙ ДЛЯ WINDOWS
            $checkPath = file.FullName.Replace($projectRoot, ".").Replace("\", "/")

            if ($checkPath -match $regexPattern) {
                $currentGroup.Add($file)
            } else {
                $nextRemaining.Add($file)
            }
        }

        # Сортируем файлы совпавшей группы по алфавиту и пушим в приоритеты
        if ($currentGroup.Count -gt 0) {
            $sortedGroup = $currentGroup | Sort-Object { $_.FullName.Replace($projectRoot, ".").Replace("\", "/") }
            foreach ($f in $sortedGroup) { $priorityFiles.Add($f) }
        }

        # Переназначаем оставшиеся файлы (защита от дубликатов)
        $remainingFiles = $nextRemaining
    }
}

# Оставшиеся файлы сортируем по алфавиту
$sortedRemaining = $remainingFiles | Sort-Object { $_.FullName.Replace($projectRoot, ".").Replace("\", "/") }

# Шаг 4: Сборка единой очереди и запись в итоговый дамп
$finalQueue = New-Object System.Collections.Generic.List[System.IO.FileInfo]
foreach ($f in $priorityFiles) { $finalQueue.Add($f) }
foreach ($f in $sortedRemaining) { $finalQueue.Add($f) }

foreach ($file in $finalQueue) {
    $relativePath = $file.FullName.Replace($projectRoot, ".").Replace("\", "/")
    "=== FILE: $relativePath ===" | Out-File -FilePath $outputFile -Append -Encoding utf8
    Get-Content $file.FullName -Raw | Out-File -FilePath $outputFile -Append -Encoding utf8
    "`n" | Out-File -FilePath $outputFile -Append -Encoding utf8
}

Write-Host "Dump project successfully generated at: $outputFile" -ForegroundColor Green
