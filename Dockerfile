# Imagen base de Java
FROM openjdk:17-jdk-slim
# Añadir argumento para la versión de JAR
ARG JAR_FILE=target/vivelibre-microservice-0.0.1-SNAPSHOT.jar
# Copiar el JAR del proyecto al contenedor
COPY ${JAR_FILE} app.jar
# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
