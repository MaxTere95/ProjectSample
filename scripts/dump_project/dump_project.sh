#!/bin/bash

SCRIPTS_DIR="$(cd "$(dirname "$0")" && pwd)"
CONFIG_FILE="$SCRIPTS_DIR/.dumpignore"
OUTPUT_FILE="$SCRIPTS_DIR/project_code.txt"
PROJECT_ROOT="$(dirname "$(dirname "$SCRIPTS_DIR")")"

rm -f "$OUTPUT_FILE"

if [ ! -f "$CONFIG_FILE" ]; then
    echo "Configuration file .dumpignore not found!"
    exit 1
fi

exclude_patterns=()
while IFS= read -r line || [ -n "$line" ]; do
    [[ -z "$line" || "$line" =~ ^# ]] && continue
    exclude_patterns+=("$line")
done < "$CONFIG_FILE"

find "$PROJECT_ROOT" -type f | while read -r filepath; do
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
        echo "=== FILE: $normalized_path ===" >> "$OUTPUT_FILE"
        cat "$filepath" >> "$OUTPUT_FILE"
        echo -e "\n" >> "$OUTPUT_FILE"
    fi
done
