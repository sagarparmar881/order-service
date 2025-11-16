# ============================
# Stage 1 — Build the JAR
# ============================
FROM maven:3.9.6-eclipse-temurin-23 AS build
WORKDIR /app

# Copy POM and download dependencies
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Copy the source and build the app
COPY src ./src
RUN mvn -q clean package -DskipTests

# ============================
# Stage 2 — Run the application
# ============================
FROM eclipse-temurin:23-jdk-alpine

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Render automatically sets PORT
EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]