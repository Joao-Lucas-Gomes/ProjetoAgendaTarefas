Agenda de Tarefas – API REST (Spring Boot)
==========================================

API REST desenvolvida em Java + Spring Boot, usando PostgreSQL e Docker, com deploy público no Render.
Permite criar, listar, atualizar e excluir tarefas, seguindo boas práticas de backend.

Demo Online
-----------
A API está disponível com Swagger UI para teste interativo:

https://agendatarefas-38rw.onrender.com/swagger-ui/index.html#/

Tecnologias
-----------
- Java 21
- Spring Boot 3
- Spring Web & Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Maven
- Render (Deploy em nuvem)

Estrutura do Projeto
-------------------
src/
 └── main/
     ├── java/            # controllers, services, repositories, models
     └── resources/       # application.properties, schema.sql / data.sql
Dockerfile
docker-compose.yml
pom.xml

Rodando com Docker
-----------------
Suba a aplicação e o banco com Docker Compose:

docker compose up --build

Para parar os contêineres:

docker compose down

A aplicação ficará disponível em http://localhost:8080.

Testando a API
--------------
A documentação Swagger fornece todos os endpoints:

GET    /tarefas          -> Lista todas as tarefas
GET    /tarefas/{id}     -> Retorna uma tarefa específica
POST   /tarefas          -> Cria uma nova tarefa
PUT    /tarefas/{id}     -> Atualiza uma tarefa
DELETE /tarefas/{id}     -> Remove uma tarefa

Swagger UI: https://agendatarefas-38rw.onrender.com/swagger-ui/index.html#/

Rodando localmente (modo dev)
-----------------------------
Clone o repositório:

git clone https://github.com/Joao-Lucas-Gomes/ProjetoAgendaTarefas.git
cd ProjetoAgendaTarefas

Execute com Maven:

mvn spring-boot:run

O banco deve estar rodando em localhost:5432 ou ajustado conforme o application.properties.

Build do JAR
------------
mvn clean package

Arquivo gerado:

target/aulaapijovemprogramador-0.0.1-SNAPSHOT.jar

Executar:

java -jar target/aulaapijovemprogramador-0.0.1-SNAPSHOT.jar

Deploy no Render
----------------
O projeto está configurado com:
- Dockerfile
- Docker Compose
- Deploy automático no Render via push no GitH
