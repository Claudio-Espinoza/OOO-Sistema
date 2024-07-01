# Usamos una imagen oficial de Maven con OpenJDK 17 para compilar la aplicación
FROM maven:3.8.4-openjdk-17 AS build

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo POM y lo transferimos al archivo temporal de Docker
COPY pom.xml .

# Copiamos el código fuente y lo transferimos al archivo temporal de Docker
COPY src ./src

# Compilamos la aplicación
RUN mvn package -DskipTests

# Usamos una imagen ligera de OpenJDK 17 para ejecutar la aplicación
FROM openjdk:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo JAR construido en el build
COPY --from=build /app/target/OOO-backend-0.0.1-SNAPSHOT.jar /app/OOO-backend.jar

# Copiamos los archivos pdf en desafios
COPY desafios /app/desafios

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/OOO-backend.jar"]
