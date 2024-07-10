# ApiRest de Spring Boot consumible para la gestión de personas

## EndPoints
### GET ("/list"):
Enlista todas las personas registradas en el sistema.
### GET ("/list/{id}"):
Enlista toda la información de la persona, de la cuál se pase el id por la ruta.
### POST ("/add"):
Registra a una nueva persona. Requiere a través del body la siguiente información
```
{
  "identification":"12121212",
  "name":"Dayana",
  "lastname" : "Vargas",
  "email" : "daya@gmail.com!,
  "phone" : "3078182912",
  "dateBirth" : "2005-11-03"
}
```
### PUT ("/{id}"):
Permite actualizar la información de una persona en específicio. Requiere en el body lo siguiente (La información que se desea cambiar):
```
{
  "identification":"12121212",
  "name":"Dayana",
  "lastname" : "Vargas",
  "email" : "daya@gmail.com!,
  "phone" : "3078182912",
  "dateBirth" : "2005-11-03"
}
```

### DELETE ("/{id}"):
Elimina toda la información de la persona, de la cuál se pase el id por la ruta.
