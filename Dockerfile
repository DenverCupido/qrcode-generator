FROM openjdk:17
MAINTAINER Denver Cupido <denverfcupido@gmail.com>
COPY target/qrcode-generator-2.0.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]