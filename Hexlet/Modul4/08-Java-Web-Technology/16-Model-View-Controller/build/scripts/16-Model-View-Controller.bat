@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  16-Model-View-Controller startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and 16_MODEL_VIEW_CONTROLLER_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\16-Model-View-Controller-1.0-SNAPSHOT.jar;%APP_HOME%\lib\javalin-bundle-6.1.3.jar;%APP_HOME%\lib\javalin-context-mock-6.1.3.jar;%APP_HOME%\lib\javalin-testtools-6.1.3.jar;%APP_HOME%\lib\javalin-6.1.3.jar;%APP_HOME%\lib\slf4j-simple-2.0.7.jar;%APP_HOME%\lib\javalin-rendering-6.1.3.jar;%APP_HOME%\lib\jte-3.1.9.jar;%APP_HOME%\lib\datafaker-2.0.1.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.16.1.jar;%APP_HOME%\lib\jackson-annotations-2.16.1.jar;%APP_HOME%\lib\jackson-core-2.16.1.jar;%APP_HOME%\lib\jackson-module-kotlin-2.16.1.jar;%APP_HOME%\lib\jackson-databind-2.16.1.jar;%APP_HOME%\lib\commons-text-1.13.1.jar;%APP_HOME%\lib\http2-server-11.0.20.jar;%APP_HOME%\lib\javalin-micrometer-6.1.3.jar;%APP_HOME%\lib\micrometer-jetty11-1.12.3.jar;%APP_HOME%\lib\jetty-alpn-conscrypt-server-11.0.20.jar;%APP_HOME%\lib\jetty-alpn-server-11.0.20.jar;%APP_HOME%\lib\websocket-jetty-server-11.0.20.jar;%APP_HOME%\lib\jetty-webapp-11.0.20.jar;%APP_HOME%\lib\websocket-servlet-11.0.20.jar;%APP_HOME%\lib\jetty-servlet-11.0.20.jar;%APP_HOME%\lib\jetty-security-11.0.20.jar;%APP_HOME%\lib\websocket-core-server-11.0.20.jar;%APP_HOME%\lib\jetty-server-11.0.20.jar;%APP_HOME%\lib\logback-classic-1.5.1.jar;%APP_HOME%\lib\websocket-jetty-common-11.0.20.jar;%APP_HOME%\lib\websocket-core-common-11.0.20.jar;%APP_HOME%\lib\http2-common-11.0.20.jar;%APP_HOME%\lib\http2-hpack-11.0.20.jar;%APP_HOME%\lib\jetty-http-11.0.20.jar;%APP_HOME%\lib\jetty-io-11.0.20.jar;%APP_HOME%\lib\jetty-xml-11.0.20.jar;%APP_HOME%\lib\jetty-util-11.0.20.jar;%APP_HOME%\lib\slf4j-api-2.0.12.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.9.22.jar;%APP_HOME%\lib\kotlin-reflect-1.6.21.jar;%APP_HOME%\lib\okhttp-4.12.0.jar;%APP_HOME%\lib\okio-jvm-3.6.0.jar;%APP_HOME%\lib\kotlin-stdlib-1.9.22.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.9.22.jar;%APP_HOME%\lib\brotli4j-1.16.0.jar;%APP_HOME%\lib\jte-extension-api-3.1.9.jar;%APP_HOME%\lib\jte-runtime-3.1.9.jar;%APP_HOME%\lib\snakeyaml-2.0.jar;%APP_HOME%\lib\generex-1.0.2.jar;%APP_HOME%\lib\commons-lang3-3.17.0.jar;%APP_HOME%\lib\jetty-jakarta-servlet-api-5.0.2.jar;%APP_HOME%\lib\websocket-jetty-api-11.0.20.jar;%APP_HOME%\lib\micrometer-core-1.12.3.jar;%APP_HOME%\lib\service-1.16.0.jar;%APP_HOME%\lib\conscrypt-openjdk-uber-2.5.2.jar;%APP_HOME%\lib\logback-core-1.5.1.jar;%APP_HOME%\lib\automaton-1.11-8.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\micrometer-observation-1.12.3.jar;%APP_HOME%\lib\micrometer-commons-1.12.3.jar;%APP_HOME%\lib\HdrHistogram-2.1.12.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar


@rem Execute 16-Model-View-Controller
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %16_MODEL_VIEW_CONTROLLER_OPTS%  -classpath "%CLASSPATH%" org.example14.App %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable 16_MODEL_VIEW_CONTROLLER_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%16_MODEL_VIEW_CONTROLLER_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
