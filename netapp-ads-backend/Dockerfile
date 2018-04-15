#Base image to use
FROM openjdk:8-jdk-alpine

#creates a mount point with the specified name.
#VOLUME /ads-web

RUN apk update && apk upgrade && apk add fontconfig && apk add msttcorefonts-installer && update-ms-fonts && fc-cache -f

#ADD talendjobs talendjobs

#ADD discovery_rules discovery_rules

#RUN chmod -R 755 talendjobs

#Adds a file or directory to the image,
ADD netapp-ads-backend-0.0.1-SNAPSHOT.jar netapp-ads-backend-0.0.1-SNAPSHOT.jar
	
#ENTRYPOINT ["java", "-Dspring.datasource.url=jdbc:mysql://<container_name from --name>/ads_dev","-Djava.security.egd=file:/dev/./urandom","-jar","/ads-backend.jar"], "--spring.profiles.active=dev"]
ENTRYPOINT ["java", "-Dspring.datasource.url=jdbc:mysql://10.216.15.30:3308/ads_dev","-Djava.security.egd=file:/dev/./urandom","-jar","/netapp-ads-backend-0.0.1-SNAPSHOT.jar"]]

EXPOSE 8080


####
# Dockerfile and ads-0.0.1-SNAPSHOT.jar should be in the same folder
# Go to that folder and run below commands
# 
# docker build -t ads-backend:latest --rm=true .
# docker run -p 8080:8080 -it -v /c/Users/borkashi/dockerdata/backend:/ads-spring-boot-logs --detach --name ads-backend-container --link ads_database_1:database ads-backend
#
# Using Networking
#-------------------
# docker network create adsappnet
# docker build -t ads-backend:latest --network adsappnet --rm=true <PATH of Build (Dockerfile)>
#
# docker create --name ads-backend --network adsappnet -t -v /usr/local/ads/logs:/ads-spring-boot-logs ads-backend:latest
# docker start <container_id>
# OR
# docker run -it -v /usr/local/ads/logs:/ads-spring-boot-logs --detach --name ads-backend-container ads-backend
#

#
# Using Link
#-------------------
# docker build -t ads-backend:latest --rm=true <PATH of Build (Dockerfile)>
#
# docker create --name ads-backend -t -v /usr/local/ads/logs:/ads-spring-boot-logs ads-backend:latest
# docker start <container_id>
# OR
# docker run <-d> -it -v /usr/local/ads/logs:/ads-spring-boot-logs --name ads-backend ads-backend
#