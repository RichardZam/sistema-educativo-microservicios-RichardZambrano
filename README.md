# Sistema Educativo - Microservicios
## 📌 Descripcion
Este proyecto implementa un sistema educativo distribuido basado en microservicios utilizando Spring Boot y Spring Cloud. El sistema permite gestionar usuarios (estudiantes y docentes), asignaturas y matrículas de forma modular, garantizando escalabilidad y facilidad de mantenimiento.

## 🔍 Enfoque Distribuido
El sistema se divide en varios microservicios independientes, cada uno con su propia base de datos y lógica de negocio. La comunicación entre microservicios se maneja mediante Feign Client, y se utiliza Eureka Server para el descubrimiento de servicios. Además, se implementa seguridad con JWT, monitoreo con Spring Boot Actuator y despliegue mediante Docker y Docker Compose.

## 📂 Estructura del Proyecto

```graphql  
sistema-educativo-microservicios/
│── usuarios-servicio/        # Microservicio de gestión de estudiantes y docentes  
│── asignaturas-servicio/     # Microservicio para CRUD de materias  
│── matriculas-servicio/      # Microservicio de matrículas de estudiantes  
│── config-server/            # Servidor de configuración centralizada  
│── eureka-server/            # Servidor de descubrimiento de servicios  
│── README.md                 # Descripción del proyecto  
│── docker-compose.yml        # Orquestación de servicios  ```
```
## 🚀 Tecnologías Utilizadas
- Spring Boot (Microservicios)

- Spring Cloud (Config Server, Eureka)

- Spring Security & JWT (Autenticación)

- Feign Client (Comunicación entre microservicios)

- PostgreSQL / MySQL (Bases de datos)

- Docker & Docker Compose (Contenerización y despliegue)

## 📖 Instalación y Ejecución
### Clonar el repositorio:

```sh
git clone https://github.com/RichardZam/sistema-educativo-microservicios-RichardZambrano.git
cd sistema-educativo-microservicios-RichardZambrano
```

### Construir y ejecutar los microservicios con Docker Compose:
```sh
docker-compose up --build
```
