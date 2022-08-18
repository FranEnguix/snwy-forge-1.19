@echo off
del C:\Users\Retsal\Documents\Java\SNWY\build\libs\snwy*
del "C:\Users\Retsal\Documents\Minecraft Forge\Server 1.19\mods\snwy*"
del C:\Users\Retsal\curseforge\minecraft\Instances\CrearForgeMod\mods\snwy*


START /B /WAIT cmd /c "C:\Users\Retsal\Documents\Java\SNWY\gradlew build"
copy C:\Users\Retsal\Documents\Java\SNWY\build\libs\snwy* "C:\Users\Retsal\Documents\Minecraft Forge\Server 1.19\mods"
copy C:\Users\Retsal\Documents\Java\SNWY\build\libs\snwy* C:\Users\Retsal\curseforge\minecraft\Instances\CrearForgeMod\mods
set /p DUMMY=Hit ENTER to finish