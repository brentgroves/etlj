# create the com.mobex.etl_lib jar
pushd ~/src/reports/volume/java/etl_lib
pushd /workspaces/reports/volume/java/etl_lib
## remove everything in target directories
mvn clean
## run goal verify just past package and before install
mvn verify
## install jar and pom file into local .m2 repo
mvn install

# create the etl_lib test program
pushd ~/src/reports/volume/java/etl_test
<!-- https://stackoverflow.com/questions/574594/how-can-i-create-an-executable-runnable-jar-with-dependencies-using-maven -->
## create jar with dependancies
mvn clean compile assembly:single
## run the program
java -jar target/etl_test-1.0-SNAPSHOT-jar-with-dependencies.jar

pushd ~/src/reports/volume/java/etl_lib
mvn clean verify
mvn dependency:copy-dependencies
java -cp "./target/classes:./target/dependency/*" com.mobex.etl_test.App


java -cp ".:/home/brent/src/reports/volume/java/etl_lib/target/etl_lib-1.0-SNAPSHOT.jar:/home/brent/src/reports/volume/java/lib/*" com.mobex.etl_test.App
https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
https://dzone.com/articles/how-to-create-a-java-library-from-scratch-to-maven
https://mkyong.com/maven/how-to-create-a-manifest-file-with-maven/
https://stackoverflow.com/questions/4955635/how-to-add-local-jar-files-to-a-maven-project
# how to build a library and a project that calls the library.
# main app
pushd ~/src/reports/volume/java
mvn archetype:generate -DgroupId=com.mobex.etl_test -DartifactId=etl_test -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn verify
# etl library
https://dzone.com/articles/how-to-create-a-java-library-from-scratch-to-maven
mvn archetype:generate -DgroupId=com.mobex.etl_lib -DartifactId=etl_lib -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn verify
