FROM eclipse-temurin:17-jdk AS builder
WORKDIR /build

# copy only build definition FIRST
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# then copy source
COPY src ./src

# build jar
RUN ./mvnw -B -DskipTests clean package
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]