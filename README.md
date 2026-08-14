# SIGVET - Sistema de Gestión de Ventas

<p align="center">
  <a href="https://github.com/Krabbiwolf/SIGVETV2/releases/tag/Instalador">
    <img src="https://img.shields.io/badge/⬇️_Descargar_SIGVET-28a745?style=for-the-badge" alt="Descargar SIGVET">
  </a>
</p>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge\&logo=mysql\&logoColor=white)
![MVC](https://img.shields.io/badge/Arquitectura-MVC-blue?style=for-the-badge)
![Cloudinary](https://img.shields.io/badge/Cloudinary-3448C5?style=for-the-badge\&logo=cloudinary\&logoColor=white)
![Railway](https://img.shields.io/badge/Railway-0B0D0E?style=for-the-badge\&logo=railway\&logoColor=white)

##  Descripción

SIGVET es un sistema integral de gestión de ventas e inventario desarrollado en Java Swing y MySQL, diseñado para optimizar la administración de negocios mediante el control de ventas, compras, productos, clientes, proveedores, kardex y lotes.

El sistema implementa el patrón de diseño MVC (Model - View - Controller), permitiendo una arquitectura organizada, escalable y fácil de mantener.

Además, integra servicios en la nube para mejorar la disponibilidad de los datos y la gestión de imágenes:

*  Railway para el alojamiento de la base de datos MySQL.
*  Cloudinary para el almacenamiento y gestión de imágenes de productos.

---

##  Funcionalidades Principales

###  Gestión de Productos

* Registro de productos.
* Actualización de información.
* Control de stock.
* Gestión de imágenes mediante Cloudinary.

###  Gestión de Ventas

* Registro de ventas.
* Cálculo automático de totales.
* Historial de ventas.
* Actualización automática de inventario.

###  Gestión de Compras

* Registro de compras a proveedores.
* Actualización automática de existencias.
* Historial de compras.

###  Gestión de Kardex

* Registro detallado de movimientos de inventario.
* Control de entradas y salidas.
* Historial de movimientos.
* Trazabilidad completa del inventario.

###  Gestión de Lotes

* Registro y control de lotes.
* Seguimiento de existencias por lote.
* Identificación de productos según lote.
* Mejor control y trazabilidad.

###  Gestión de Clientes

* Registro y administración de clientes.
* Consulta y actualización de información.

###  Gestión de Proveedores

* Registro y administración de proveedores.
* Historial de compras realizadas.

### Gestión de Usuarios

* Inicio de sesión.
* Control de acceso.
* Administración de usuarios.

### Reportes

* Reportes de ventas.
* Reportes de compras.
* Reportes de inventario.
* Consulta de movimientos de Kardex.

---

##  Arquitectura del Proyecto

El sistema está desarrollado utilizando el patrón MVC.

### Model

* Acceso a datos.
* Consultas SQL.
* Reglas de negocio.

### View

* Interfaces gráficas desarrolladas con Java Swing.
* Interacción con el usuario.

### Controller

* Procesamiento de eventos.
* Comunicación entre vistas y modelos.
* Flujo de la aplicación.

---

## 🛠️ Tecnologías Utilizadas

### Lenguajes y Frameworks

* Java
* Java Swing
* JDBC

### Base de Datos

* MySQL

### Servicios en la Nube

* Railway
* Cloudinary

### Arquitectura

* MVC (Model View Controller)

### Herramientas

* NetBeans
* Git
* GitHub

---

##  Infraestructura en la Nube

### Railway

La base de datos MySQL se encuentra alojada en Railway, permitiendo acceso remoto y centralización de la información.

### Cloudinary

Las imágenes de productos son almacenadas en Cloudinary para evitar almacenamiento local y mejorar la disponibilidad de recursos.

---

##  Capturas del Sistema

###  Inicio de Sesión

![Login](screenshots/login.png)

###  Dashboard Principal

![Dashboard](screenshots/dashboard.png)

###  Gestión de Productos

![Productos](screenshots/productos.png)

###  Gestión de Ventas

![Ventas](screenshots/ventas.png)

###  Gestión de Compras

![Compras](screenshots/compras.png)

### Kardex

![Kardex](screenshots/kardex.png)

###  Gestión de Lotes

![Lotes](screenshots/lotes.png)

---

##  Descarga

Puedes descargar la última versión desde la sección de Releases:

###  Descarga Directa

[Descargar SIGVET](https://github.com/Krabbiwolf/SIGVETV2/releases/tag/Instalador)

---

##  Usuario de Prueba

Para facilitar la evaluación del sistema:

**Usuario:** UserPrueba

**Contraseña:** prueba123

> Estas credenciales son únicamente para demostración del proyecto.

---

##  Objetivos del Proyecto

Este proyecto fue desarrollado para fortalecer conocimientos en:

* Programación Orientada a Objetos.
* Arquitectura MVC.
* Desarrollo de aplicaciones de escritorio.
* Diseño de bases de datos.
* Integración de servicios en la nube.
* Buenas prácticas de ingeniería de software.

---


