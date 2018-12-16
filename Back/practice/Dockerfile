FROM frolvlad/alpine-oraclejdk8
COPY  target/*.jar /opt/app.jar
WORKDIR /opt
RUN adduser -D myuser
USER myuser
CMD java -jar app.jar