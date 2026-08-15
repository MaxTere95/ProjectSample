#!/bin/bash

SCRIPTS_DIR="$(cd "$(dirname "$0")" && pwd)"
OUTPUT_FILE="$SCRIPTS_DIR/gradle_dump.txt"
PROJECT_ROOT="$(dirname "$(dirname "$SCRIPTS_DIR")")"

rm -f "$OUTPUT_FILE"

# Ищем файлы конфигурации Gradle по маскам
find "$PROJECT_ROOT" -type f \( \
    -name "build.gradle.kts" -o \
    -name "settings.gradle.kts" -o \
    -name "gradle.properties" -o \
    -name "libs.versions.toml" -o \
    -name "gradle-wrapper.properties" \
\) | while read -r filepath; do

    filename=$(basename "$filepath")
    normalized_path=".${filepath#$PROJECT_ROOT}"

    echo "=== FILE: $normalized_path ===" >> "$OUTPUT_FILE"
    cat "$filepath" >> "$OUTPUT_FILE"
    echo -e "\n" >> "$OUTPUT_FILE"
done
