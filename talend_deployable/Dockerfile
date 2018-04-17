#Base image to use
FROM java:8-jdk

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

COPY TOS_ESB-20180116_1512-V6.5.1.zip /usr/local
RUN mkdir -p /usr/local/talend
RUN unzip /usr/local/TOS_ESB-20180116_1512-V6.5.1.zip -d /usr/local/talend
RUN rm /usr/local/TOS_ESB-20180116_1512-V6.5.1.zip

COPY CmdbSimulator-0.1.jar /usr/local/talend/Runtime_ESBSE/container/deploy
COPY cmdbSimulatorFiles /usr/local/talend/Runtime_ESBSE/container/deploy/cmdbSimulatorFiles
COPY ads_local_context.properties /usr/local/talend/Runtime_ESBSE/container/deploy
COPY job.properties /usr/local/talend/Runtime_ESBSE/container/deploy

EXPOSE 8040 9001 1099 44444 8101 8000 8001 8888 61616 2181 1527 8082 8088 8090

CMD ["/usr/local/talend/Runtime_ESBSE/container/bin/trun"]