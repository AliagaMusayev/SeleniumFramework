@echo off
rem ####### Starts one selenium NODE. Several nodes can be started on several computers. The nodes connect to the hub (see script #1)

title Selenium NODE - Max 50 Sessions- Connecting to labor computer
set JAVA_TOOL_OPTIONS=
SET _JAVA_OPTIONS=
java -Dwebdriver.gecko.driver=C:\Users\aliaga.musayev\Desktop\SeleniumServer\GeckoAndChromeDriver\geckodriver-v0.21.0-win64\geckodriver.exe -Dwebdriver.chrome.driver=C:\Users\aliaga.musayev\Desktop\SeleniumServer\GeckoAndChromeDriver\chromedriver_win32\chromedriver.exe -jar selenium-server-standalone-3.14.0.jar -role node  -maxSession 50 -hub http://localhost:4444/grid/register -port 5555 -browser "browserName=firefox,maxInstances=10,platform=ANY,seleniumProtocol=WebDriver" -browser "browserName=chrome,maxInstances=10,platform=ANY,seleniumProtocol=WebDriver"
pause
