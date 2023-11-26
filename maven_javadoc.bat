@cls

@REM JavaDoc erzeugen für produktiven Code und auch den Test-Code

mvn clean javadoc:javadoc javadoc:test-javadoc -Dshop=private -DadditionalJOption=-Xdoclint:none

@echo.