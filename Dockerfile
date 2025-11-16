# ============================
# Stage 1 — Build the JAR
# ============================
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml first and download dependencies (to cache layers)
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Copy source code and build the JAR
COPY src ./src
RUN mvn -q clean package -DskipTests

# ============================
# Stage 2 — Run the application
# ============================
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Render sets PORT env automatically
EXPOSE 8080

# For Render: bind to 0.0.0.0
ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
