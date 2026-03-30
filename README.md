# Gestão de Funcionários

Aplicação Full Stack para gestão de funcionários, desenvolvida como teste prático para a vaga de Desenvolvedor Junior.

---

## Tecnologias Utilizadas

- **Backend:** Java 21 com Spring Boot
- **ORM:** Spring Data JPA
- **Database Migration:** FlywayDB
- **Frontend:** JavaScript com React.js
- **Banco de Dados:** PostgreSQL
- **Infraestrutura:** Docker e Docker Compose
- **Controle de Versão:** Git e GitHub

---

## Pré-requisitos

- [Docker](https://www.docker.com/products/docker-desktop)
- [Docker Compose](https://docs.docker.com/compose/)

---

## Como Rodar

1. Clone o repositório:
```bash
git clone https://github.com/Caigods/gestao-funcionarios-final.git
cd gestao-funcionarios-final
```

2. Suba a aplicação:
```bash
docker-compose up --build
```

3. Acesse no navegador:
```
http://localhost
```

---

## Credenciais de Acesso

| Campo | Valor |
|-------|-------|
| E-mail | admin@admin.com |
| Senha | admin |

---

## Estrutura do Projeto

```
gestao-funcionarios/
├── src/                  # Código fonte do backend
├── frontend/             # Código fonte do frontend
├── docker-compose.yml    # Orquestração dos containers
├── Dockerfile            # Build do backend
└── README.md
```

---

## Funcionalidades

- Autenticação com e-mail e senha
- Listagem de funcionários
- Cadastro de novos funcionários
- Proteção de rotas com JWT


## Assinatura
Caigods / Caique Godinho
