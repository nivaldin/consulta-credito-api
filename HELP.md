# Consulta Crédito API

Este projeto é uma API REST desenvolvida em Java com Spring Boot para consulta de créditos fiscais, como parte de um desafio técnico.

## Estrutura do Projeto

- **Spring Boot** 3.5.0
- **Java** 17
- **Banco de Dados:** PostgreSQL
- **ORM:** Spring Data JPA
- **Testes:** JUnit 5, Mockito

## Como executar

1. Certifique-se de ter o PostgreSQL rodando e crie o banco `desafio`:
   ```sql
   CREATE DATABASE desafio;
   ```
2. Configure o acesso ao banco em [`src/main/resources/application.properties`](src/main/resources/application.properties) se necessário.
3. Compile e execute o projeto:
   ```sh
   ./mvnw spring-boot:run
   ```
   ou
   ```sh
   mvnw.cmd spring-boot:run
   ```
4. A API estará disponível em [http://localhost:8080](http://localhost:8080).

## Endpoints principais

- `GET /api/creditos/{numeroNfse}`  
  Consulta créditos pelo número da NFSe.
- `GET /api/creditos/credito/{numeroCredito}`  
  Consulta créditos pelo número do crédito.

## Executando os testes

```sh
./mvnw test
```

## Tecnologias e dependências

- [Spring Boot Starter Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Boot Starter Web](https://spring.io/projects/spring-boot)
- [PostgreSQL Driver](https://jdbc.postgresql.org/)
- [Lombok](https://projectlombok.org/)
- [JUnit 5](https://junit.org/junit5/)
- [Mockito](https://site.mockito.org/)

## Observações

- O pacote base do projeto é `br.com.nivaldoservices.consulta_credito_api`.
- O projeto utiliza Lombok para reduzir boilerplate.
- O banco de dados é atualizado automaticamente (`spring.jpa.hibernate.ddl-auto=update`).

