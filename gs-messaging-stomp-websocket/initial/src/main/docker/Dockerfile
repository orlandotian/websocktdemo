FROM java:8
VOLUME /tmp
EXPOSE 1987
ADD websocket-1.0-SNAPSHOT.jar websocket.jar
RUN bash -c 'touch /websocket.jar'
ENTRYPOINT ["java","-jar","/websocket.jar"]