FROM maven:3.8.2-jdk-8
ARG JAR_FILE=/1.0-SNAPSHOT/*.jar
RUN apt-get install wget
RUN curl -u admin:admin -o achat.jar "http://192.168.1.200:8081/repositories/maven-snapshots/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20221017.202802-1.jar" -L
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8082
