#!/bin/bash

# 1. Определяем пути относительно папки скрипта
SCRIPTS_DIR="$(cd "$(dirname "$0")" && pwd)"
CONFIG_FILE="$SCRIPTS_DIR/.dumpignore"
OUTPUT_FILE="$SCRIPTS_DIR/project_code.txt"

# 2. Находим корень проекта (на два уровня выше)
PROJECT_ROOT="$(dirname "$(dirname "$SCRIPTS_DIR")")"

# 3. Удаляем старый файл дампа
rm -f "$OUTPUT_FILE"

if [ ! -f "$CONFIG_FILE" ]; then
    echo "Ошибка: Файл конфигурации .dumpignore не найден!"
    exit 1
fi

# 4. Строим команду find динамически. Начинаем поиск в корне проекта
FIND_CMD=(find "$PROJECT_ROOT" -type f)

# Читаем паттерны и добавляем их в исключения find через -not -path или -not -name
while IFS= read -r pattern || [ -n "$pattern" ]; do
    # Пропускаем пустые строки и комментарии
    [[ -z "$pattern" || "$pattern" =~ ^# ]] && continue

    # Если паттерн регулярного выражения содержит точку расширения в конце
    if [[ "$pattern" == *"\$" ]]; then
        clean_pattern=$(echo "$pattern" | sed 's/\$//' | sed 's/\\//g')
        FIND_CMD+=(-not -name "$clean_pattern")
    else
        # Убираем экранирование для find
        clean_pattern=$(echo "$pattern" | sed 's/\\//g')
        FIND_CMD+=(-not -path "*$clean_pattern*")
    fi
done < "$CONFIG_FILE"

# Исключаем сам выходной файл на всякий случай
FIND_CMD+=(-not -path "$OUTPUT_FILE")

# 5. Выполняем собранную команду и пишем в файл
"${FIND_CMD[@]}" -exec sh -c '
  # Вычисляем относительный путь для красивого маркера
  rel_path=$(echo "{}" | sed "s|^'$PROJECT_ROOT'|.|")
  echo "=== FILE: $rel_path ==="
  cat "{}"
  echo -e "\n"
' \; > "$OUTPUT_FILE"
