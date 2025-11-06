
# 🩺 Historial de Pacientes – API REST

Este proyecto es una API REST desarrollada con **Java 21** y **Spring Boot** para la gestión de pacientes.  
Incluye operaciones CRUD completas (**listar, crear, actualizar y eliminar**) utilizando **DTOs** para la comunicación con el cliente y **Entities** para la persistencia en base de datos.  
La base de datos puede configurarse en **PostgreSQL** o **MySQL**.

---

## 📂 Estructura del proyecto

```
src/main/java/com/pacientes/historial
 ├── domain
 │   ├── model.entity
 │   │   ├── PacienteEntity.java
 │   │   └── DTO
 │   │       └── PacienteDTO.java
 │   └── service
 │       └── PacienteService.java
 ├── repository
 │   └── PacientesRepository.java
 ├── infrastructure
 │   └── PacienteController.java
 └── HistorialApplication.java
```

---

## ⚙️ Tecnologías utilizadas
- **Java 21**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data JPA**
- **Lombok**
- **PostgreSQL / MySQL**
- **Maven**
- **Postman** (para pruebas)

---

## 🚀 Endpoints disponibles

| Método | Endpoint                           | Descripción              |
|--------|------------------------------------|--------------------------|
| GET    | `/historial/listarPaciente`        | Listar todos los pacientes |
| POST   | `/historial/crearPaciente`         | Crear un nuevo paciente   |
| PUT    | `/historial/actualizarPaciente/{id}` | Actualizar paciente por ID |
| DELETE | `/historial/eliminarPaciente/{id}` | Eliminar paciente por ID  |

---

### 📌 Ejemplos de uso

#### 1. Listar pacientes
**GET** `http://localhost:8080/historial/listarPaciente`

Respuesta:
```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "edad": 35,
    "historial": "Hipertensión",
    "tratamiento": "Acentamifon",
    "fechaRegistro": "2025-11-05T00:00:00.000+00:00"
  }
]
```

---

#### 2. Crear paciente
**POST** `http://localhost:8080/historial/crearPaciente`

Body:
```json
{
  "nombre": "Ana Gómez",
  "edad": 28,
  "historial": "Diabetes",
  "tratamiento": "Insulina",
  "fechaRegistro": "2025-11-05T00:00:00.000+00:00"
}
```

---

#### 3. Actualizar paciente
**PUT** `http://localhost:8080/historial/actualizarPaciente/1`

Body:
```json
{
  "nombre": "Ana Gómez Actualizada",
  "edad": 29,
  "historial": "Diabetes controlada",
  "tratamiento": "Nuevo tratamiento",
  "fechaRegistro": "2025-11-05T00:00:00.000+00:00"
}
```

---

#### 4. Eliminar paciente
**DELETE** `http://localhost:8080/historial/eliminarPaciente/1`

Respuesta:
```
Paciente con id 1 eliminado correctamente
```

---

## 🛠️ Configuración de la base de datos

En el archivo `application.properties`:

### PostgreSQL
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/historialdb
spring.datasource.username=postgres
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

### MySQL
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/historial?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```



## 📌 Notas
- El proyecto usa **DTOs** para la comunicación con el cliente y evita exponer directamente las entidades.  
- Los mensajes de error simples se manejan con `System.out.println` para pruebas rápidas.  
- Se puede mejorar con excepciones personalizadas o `ResponseEntity` si se requiere mayor robustez.  

---
```

