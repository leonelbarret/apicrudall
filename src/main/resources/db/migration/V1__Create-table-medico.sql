CREATE TABLE medicos (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         nome VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         crm VARCHAR(15) NOT NULL,
                         especialidade varchar(180) NOT NULL,
                         logradouro varchar(100) not null,
                         bairro varchar(50) not null,
                         cep varchar(9) not null,
                         numero varchar(20) not null,
                         uf varchar(2),
                         cidade varchar(100),
                         PRIMARY KEY (id)
);