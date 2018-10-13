@echo off
rem ####### Starts the selenium HUB. Several nodes can be started that will connect to this HUB (see script #2)
REM We are resetting the JAVA_TOOL_OPTIONS and _JAVA_OPTIONS settings because on some environments they cause problems

title Selenium HUB
set JAVA_TOOL_OPTIONS=
SET _JAVA_OPTIONS=
java -jar selenium-server-standalone-3.14.0.jar -role hub -timeout 360
