# Utilise une image Java 17
FROM eclipse-temurin:17-jdk-alpine

# Définit le répertoire de travail
WORKDIR /app

# Copie le fichier pom.xml et les sources
COPY pom.xml .
COPY src ./src

# Installe Maven et build l'application
RUN apk add --no-cache maven
RUN mvn clean package -DskipTests

# Expose le port 8080
EXPOSE 8080

# Démarre l'application
CMD ["java", "-jar", "target/road-0.0.1-SNAPSHOT.jar"]