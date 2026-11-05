# Sistema de Gestión de Matrículas

Sistema backend con **arquitectura de microservicios** para gestionar estudiantes, cursos y matrículas de un instituto.

Implementa servicios independientes, configuración centralizada, descubrimiento de servicios, autenticación con OAuth2 y despliegue con Docker.

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-6DB33F?logo=springboot&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-Microservices-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Containers-2496ED?logo=docker&logoColor=white)
![Keycloak](https://img.shields.io/badge/Keycloak-OAuth2-purple)

## Tecnologías

- **Backend:** Java, Spring Boot
- **Arquitectura:** Microservicios, Spring Cloud
- **Base de datos:** MySQL
- **Seguridad:** Keycloak, OAuth2
- **Infraestructura:** Docker, Eureka Server, Config Server

## Arquitectura

El sistema está dividido en servicios independientes:

| Servicio | Descripción |
|----------|-------------|
| **ms-estudiante** | Gestiona la información y operaciones de los estudiantes. |
| **ms-curso** | Administra cursos, horarios e información académica asociada. |
| **ms-matricula** | Gestiona las matrículas y la relación entre estudiantes y cursos. |
| **ms-eureka** | Registro y descubrimiento dinámico de los microservicios. |
| **config-server** | Centraliza la configuración de los diferentes servicios. |
| **Keycloak** | Autenticación y autorización mediante OAuth2 y roles de usuario. |

## Estructura del proyecto

```text
gestion-matriculas/
├── config-repo/        # Configuración centralizada
├── config-server/      # Spring Cloud Config Server
├── ms-curso/           # Microservicio de cursos
├── ms-estudiante/      # Microservicio de estudiantes
├── ms-eureka/          # Service Discovery
├── ms-matricula/       # Microservicio de matrículas
├── docker-compose.yml
├── init.sql
└── keycloak-realm.json
```

## Funcionalidades principales

- Gestión de estudiantes.
- Gestión de cursos.
- Registro y administración de matrículas.
- Comunicación entre microservicios.
- Descubrimiento de servicios mediante Eureka.
- Configuración centralizada mediante Spring Cloud Config.
- Seguridad basada en roles.
- Autenticación y autorización con Keycloak y OAuth2.
- Persistencia de información en MySQL.
- Contenedorización de los servicios con Docker.

## Seguridad

La seguridad se gestiona con **Keycloak**, utilizando OAuth2 para controlar el acceso a los recursos. Esto permite:

- Autenticación mediante tokens.
- Protección de endpoints.
- Administración de usuarios.
- Control de acceso basado en roles.
- Comunicación segura con los servicios protegidos.

## Docker

El proyecto incluye configuración para ejecutar su infraestructura mediante contenedores:

```bash
docker compose up -d
```

Esto permite levantar los componentes necesarios del sistema de forma reproducible en diferentes entornos.

## Objetivo del proyecto

Aplicar conceptos de arquitectura de microservicios mediante la construcción de un sistema académico distribuido, incorporando **seguridad, descubrimiento de servicios, configuración centralizada, persistencia de datos y contenedores**.

El proyecto busca demostrar una solución backend escalable y modular con tecnologías del ecosistema **Java y Spring**.

## Autor

**Adrian Gabriel Cardenas Lamas**
Desarrollo de Sistemas de Información
[GitHub: @adrivng](https://github.com/adrivng)
