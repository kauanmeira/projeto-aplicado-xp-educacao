# 🧠 Desafio Final - Bootcamp Arquiteto(a) de Software

Este repositório contém a solução desenvolvida por mim, **Kauan Gabriel Paiva Meira**, para o desafio final do **Bootcamp de Arquitetura de Software**, como parte do curso de Pós-Graduação em Arquitetura de Software.

---

## 📌 Descrição do Projeto

O desafio consistiu em aplicar, na prática, os conhecimentos adquiridos ao longo do bootcamp, através do desenvolvimento de uma API REST utilizando **Java com Spring Boot**. O domínio escolhido foi o de **Clientes**, com foco na implementação de boas práticas de arquitetura, modelagem de entidades, exposição de endpoints RESTful, persistência de dados e documentação da API.

---

## 🚀 Tecnologias e Ferramentas Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Swagger (OpenAPI)**
- **Maven**
- **IntelliJ IDEA / VS Code**

---

## 🧱 Estrutura de Pastas
```
src/main/java/com/xp_educacao/projeto_aplicado/
├── component/
│ └── ClienteComponent.java
├── controller/
│ └── ClienteController.java
├── dto/
│ ├── ClienteDto.java
│ └── TipoDocumento.java
├── mapper/
│ └── ClienteMapper.java
├── model/
│ └── Cliente.java
├── repository/
│ └── ClienteRepository.java
├── service/
│ └── cliente/
│ ├── ClienteService.java
│ └── ClienteServiceImpl.java
└── ProjetoAplicadoApplication.java
```

---

## 🔧 Como Executar o Projeto

### Pré-requisitos

- Java 17+
- Maven
- PostgreSQL (ou Docker)
- Git

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/kauanmeira/projeto-aplicado-xp-educacao.git
   cd seu-repositorio
2. Configure o banco de dados no application.yaml com suas variáveis de ambiente ou use o modelo abaixo:
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/seu_banco
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```
3. Execute a aplicação:
```
./mvnw spring-boot:run
```
4. Acesse a documentação da API:
http://localhost:8181/swagger-ui/index.html

✅ Funcionalidades Implementadas
- Cadastro de cliente
- Listagem de todos os clientes
- Busca por ID e por nome
- Atualização de dados do cliente
- Exclusão de cliente
- Validação de tipo e formato de documento (CPF/CNPJ)
- Documentação automática com Swagger

