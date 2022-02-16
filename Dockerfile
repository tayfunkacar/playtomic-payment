FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8090
ADD /target/*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=test", "-jar", "app.jar"]