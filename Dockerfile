FROM openjdk:8 as build

LABEL maintainer="bethaniegarfin@gmail.com"

COPY ./gradle/wrapper ./gradle/wrapper
COPY ./gradlew .

RUN ./gradlew

COPY . .

RUN ./gradlew clean build

FROM openjdk:8-jdk-alpine

COPY --from=build ./build/libs/film-check-list-1.0.jar ./app.jar

CMD ["java", "-jar", "app.jar"]

EXPOSE 8081
