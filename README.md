## Crear contenedor Docker con MYSQL

1. Iniciar Docker
2. Crear contenedor, ejecutar en terminal:
bash
```
docker run -d --name mysql-gestion-hospitalaria -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=hospital_db mysql:8.3
```