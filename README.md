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




## Dificultades del proyecto

1. No he tenido claro porqué la firma del método devuelve un único elemento como Optional 
2. En la firma devuelve un BookDate, cuando la entrada era un List<Book>, he realizado un mapeo directamente sin 
usar Mapstruct.
3. Entiendo que no es necesario utilizar la BBDD en el ejercicio ya que la lectura se hace en un json.
