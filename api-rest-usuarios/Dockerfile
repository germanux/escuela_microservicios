
# Equivalente FROM mysql:8.0.18
# Nos decasrgamos el contenedor oficial de 
# Open JDK, sólo el proyecto JRE

FROM openjdk:8-jre-slim
# Definimos variable
ARG JAR_FILE=target/*.jar
# Copiando al interior del contenedor en 
# el directorio raiz
COPY ${JAR_FILE} /api-rest-usuarios.jar
CMD java -jar /api-rest-usuarios.jar
