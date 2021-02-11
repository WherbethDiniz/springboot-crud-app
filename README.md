# Spring Boot, MySQL, JPA, Hibernate

Aplicação utilizando Spring Boot, MySQL, JPA e Hibernate.

## Passos para o SETUP

**1. Importar o projeto**

- Importe o projeto para sua IDE de sua preferência.

**2. Crie o banco de dados no MySQL**

```
create database cliente
```

**3. Modifique o usuário e senha de acordo com a sua instalação**

- Abra `src/main/resources/application.properties`
- Modifique `spring.datasource.username` e `spring.datasource.password` de acordo com sua instalação.

## Explore as APIs

- A aplicação define as APIs abaixo.

- Você pode testar as APIs utilizando o Postman.

```
Exemplo de como realizar o teste por id:
http://localhost:8080/api/v1/clientes/1

GET /api/v1/clientes
POST /api/v1/clientes
GET /api/v1/clientes/{id}
PUT /api/v1/clientes/{id}
DELETE /api/v1/clientes{id}
```

