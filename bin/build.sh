#!/bin/bash
pushd .
cd /workspaces/reports/volume/java/
rm lib/JdbcMain.jar
rm -rf bin/com
javac -verbose -d ./bin -cp ./bin:./lib ./com.mobex.etl/*.java
cd /workspaces/reports/volume/java/bin
jar cvfm ../lib/JdbcMain.jar ./manifest.txt ./com/mobex/etl/*.class
popd