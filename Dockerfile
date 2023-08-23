FROM maven:3.9-amazoncorretto-11 AS build
RUN mkdir /app
WORKDIR /app
COPY sonar-project.properties .
COPY pom.xml .
RUN mvn dependency:resolve
COPY src src
RUN --mount=type=cache,target=/root/.m2 mvn package


FROM amazoncorretto:11
COPY --from=build /app/target/tv-guide-0.0.1-SNAPSHOT.jar tv-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tv-api.jar"]
