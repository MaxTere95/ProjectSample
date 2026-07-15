#!/bin/bash

# 1. Запоминаем абсолютный путь к папке scripts, где лежит этот скрипт
SCRIPTS_DIR="$(cd "$(dirname "$0")" && pwd)"
OUTPUT_FILE="$SCRIPTS_DIR/project_code.txt"

# 2. Удаляем старый файл в самом начале, если он там был
rm -f "$OUTPUT_FILE"

# 3. Находим корень проекта (на один уровень выше папки scripts)
PROJECT_ROOT="$(dirname "$SCRIPTS_DIR")"

# 4. Запускаем поиск строго внутри корня проекта, но вывод перенаправляем в папку scripts
find "$PROJECT_ROOT" -type f \
  -not -path '*/.*' \
  -not -path '*/build/*' \
  -not -path '*/.gradle/*' \
  -not -path '*/.idea/*' \
  -not -path '*/.kotlin/*' \
  -not -name '*.png' \
  -not -name '*.jpg' \
  -not -name '*.jpeg' \
  -not -name '*.webp' \
  -not -name '*.ico' \
  -not -name '*.exe' \
  -not -name '*.jar' \
  -not -name '*.zip' \
  -not -name '*.db' \
  -not -name '*.sqlite' \
  -not -name '*.db3' \
  -not -name 'gradlew*' \
  -not -path "*/scripts/project_code.txt" \
  -exec sh -c 'echo "=== FILE: {} ==="; cat "{}"; echo -e "\n"' \; > "$OUTPUT_FILE"
