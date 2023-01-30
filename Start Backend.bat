cd ./PROYECT NIB 
cd ./Compiled 
title NINE IMAGE BOARD - BackendEnd 

@ECHO OFF
cls
echo.[36m
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
echo ;   ^|.'      '---'   ^|   ^| ,'   		(v1.0.1)
echo '---'                `----'     
echo 	Power by SpringBoot
echo [95m 

"C:\Program Files\Java\jdk-17\bin\java.exe" -jar Backend_NIB-0.0.1-SNAPSHOT.jar --spring.config.location=back.properties
pause > nul 
exit