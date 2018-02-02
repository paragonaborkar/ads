# ads

Software | Version 
---------------------
Spring Boot         | 1.5.6

Angular             | 5.2.2 

Bootstrap           | 4.0

Node                | 8.9.4 

Java                | 1.8 

MariaDB             | 10.2 

HeidiSQL            | 9.5.0.5227 

Selenium            | 

Talend Open Studio  | 6.4.1


 



To run backend in Eclipse/STS, this one time setup is required for the licensing component

1. Get License library "license3j-1.0.8-SNAPSHOT.jar"
From the master branch:
https://github.com/paragonaborkar/ads/tree/master/ads-backend/lib 
Download the JAR file to your local development machine

2. Shutdown Eclipse/STS

3. Add library to local maven repo
mvn install:install-file -Dfile=<your jar location>\license3j-1.0.8-SNAPSHOT.jar -DgroupId=com.verhas -DartifactId=license3j  -Dversion=1.0.8 -Dpackaging=jar -DgeneratePom=true
  
4. Run eclipse
  
