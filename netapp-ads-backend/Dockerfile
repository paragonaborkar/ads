#Base image to use
FROM openjdk:8-jdk-alpine

#creates a mount point with the specified name.
VOLUME /ads-spring-boot-logs

RUN apk update && apk upgrade && apk add fontconfig && apk add msttcorefonts-installer && update-ms-fonts && fc-cache -f


#Adds the JAR file to the image
ADD netapp-ads-backend.jar netapp-ads-web.jar
	
ENTRYPOINT ["java", "-Dspring.datasource.url=jdbc:mysql://10.216.15.30:3308/ads_dev","-Djava.security.egd=file:/dev/./urandom","-jar","/netapp-ads-web.jar"]]

EXPOSE 8080