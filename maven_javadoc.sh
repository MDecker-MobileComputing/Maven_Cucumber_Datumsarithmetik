#!/bin/bash

# JavaDoc erzeugen für produktiven Code und auch den Test-Code

clear

mvn clean javadoc:javadoc javadoc:test-javadoc -Dshow=private -DadditionalJOption=-Xdoclint:none

echo

