@echo off
set port=9090
for /f "tokens=1-5" %%i in ('netstat -ano^|findstr ":%port%"') do (
 echo kill the process %%m who use the port 
 taskkill /pid %%m -t -f
 goto start
)
:start
 
START "app" javaw -jar ruoyi-monitor-admin.jar