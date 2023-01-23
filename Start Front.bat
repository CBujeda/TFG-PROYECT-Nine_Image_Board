cd ./PROYECT NIB
cd ./FrontEnd_NIB
set version = v1.0.1
title NINE IMAGE BOARD - FrontEnd %version%
chcp 1252
@ECHO OFF
cls
echo.
echo NINE
echo IMAGE BOARD (%version%)
echo Power by Angular
echo.
ng serve
pause > nul