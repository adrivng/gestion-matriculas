# 🎓 Sistema de Gestión de Matrículas

Sistema backend desarrollado con una **arquitectura de microservicios** para gestionar estudiantes, cursos y matrículas de un instituto.

El proyecto implementa servicios independientes, configuración centralizada, descubrimiento de servicios, autenticación con OAuth2 y despliegue mediante Docker.

---

## 🛠️ Tecnologías

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-green)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-Microservices-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Docker](https://img.shields.io/badge/Docker-Containers-blue)
![Keycloak](https://img.shields.io/badge/Keycloak-OAuth2-purple)

**Backend:** Java · Spring Boot
**Arquitectura:** Microservicios · Spring Cloud
**Base de datos:** MySQL
**Seguridad:** Keycloak · OAuth2
**Infraestructura:** Docker · Eureka Server · Config Server

---

## 🧩 Arquitectura

El sistema está dividido en servicios independientes:

### 👤 Estudiante Service

Gestiona la información y operaciones relacionadas con los estudiantes.

### 📚 Curso Service

Administra cursos, horarios y la información académica asociada.

### 📝 Matrícula Service

Gestiona las matrículas y la relación entre estudiantes y cursos.

### 🔎 Eureka Server

Permite el registro y descubrimiento dinámico de los microservicios.

### ⚙️ Config Server

Centraliza la configuración utilizada por los diferentes servicios.

### 🔐 Keycloak

Gestiona la autenticación y autorización mediante **OAuth2 y roles de usuario**.

---

## 📂 Estructura del proyecto

```text
gestion-matriculas/
│
├── config-repo/        # Configuración centralizada
├── config-server/      # Spring Cloud Config Server
├── ms-curso/           # Microservicio de cursos
├── ms-estudiante/      # Microservicio de estudiantes
├── ms-eureka/          # Service Discovery
├── ms-matricula/       # Microservicio de matrículas
│
├── docker-compose.yml
├── init.sql
└── keycloak-realm.json
```

---

## ✨ Funcionalidades principales

* Gestión de estudiantes.
* Gestión de cursos.
* Registro y administración de matrículas.
* Comunicación entre microservicios.
* Descubrimiento de servicios mediante Eureka.
* Configuración centralizada mediante Spring Cloud Config.
* Seguridad basada en roles.
* Autenticación y autorización con Keycloak y OAuth2.
* Persistencia de información en MySQL.
* Contenedorización de los servicios mediante Docker.

---

## 🔐 Seguridad

La seguridad del sistema se gestiona mediante **Keycloak**, utilizando OAuth2 para controlar el acceso a los recursos.

Esto permite:

* Autenticación mediante tokens.
* Protección de endpoints.
* Administración de usuarios.
* Control de acceso basado en roles.
* Comunicación segura con los servicios protegidos.

---

## 🐳 Docker

El proyecto incluye configuración para ejecutar su infraestructura mediante contenedores.

```bash
docker compose up -d
```

Esto permite levantar los componentes necesarios del sistema de manera reproducible en diferentes entornos.

---

## 🎯 Objetivo del proyecto

Aplicar conceptos de arquitectura de microservicios mediante la construcción de un sistema académico distribuido, incorporando **seguridad, descubrimiento de servicios, configuración centralizada, persistencia de datos y contenedores**.

El proyecto busca demostrar la implementación de una solución backend escalable y modular utilizando tecnologías del ecosistema **Java y Spring**.

---

## 👨‍💻 Autor

**Adrian Gabriel Cardenas Lamas**

Desarrollo de Sistemas de Información

[GitHub](https://github.com/adrivng)
