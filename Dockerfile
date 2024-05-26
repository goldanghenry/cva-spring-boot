FROM openjdk:17-jdk

ARG JAR_FILE=build/libs/cpa-0.0.1-SNAPSHOT.war

WORKDIR /cpa

COPY ${JAR_FILE} cpa.jar

EXPOSE 8080

CMD ["java", "-jar", "cpa.jar"]