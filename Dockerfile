FROM openjdk:17-oracle
EXPOSE 8080
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} online-store-app.war
ENTRYPOINT ["java", "-jar", "/online-store-app.war"]