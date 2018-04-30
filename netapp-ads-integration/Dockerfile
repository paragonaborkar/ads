#Base image to use
FROM openjdk:8-jdk-alpine

#Updates and font install for Jasper
RUN apk update && apk upgrade && apk add fontconfig && apk add msttcorefonts-installer && update-ms-fonts && fc-cache -f

#Talend CLI jobs
ADD talendjobs /usr/src/talendjobs
RUN chmod -R 777 /usr/src/talendjobs

#Rules file
ADD Drools/Discover /usr/src/drools/discover

#Spring boot JAR
ADD netapp-ads-integration.jar /usr/src/netapp-ads-integration.jar

ENTRYPOINT ["java", "-Dspring.datasource.url=jdbc:mysql://10.216.15.30:3308/ads_dev","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/src/netapp-ads-integration.jar"]]

EXPOSE 8080