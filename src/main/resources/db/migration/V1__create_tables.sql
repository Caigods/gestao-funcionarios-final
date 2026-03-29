CREATE TABLE usuarios (
                         id BIGSERIAL PRIMARY KEY,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         senha VARCHAR(255) NOT NULL
);

CREATE TABLE funcionario (
                             id BIGSERIAL PRIMARY KEY,
                             nome VARCHAR(255) NOT NULL,
                             data_admissao DATE NOT NULL,
                             salario NUMERIC(10,2) NOT NULL,
                             status VARCHAR(10) NOT NULL
);