@echo off
setlocal

REM Path για JAR
set JAR=libs\mysql-connector-java-8.0.29.jar

REM Δημιουργία φακέλου bins αν δεν υπάρχει
if not exist bins (
    mkdir bins
)

echo Compiling...
javac -cp "%JAR%" -d bins src\*.java

if errorlevel 1 (
    echo.
    echo Compilation failed. Please fix the errors and try again.
    pause
    exit /b
)

echo.
echo Running...
java -cp "bins;%JAR%" NewJFrame

pause
