#!/bin/bash

SCRIPTS_DIR="$(cd "$(dirname "$0")" && pwd)"
IGNORE_FILE="$SCRIPTS_DIR/.dumpignore"
SORT_FILE="$SCRIPTS_DIR/.dumpsort"
OUTPUT_FILE="$SCRIPTS_DIR/project_code.txt"
PROJECT_ROOT="$(dirname "$(dirname "$SCRIPTS_DIR")")"

rm -f "$OUTPUT_FILE"

# Проверяем наличие обязательного файла исключений
if [ ! -f "$IGNORE_FILE" ]; then
    echo "Configuration file .dumpignore not found!"
    exit 1
fi

# Шаг 1: Чтение черного списка .dumpignore
exclude_patterns=()
while IFS= read -r line || [ -n "$line" ]; do
    [[ -z "$line" || "$line" =~ ^# ]] && continue
    exclude_patterns+=("$line")
done < "$IGNORE_FILE"

# Шаг 2: Первичный сбор всех файлов проекта (учитывая .dumpignore)
all_valid_files=()
while IFS= read -r -d '' filepath; do
    if [ "$filepath" = "$OUTPUT_FILE" ]; then
        continue
    fi

    filename=$(basename "$filepath")
    normalized_path=".${filepath#$PROJECT_ROOT}"
    should_exclude=false

    for pattern in "${exclude_patterns[@]}"; do
        if [[ "$pattern" == */ ]]; then
            if [[ "$normalized_path" =~ "$pattern" ]]; then
                should_exclude=true
                break
            fi
        elif [[ "$normalized_path" =~ $pattern || "$filename" =~ $pattern ]]; then
            should_exclude=true
            break
        fi
    done

    if [ "$should_exclude" = false ]; then
        all_valid_files+=("$normalized_path")
    fi
done < <(find "$PROJECT_ROOT" -type f -print0)

# Массивы под две корзины файлов
priority_files=()
remaining_files=("${all_valid_files[@]}")

# Шаг 3: Приоритетная сортировка на основе .dumpsort (если файл существует)
if [ -f "$SORT_FILE" ]; then
    while IFS= read -r line || [ -n "$line" ]; do
        [[ -z "$line" || "$line" =~ ^# ]] && continue

        # Превращаем маску wildcard (*) в синтаксис регулярных выражений (.*)
        # Экранируем точки, заменяем звездочки на .*
        regex_pattern=$(echo "$line" | sed 's/\./\\./g' | sed 's/\*/.*/g')

        # Каталоги без звездочек обрабатываем как префиксы/вхождения
        if [[ "$line" == */ && "$line" != *\** ]]; then
            regex_pattern="$line.*"
        fi

        # Временный массив для оставшихся на следующем шаге файлов
        next_remaining=()
        current_group=()

        # Распределяем файлы текущей группы по корзинам
        for file in "${remaining_files[@]}"; do
            if [[ "$file" =~ $regex_pattern ]]; then
                current_group+=("$file")
            else
                next_remaining+=("$file")
            fi
        done

        # Сортируем текущую совпавшую группу по алфавиту и добавляем в приоритеты
        if [ ${#current_group[@]} -gt 0 ]; then
            IFS=$'\n' sorted_group=($(sort <<<"${current_group[*]}"))
            unset IFS
            priority_files+=("${sorted_group[@]}")
        fi

        # Обновляем список оставшихся файлов (защита от повторного попадания)
        remaining_files=("${next_remaining[@]}")

    done < "$SORT_FILE"
fi

# Сортируем оставшуюся корзину файлов по алфавиту
if [ ${#remaining_files[@]} -gt 0 ]; then
    IFS=$'\n' sorted_remaining=($(sort <<<"${remaining_files[*]}"))
    unset IFS
    remaining_files=("${sorted_remaining[@]}")
fi

# Шаг 4: Финальная склейка потоков и запись в итоговый дамп
final_queue=("${priority_files[@]}" "${remaining_files[@]}")

for file_path in "${final_queue[@]}"; do
    full_path="${PROJECT_ROOT}${file_path#.}"
    if [ -f "$full_path" ]; then
        echo "=== FILE: $file_path ===" >> "$OUTPUT_FILE"
        cat "$full_path" >> "$OUTPUT_FILE"
        echo -e "\n" >> "$OUTPUT_FILE"
    fi
done

echo "Dump project successfully generated at: $OUTPUT_FILE"
