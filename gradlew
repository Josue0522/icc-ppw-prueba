#!/usr/bin/env sh
set -eu
GRADLE_VERSION="9.6.1"
BASE_DIR=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
DIST_DIR="$BASE_DIR/.gradle-dist/gradle-$GRADLE_VERSION"
if command -v gradle >/dev/null 2>&1; then
  exec gradle "$@"
fi
if [ ! -x "$DIST_DIR/bin/gradle" ]; then
  mkdir -p "$BASE_DIR/.gradle-dist"
  ZIP="$BASE_DIR/.gradle-dist/gradle-$GRADLE_VERSION-bin.zip"
  URL="https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip"
  echo "Descargando Gradle $GRADLE_VERSION..."
  if command -v curl >/dev/null 2>&1; then
    curl -fL "$URL" -o "$ZIP"
  elif command -v wget >/dev/null 2>&1; then
    wget -O "$ZIP" "$URL"
  else
    echo "ERROR: se requiere curl o wget para descargar Gradle." >&2
    exit 1
  fi
  if command -v unzip >/dev/null 2>&1; then
    unzip -q "$ZIP" -d "$BASE_DIR/.gradle-dist"
  else
    echo "ERROR: se requiere unzip." >&2
    exit 1
  fi
fi
exec "$DIST_DIR/bin/gradle" "$@"
