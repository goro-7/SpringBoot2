from openjdk:8-jre-alpine

ADD target/SpringBoot2-1.0.jar App.jar

ENTRYPOINT exec java -jar /App.jar
EXPOSE 8080