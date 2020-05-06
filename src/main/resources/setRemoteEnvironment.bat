@echo off
echo update Chrome to 78 version
cd C:\Users\Tatiana\Downloads
cm_windows_386.exe selenoid stop
cm_windows_386.exe selenoid update --browsers "chrome:78.0"
docker port selenoid > tmp.txt
for /F %%i in (tmp.txt) do set result=%%i
echo Port selenoid is : %result%