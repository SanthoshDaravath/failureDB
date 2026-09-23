FROM maven:3.9.15-eclipse-temurin-25 AS build
WORKDIR /workspace

COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests -B

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

RUN addgroup -S app && adduser -S app -G app
COPY --from=build /workspace/target/*.jar /app/app.jar
RUN chown -R app:app /app

USER app
EXPOSE 8080
ENV SERVER_PORT=8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
