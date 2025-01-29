# Usar una imagen base con Java
FROM openjdk:21-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Instalar netcat-openbsd para verificar la disponibilidad de MySQL
RUN apt-get update && apt-get install -y netcat-openbsd

# Copiar el archivo .jar de tu aplicación al contenedor
COPY target/micro-cursos-uwu-0.0.1-SNAPSHOT.jar app.jar

# Comando para esperar a que MySQL esté listo antes de iniciar la aplicación
CMD while ! nc -z mysql 3306; do echo "Esperando a MySQL..."; sleep 2; done; java -jar app.jar


# Exponer el puerto en el que corre la aplicación
EXPOSE 8002
