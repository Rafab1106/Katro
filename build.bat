@echo off
setlocal enabledelayedexpansion

REM === Configuration du chemin JavaFX ===
set "JAVAFX_PATH=C:\javafx-sdk-17.0.16\lib"

REM === Création du dossier de sortie ===
if not exist out mkdir out

REM === Lister tous les fichiers .java ===
echo 🔧 Compilation de tous les fichiers Java dans src...
set "FILES="

for /R src %%f in (*.java) do (
    set "FILES=!FILES! %%f"
)

REM === Compilation ===
javac --module-path "%JAVAFX_PATH%" --add-modules javafx.controls,javafx.fxml -d out !FILES!

if %errorlevel% neq 0 (
    echo ❌ Erreur de compilation !
    pause
    exit /b %errorlevel%
)

echo ✅ Compilation réussie !

REM === Exécution automatique (modifier si besoin) ===
set "MAIN_CLASS=mainty.Main"
echo 🚀 Exécution de %MAIN_CLASS%...
java --module-path "%JAVAFX_PATH%" --add-modules javafx.controls,javafx.fxml -cp out %MAIN_CLASS%

pause
endlocal
