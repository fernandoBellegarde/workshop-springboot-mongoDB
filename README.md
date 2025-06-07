# 📝 Workshop Spring Boot + MongoDB

Este projeto é uma API RESTful criada com Spring Boot e MongoDB. Ele faz parte de um workshop prático com o objetivo de demonstrar o uso de banco de dados NoSQL com Spring Data MongoDB, modelagem de dados em documentos, DTOs e operações básicas de CRUD.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Postman (para testes de endpoints)
- Maven

---

## 📦 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com.fernandobell.workshopmongo/
│   │       ├── config/               # Configurações iniciais e instanciamento de dados
│   │       ├── controllers/          # Controladores REST
│   │       ├── domain/               # Entidades principais (User, Post)
│   │       ├── repository/           # Interfaces de repositórios
│   │       ├── services/             # Regras de negócio
│   │       └── UserDTO/              # DTOs (AuthorDTO, CommentDTO)
│   └── resources/
│       └── application.properties    # Configurações do MongoDB
```

---

## 📋 Funcionalidades

- 🔍 Listagem de usuários
- 👤 Criação, atualização e remoção de usuários
- 📝 Criação e listagem de posts
- 💬 Inclusão de comentários nos posts
- 🔗 Associação entre usuários e seus posts

---

## 📁 Exemplo de Documento no MongoDB

### 🔹 Post

```json
{
  "_id": "abc123",
  "date": "2018-03-21T00:00:00Z",
  "title": "Partiu viagem!",
  "body": "Vou viajar para São Paulo. Abraços!",
  "author": {
    "id": "user123",
    "name": "Maria Brown"
  },
  "comments": [
    {
      "text": "Boa viagem mano!",
      "date": "2018-03-21",
      "author": {
        "id": "alex123",
        "name": "Alex Green"
      }
    }
  ]
}
```

---

## 📌 Como Rodar o Projeto

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/workshopmongo.git
```

2. Navegue até a pasta do projeto e instale as dependências:
```bash
cd workshopmongo
./mvnw install
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

4. Certifique-se de que o MongoDB está rodando na porta padrão (`27017`). A aplicação irá popular automaticamente o banco com usuários e posts.

---

## 📮 Endpoints Exemplos

| Método | Endpoint            | Descrição                  |
|--------|---------------------|----------------------------|
| GET    | `/users`            | Lista todos os usuários    |
| POST   | `/users`            | Cria um novo usuário       |
| GET    | `/posts`            | Lista todos os posts       |
| POST   | `/posts`            | Cria um novo post          |
| GET    | `/users/{id}/posts` | Lista posts de um usuário  |

---

## 🧠 Conceitos Demonstrados

- DTOs (Data Transfer Objects)
- Agregação de dados em documentos
- Relacionamento entre documentos (via composição)
- Serialização JSON com Jackson
- Spring Boot REST Controllers
- Spring Data MongoDB

---

## 👨‍💻 Autor

Desenvolvido por **Fernando Bellegarde** 🧑‍💻  

---

## 🧪 Testes

Você pode testar os endpoints usando o [Postman](https://www.postman.com/) com requisições HTTP no `localhost:8080`.

