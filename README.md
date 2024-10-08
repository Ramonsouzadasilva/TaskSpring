# Task Api

Este projeto é uma API de gerenciamento de tarefas que permite aos usuários visualizar informações detalhadas sobre suas tarefas. Ele exibe o status de cada tarefa, o número de dias restantes até o vencimento e se a tarefa está vencida ou não.

## Java - Spring

- **Java 21**: Foi a Linguagem escolhida para o desenvolvimento do projeto.

- **Spring Framework**: Utilizado para construir a API.

- **H2 Database**: Um banco de dados em memória leve, ideal para desenvolvimento e testes. Ele permite um rápido armazenamento e recuperação de dados, facilitando a manipulação das tarefas.

- **Lombok**: Uma biblioteca que gera automaticamente métodos comuns como getters, setters e construtores, melhorando a legibilidade e a manutenção do código.

## Documentação da API

## Endpoints

### 1. Listar Tarefas

- **Método:** `GET`
- **Endpoint:** `/tasks`
- **Descrição:** Retorna uma lista de todas as tarefas.
- **Resposta:**
  - **Código 200 (OK)**
  - **Corpo da Resposta:**
    ```json
    [
      {
        "name": "Tarefa 1",
        "description": "Descrição da tarefa 1",
        "dueDate": "20/10/2024",
        "remainingDaysMessage": "13 days remaining.",
        "status": "Open"
      },
      ...
    ]
    ```

### 2. Criar Tarefa

- **Método:** `POST`
- **Endpoint:** `/tasks`
- **Descrição:** Cria uma nova tarefa.
- **Requisição:**
  - **Corpo:**
    ```json
    {
      "name": "Nova Tarefa",
      "description": "Descrição da nova tarefa",
      "dueDate": "15/10/2024"
    }
    ```
- **Resposta:**
  - **Código 201 (Created)**
  - **Corpo da Resposta:**
    ```json
    {
      "name": "Nova Tarefa",
      "description": "Descrição da nova tarefa",
      "dueDate": "15/10/2024",
      "remainingDaysMessage": "x days remaining.",
      "status": "Open"
    }
    ```

### 3. Buscar Tarefa por ID

- **Método:** `GET`
- **Endpoint:** `/tasks/{id}`
- **Descrição:** Retorna uma tarefa específica pelo ID.
- **Parâmetros:**
  - `id`: ID da tarefa a ser buscada.
- **Resposta:**
  - **Código 200 (OK)**
  - **Corpo da Resposta:**
    ```json
    {
      "name": "Tarefa 1",
      "description": "Descrição da tarefa 1",
      "dueDate": "20/10/2024",
      "remainingDaysMessage": "13 days remaining.",
      "status": "Open"
    }
    ```
  - **Código 404 (Not Found)** se a tarefa não for encontrada.

### 4. Deletar Tarefa

- **Método:** `DELETE`
- **Endpoint:** `/tasks/{id}`
- **Descrição:** Deleta uma tarefa específica pelo ID.
- **Parâmetros:**
  - `id`: ID da tarefa a ser deletada.
- **Resposta:**
  - **Código 204 (No Content)** se a tarefa for deletada com sucesso.

## Considerações Finais

A API está em conformidade com o padrão REST e retorna dados em formato JSON.
