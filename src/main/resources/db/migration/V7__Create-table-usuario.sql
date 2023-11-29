CREATE TABLE usuarios (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         nome VARCHAR(255) NOT NULL,
                         senha VARCHAR(255) not null,
                         role varchar(20) not null,

                         PRIMARY KEY (id)
);