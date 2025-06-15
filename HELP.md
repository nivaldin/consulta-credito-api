# Consulta Crédito API

API REST em Java (Spring Boot) para consulta de créditos fiscais.

## Tecnologias

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Docker/Docker Compose
- JUnit 5, Mockito
- Lombok

## Como executar localmente

1. **Suba o banco de dados e a API com Docker Compose:**
   ```sh
   docker-compose up --build
   ```
   Isso irá:
   - Criar o banco `desafio` no PostgreSQL (porta 5432)
   - Executar scripts de criação e carga inicial em [`initdb/`](initdb/)
   - Subir a API na porta 8080

2. **Configuração manual (sem Docker):**
   - Crie o banco `desafio` no PostgreSQL:
     ```sql
     CREATE DATABASE desafio;
     ```
   - Ajuste as variáveis de ambiente ou edite [`src/main/resources/application.properties`](src/main/resources/application.properties) com as credenciais do banco.
   - Compile e execute:
     ```sh
     ./mvnw spring-boot:run
     ```

## Endpoints principais

- `GET /api/creditos/{numeroNfse}`  
  Consulta créditos pelo número da NFSe.

- `GET /api/creditos/credito/{numeroCredito}`  
  Consulta créditos pelo número do crédito.

## Scripts SQL

- [`initdb/01_init_table.sql`](initdb/01_init_table.sql): Criação da tabela `credito`
- [`initdb/02_init_insert.sql`](initdb/02_init_insert.sql): Dados de exemplo

## Testes

Execute os testes automatizados:
```sh
./mvnw test
```

## Estrutura principal do projeto

- [`src/main/java/br/com/nivaldoservices/consulta_credito_api/`](src/main/java/br/com/nivaldoservices/consulta_credito_api/): Código fonte principal
- [`src/test/java/br/com/nivaldoservices/consulta_credito_api/`](src/test/java/br/com/nivaldoservices/consulta_credito_api/): Testes automatizados

## Observações

- O projeto utiliza variáveis de ambiente para configuração do banco em produção.
- O banco de dados é atualizado automaticamente (`spring.jpa.hibernate.ddl-auto=update`).
- O projeto utiliza Lombok para reduzir código boilerplate.

---
```// filepath: HELP.md
# Consulta Crédito API

API REST em Java (Spring Boot) para consulta de créditos fiscais.

## Tecnologias

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Docker/Docker Compose
- JUnit 5, Mockito
- Lombok

## Como executar localmente

1. **Suba o banco de dados e a API com Docker Compose:**
   ```sh
   docker-compose up --build
   ```
   Isso irá:
   - Criar o banco `desafio` no PostgreSQL (porta 5432)
   - Executar scripts de criação e carga inicial em [`initdb/`](initdb/)
   - Subir a API na porta 8080

2. **Configuração manual (sem Docker):**
   - Crie o banco `desafio` no PostgreSQL:
     ```sql
     CREATE DATABASE desafio;
     ```
   - Ajuste as variáveis de ambiente ou edite [`src/main/resources/application.properties`](src/main/resources/application.properties) com as credenciais do banco.
   - Compile e execute:
     ```sh
     ./mvnw spring-boot:run
     ```

## Endpoints principais

- `GET /api/creditos/{numeroNfse}`  
  Consulta créditos pelo número da NFSe.

- `GET /api/creditos/credito/{numeroCredito}`  
  Consulta créditos pelo número do crédito.

## Scripts SQL

- [`initdb/01_init_table.sql`](initdb/01_init_table.sql): Criação da tabela `credito`
- [`initdb/02_init_insert.sql`](initdb/02_init_insert.sql): Dados de exemplo

## Testes

Execute os testes automatizados:
```sh
./mvnw test
```

## Estrutura principal do projeto

- [`src/main/java/br/com/nivaldoservices/consulta_credito_api/`](src/main/java/br/com/nivaldoservices/consulta_credito_api/): Código fonte principal
- [`src/test/java/br/com/nivaldoservices/consulta_credito_api/`](src/test/java/br/com/nivaldoservices/consulta_credito_api/): Testes automatizados

## Observações

- O projeto utiliza variáveis de ambiente para configuração do banco em produção.
- O banco de dados é atualizado automaticamente (`spring.jpa.hibernate.ddl-auto=update`).
- O projeto utiliza Lombok para reduzir código boilerplate.