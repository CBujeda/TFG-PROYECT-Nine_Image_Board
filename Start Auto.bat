title starter
Set _fGreen=[32m
Set _fYellow=[33m
Set _fBRed=[91m
@echo off
cls
echo %_fGreen%
echo.                          
echo          ,--.                   
echo        ,--.'^|   ,---,    ,---,. 
echo    ,--,:  : ^|,`--.' ^|  ,'  .'  \
echo ,`--.'`^|  ' :^|   :  :,---.' .' ^|
echo ^|   :  :  ^| ^|:   ^|  '^|   ^|  ^|: ^|
echo :   ^|   \ ^| :^|   :  ^|:   :  :  /
echo ^|   : '  '; ^|'   '  ;:   ^|    ; 
echo '   ' ;.    ;^|   ^|  ^|^|   :     \
echo ^|   ^| ^| \   ^|'   :  ;^|   ^|   . ^|
echo '   : ^|  ; .'^|   ^|  ''   :  '; ^|
echo ^|   ^| '`--'  '   :  ^|^|   ^|  ^| ; 
echo '   : ^|      ;   ^|.' ^|   :   /     
echo ;   ^|.'      '---'   ^|   ^| ,'   %_fYellow%		(v1.0.1) %_fGreen%
echo '---'                `----'     
echo 	%_fBRed%APP INIT
echo %_fYellow%
echo Generando Resources....
cd ./PROYECT NIB/Compiled
java -jar NIB_CONFIGURATOR.jar
cd ../..
echo Iniciando servidores....
start "" "./Start Backend.bat"
start "" "./Start Front.bat"
pause
exit