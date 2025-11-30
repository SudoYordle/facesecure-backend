# FaceSecure Backend

Este es el backend para la aplicación FaceSecure, desarrollado con Spring Boot. Proporciona una API RESTful para gestionar los usuarios y sus datos.

---

## ✨ Características

- **Gestión de Usuarios**: API completa para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de usuarios.
- **Seguridad**: Preparado para futuras implementaciones de seguridad como hashing de contraseñas y autenticación JWT.
- **Base de Datos en Memoria**: Utiliza H2 Database para un desarrollo y pruebas rápidas sin necesidad de configuración externa.

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**: Versión del lenguaje de programación.
- **Spring Boot 3**: Framework principal para el desarrollo de la aplicación.
- **Spring Web**: Para la creación de la API RESTful.
- **Spring Data JPA**: Para la persistencia de datos y la interacción con la base de datos.
- **H2 Database**: Base de datos en memoria para el perfil de desarrollo.
- **Lombok**: Para reducir el código repetitivo en las clases de modelo.
- **Gradle**: Herramienta de automatización de la construcción.

---

## 🚀 Cómo Empezar

Sigue estos pasos para tener una instancia del backend funcionando en tu máquina local.

### **Prerrequisitos**

- JDK 17 o superior instalado.
- Gradle instalado (o puedes usar el Gradle Wrapper incluido).

### **Instalación y Ejecución**

1.  **Clona el repositorio**:
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd facesecure-backend
    ```

2.  **Ejecuta la aplicación**:
    Puedes usar el Gradle Wrapper para iniciar la aplicación. Esto compilará el código y la ejecutará en un servidor Tomcat embebido.

    - En Windows (usando PowerShell o CMD):
      ```bash
      .\gradlew.bat bootRun
      ```

    - En macOS o Linux:
      ```bash
      ./gradlew bootRun
      ```

3.  **¡Listo!**
    El backend estará corriendo en `http://localhost:8080`.

---

## 📋 Endpoints de la API

La URL base para todos los endpoints es `http://localhost:8080/api/users`.

| Método | Endpoint                | Descripción                             | Ejemplo de Body (JSON)                                            |
| :----- | :---------------------- | :-------------------------------------- | :---------------------------------------------------------------- |
| `POST` | `/register`             | Crea un nuevo usuario.                  | `{ "nombre": "string", "email": "string", "password": "string" }`   |
| `GET`  | `/`                     | Obtiene una lista de todos los usuarios.| N/A                                                               |
| `GET`  | `/{id}`                 | Obtiene un usuario por su ID.           | N/A                                                               |
| `GET`  | `/email/{email}`        | Obtiene un usuario por su email.        | N/A                                                               |
| `PUT`  | `/{id}`                 | Actualiza un usuario existente.         | `{ "nombre": "string", "email": "string", "password": "string" }`   |
| `DELETE`| `/{id}`                 | Elimina un usuario por su ID.           | N/A                                                               |
