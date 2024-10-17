# Levantar el servicio en desarrollo
Necesitaremos levantar la imagen Docker preparada en el script start.sh
````
sh start.sh
````
Después podemos levantar la imagen:
````
mvn springboot:run -Dspring.profiles.active=local 
````
# Construcción y ejecución de la imagen Docker
````
docker-compose up --build
````
