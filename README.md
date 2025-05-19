# Organizer API

Uma API REST para gerenciamento de tarefas pessoais, desenvolvida em Java 17 utilizando Spring Boot. O objetivo do projeto é criar uma base sólida para um organizador de tarefas, com arquitetura limpa, testes automatizados, documentação completa e pronto para deployment via Docker.

## 📦 Tecnologias & Bibliotecas

* **Java 17**
* **Spring Boot** 3

  * Spring Web
  * Spring Data JPA
* **Banco de dados**: H2 (em memória)
* **OpenAPI (Swagger UI)** para documentação de endpoints
* **SpringDoc** para integração com OpenAPI
* **Docker** para empacotamento da aplicação
* **GitHub Actions** para CI/CD

## 🧠 Decisões Técnicas & Arquitetura

* **Arquitetura em camadas** (Domain, Application, Infrastructure, API)
* Separação clara de responsabilidades
* Uso de DTOs para comunicação com a API
* Entidades persistentes separadas de entidades de domínio (via JPA Entities)
* Manipulação de exceções centralizada com `@RestControllerAdvice`
* Documentação gerada automaticamente com SpringDoc

## 🧠 Uso de Inteligência Artificial

Este projeto foi construído com o auxílio da IA ChatGPT da OpenAI para:

* Gerar parte da estrutura inicial do projeto
* Criar Dockerfile, Docker Compose e workflows de CI/CD
* Elaborar mensagens de erro consistentes
* Gerar trechos de código repetitivos ou auxiliares
* Criar este README, com explicações técnicas e instruções

A IA foi usada como uma ferramenta de produtividade e aprendizado, com curadoria e ajustes humanos para manter a qualidade e clareza do projeto.

## 🚀 Executando a aplicação com Docker

### 1. Verifique se o Docker está instalado corretamente

```bash
docker -v
```

### 2. Inicie a aplicação com Docker Compose

```bash
docker compose up -d
```

> Isso irá iniciar a aplicação em modo destacado (background).

### 3. Caso ocorra algum erro de build, utilize:

```bash
docker compose up --build
```

> Isso forçará a reconstrução da imagem localmente.

A aplicação estará disponível em:

```
http://localhost:8080
```

## 📚 Documentação da API

Uma vez que a aplicação esteja rodando, acesse a documentação interativa gerada pelo OpenAPI:

```
http://localhost:8080/api/swagger-ui.html
```

Essa interface permite testar todos os endpoints da API, visualizar os modelos utilizados (DTOs) e entender o comportamento esperado da aplicação.

## 📦 Docker Hub

A imagem da aplicação está publicada em:

```
https://hub.docker.com/r/nesrux/organizer-api
```

## ✍️ Autor

**João Marcos**
[LinkedIn](https://www.linkedin.com/in/joaomarcosdev/) | [Email](mailto:joaomarcosdevs@gmail.com)

---

