#!/bin/bash

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
COMPOSE_FILE="$SCRIPT_DIR/../compose.yaml"

echo "Stopping Selenium Grid..."

podman compose -f "$COMPOSE_FILE" down

echo "Done."
