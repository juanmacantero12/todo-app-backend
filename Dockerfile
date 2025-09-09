# Etapa 1: Construcción con Maven y Java 17
# Usamos una imagen oficial que ya tiene Maven y Java 17 listos.
FROM maven:3.8.5-openjdk-17 AS build

# Creamos un directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos todo el código de nuestro proyecto a ese directorio
COPY . .

# Ejecutamos el comando de construcción de Maven para generar el archivo .jar
RUN mvn clean install -DskipTests

# Etapa 2: Ejecución
# Usamos una imagen más ligera que solo tiene lo necesario para ejecutar Java.
FROM openjdk:17-jre-slim

# Creamos un directorio de trabajo
WORKDIR /app

# Copiamos solo el archivo .jar compilado desde la etapa de construcción anterior
COPY --from=build /app/target/todo-app-0.0.1-SNAPSHOT.jar ./app.jar

# Exponemos el puerto 8080 para que el mundo exterior pueda hablar con nuestra app
EXPOSE 8080

# El comando final para iniciar la aplicación cuando el contenedor arranque
CMD ["java", "-jar", "app.jar"]
