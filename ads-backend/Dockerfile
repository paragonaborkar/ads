#Base image to use
FROM openjdk:8-jdk-alpine

#creates a mount point with the specified name.
#VOLUME /ads-backend

#Adds a file or directory to the image,
ADD target/ads-0.0.1-SNAPSHOT.jar ads-backend.jar
	
ENTRYPOINT ["java", "-Dspring.datasource.url=jdbc:mysql://netapp-ads-database/ads_dev","-Djava.security.egd=file:/dev/./urandom","-jar","/ads-backend.jar"], "--spring.profiles.active=dev"]

#EXPOSE 8080


####
# Dockerfile and ads-0.0.1-SNAPSHOT.jar should be in the same folder
# Go to that folder and run below commands
# 
# docker build -t ads-backend:latest --rm=true .
# docker run -p 8080:8080 -it -v /c/Users/borkashi/dockerdata/backend:/ads-spring-boot-logs --detach --name ads-backend-container --link ads_database_1:database ads-backend
#
# Using Networking
#-------------------
# docker network create netapp-ads-net
# docker build -t ads-backend:latest --network netapp-ads-net --rm=true <PATH of Build>
# docker create --name ads-backend-container --network netapp-ads-net -t -v /c/Users/borkashi/dockerdata/backend:/ads-spring-boot-logs ads-backend:latest
# docker start <container_id>
# OR
# docker run -it -v /c/Users/borkashi/dockerdata/backend:/ads-spring-boot-logs --detach --name ads-backend-container ads-backend
#