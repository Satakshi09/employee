FROM openjdk:17
COPY target/HelloDocker-0.0.1-SNAPSHOT.jar HelloDocker-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar HelloDocker-0.0.1-SNAPSHOT.jar
