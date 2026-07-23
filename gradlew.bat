@echo off
setlocal
set GRADLE_VERSION=9.6.1
set BASE_DIR=%~dp0
set DIST_ROOT=%BASE_DIR%.gradle-dist
set DIST_DIR=%DIST_ROOT%\gradle-%GRADLE_VERSION%
where gradle >nul 2>nul
if %ERRORLEVEL% EQU 0 (
  gradle %*
  exit /b %ERRORLEVEL%
)
if not exist "%DIST_DIR%\bin\gradle.bat" (
  if not exist "%DIST_ROOT%" mkdir "%DIST_ROOT%"
  powershell -NoProfile -ExecutionPolicy Bypass -Command "$u='https://services.gradle.org/distributions/gradle-%GRADLE_VERSION%-bin.zip'; $z='%DIST_ROOT%\gradle-%GRADLE_VERSION%-bin.zip'; Invoke-WebRequest -Uri $u -OutFile $z; Expand-Archive -Path $z -DestinationPath '%DIST_ROOT%' -Force"
  if %ERRORLEVEL% NEQ 0 exit /b %ERRORLEVEL%
)
call "%DIST_DIR%\bin\gradle.bat" %*
