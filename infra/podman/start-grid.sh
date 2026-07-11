#!/bin/bash

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
COMPOSE_FILE="$SCRIPT_DIR/../compose.yaml"

echo "Starting Selenium Grid..."

podman compose -f "$COMPOSE_FILE" up -d

echo
echo "Selenium Grid is running."
echo "Grid UI: http://localhost:4444"
