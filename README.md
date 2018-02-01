# ads


To run backend in Eclipse/STS, this one time setup is required for the licensing component

1. Get License library "license3j-1.0.8-SNAPSHOT.jar"
From the master branch:
https://github.com/paragonaborkar/ads/tree/master/ads-backend/lib 
Download the JAR file to your local development machine

2. Shutdown Eclipse/STS

3. Add library to local maven repo
mvn install:install-file -Dfile=<your jar location>\license3j-1.0.8-SNAPSHOT.jar -DgroupId=com.verhas -DartifactId=license3j  -Dversion=1.0.8 -Dpackaging=jar -DgeneratePom=true
  
4. Run eclipse
  
