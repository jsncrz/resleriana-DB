FROM gradle:jdk17-jammy AS builder
WORKDIR /builder
COPY --chown=gradle:gradle . /builder
RUN gradle clean bootJar --no-daemon

FROM eclipse-temurin:17-jdk-jammy AS deps

WORKDIR /reslerianadb

COPY --from=builder /builder/build/libs/*.jar reslerianadb-0.0.1.jar
ENTRYPOINT ["java","-jar","reslerianadb-0.0.1.jar"]