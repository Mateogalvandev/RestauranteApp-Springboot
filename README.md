# 🍽️ RestauranteApp - Spring Boot

RestauranteApp es una aplicación backend desarrollada en **Java** con **Spring Boot** para la gestión de un restaurante. Permite administrar **clientes**, **productos** y **ventas** de manera eficiente. Además, utiliza **MySQL** como base de datos y está desplegada en **AWS EC2** con **RDS**.

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL Workbench**
- **AWS EC2 + RDS**
- **Maven**

- ## 🚀 Instalación

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local:

- **Clonar el repositorio**:
   git clone https://github.com/Mateogalvandev/RestauranteApp-Springboot.git
   cd RestauranteApp-Springboot

   ## Configurar la Base de Datos
- Edita el archivo `src/main/resources/application.properties` con los detalles de tu base de datos MySQL.

**Ejemplo de configuración:**

 **properties**
spring.datasource.url=jdbc:mysql://tu-servidor-rds:3306/restaurante_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

## Construir el proyecto
mvn clean package

## Ejecutar la aplicación
java -jar target/restaurante-0.0.1-SNAPSHOT.jar

# 📄 API Endpoints

## 🛠️ Clientes

| Método   | Endpoint                 | Descripción                       |
| -------- | ------------------------ | --------------------------------- |
| `POST`   | `/cliente/crear`         | Crea un nuevo cliente             |
| `GET`    | `/cliente/{id}`          | Obtiene un cliente por ID         |
| `PUT`    | `/cliente/editar/{id}`   | Actualiza los datos de un cliente |
| `DELETE` | `/cliente/eliminar/{id}` | Elimina un cliente por ID         |

## 🛠️ Productos

| Método   | Endpoint                  | Descripción                    |
| -------- | ------------------------- | ------------------------------ |
| `GET`    | `/producto/traer`         | Obtiene todos los productos    |
| `GET`    | `/producto/{id}`          | Obtiene un producto por ID     |
| `POST`   | `/producto/crear`         | Agrega un nuevo producto       |
| `PUT`    | `/producto/editar/{id}`   | Modifica un producto existente |
| `DELETE` | `/producto/eliminar/{id}` | Elimina un producto por ID     |

## 🛠️ Ventas

| Método   | Endpoint               | Descripción                            |
| -------- | ---------------------- | -------------------------------------- |
| `POST`   | `/venta/crear`         | Registra una nueva venta               |
| `GET`    | `/venta/{id}`          | Obtiene una venta por ID               |
| `GET`    | `/venta/cliente/{id}`  | Obtiene todas las ventas de un cliente |
| `DELETE` | `/venta/eliminar/{id}` | Elimina una venta por ID               |

## 🌍 Despliegue en AWS

La aplicación está desplegada en **AWS EC2**, utilizando **RDS** como base de datos y **Nginx** como proxy reverso. Esto garantiza un alto rendimiento y escalabilidad para la gestión del restaurante.

### Pasos para el despliegue en AWS:

1. **Crear una instancia EC2**:
   - Inicia una instancia EC2 en AWS con un sistema operativo compatible (por ejemplo, Amazon Linux o Ubuntu).
   - Asegúrate de configurar correctamente los grupos de seguridad para permitir el tráfico HTTP (puerto 80) y SSH (puerto 22).

2. **Configurar RDS (Base de Datos)**:
   - Crea una instancia de RDS con MySQL.
   - Configura la base de datos con los mismos parámetros que en el archivo `application.properties`.
   - Asegúrate de que la instancia EC2 tenga acceso a la base de datos RDS.

3. **Instalar dependencias en la instancia EC2**:
   - Conéctate a la instancia EC2 mediante SSH.
   - Instala Java, Maven y Nginx:
     ```bash
     sudo yum update -y
     sudo yum install java-17-amazon-corretto -y
     sudo yum install maven -y
     sudo yum install nginx -y
     ```

4. **Desplegar la aplicación**:
   - Clona el repositorio en la instancia EC2:
     ```bash
     git clone https://github.com/Mateogalvandev/RestauranteApp-Springboot.git
     cd RestauranteApp-Springboot
     ```
   - Construye el proyecto:
     ```bash
     mvn clean package
     ```
   - Ejecuta la aplicación:
     ```bash
     java -jar target/restaurante-0.0.1-SNAPSHOT.jar
     ```

5. **Configurar Nginx como proxy reverso**:
   - Edita el archivo de configuración de Nginx (`/etc/nginx/nginx.conf`) para redirigir el tráfico a la aplicación Spring Boot:
     ```nginx
     server {
         listen 80;
         server_name tu-dominio.com;

         location / {
             proxy_pass http://localhost:8080;
             proxy_set_header Host $host;
             proxy_set_header X-Real-IP $remote_addr;
             proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
         }
     }
     ```
   - Reinicia Nginx:
     ```bash
     sudo systemctl restart nginx
     ```

6. **Acceder a la aplicación**:
   - La aplicación estará disponible en la IP pública de tu instancia EC2 o en el dominio configurado.
   - 
## 📂 Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes principales:

### 1. **Controller**
   Contiene los controladores para manejar las solicitudes HTTP.
   - `ClienteController`: Gestiona las operaciones relacionadas con los clientes.
   - `ProductoController`: Gestiona las operaciones relacionadas con los productos.
   - `VentaController`: Gestiona las operaciones relacionadas con las ventas.

### 2. **Model**
   Define las entidades del sistema.
   - `Cliente`: Representa la entidad de un cliente.
   - `Producto`: Representa la entidad de un producto.
   - `Venta`: Representa la entidad de una venta.

### 3. **Service**
   Implementa la lógica de negocio.
   - `IClienteService`: Interfaz para los servicios relacionados con clientes.
   - `IProductoService`: Interfaz para los servicios relacionados con productos.
   - `IVentaService`: Interfaz para los servicios relacionados con ventas.

### 4. **Repository**
   Gestiona el acceso a la base de datos.
   - `ClienteRepository`: Interfaz para las operaciones de base de datos relacionadas con clientes.
   - `ProductoRepository`: Interfaz para las operaciones de base de datos relacionadas con productos.
   - `VentaRepository`: Interfaz para las operaciones de base de datos relacionadas con ventas.

### 5. **DTO (Data Transfer Objects)**
   Contiene objetos de transferencia de datos para manejar información específica.
   - `totalDto`: Utilizado para devolver información detallada sobre la venta con mayor total facturado.
# ✉️ Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme:

**Nombre:** Mateo Galván  

**GitHub:** [Mateogalvandev](https://github.com/Mateogalvandev)  

**Email:** mateodev0612j@gmail.com

**LinkedIn:** https://www.linkedin.com/in/mateo-galv%C3%A1n-ab9679336/
