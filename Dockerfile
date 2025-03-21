FROM eclipse-temurin:17-jdk-jammy AS deps
COPY build/libs/reslerianadb-0.0.1-SNAPSHOT.jar reslerianadb-0.0.1.jar
ENTRYPOINT ["java","-jar","/reslerianadb-0.0.1.jar"]