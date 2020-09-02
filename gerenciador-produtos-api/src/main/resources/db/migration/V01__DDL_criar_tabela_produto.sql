/*
 * Script de criacao da tabela no banco em memoria H2
 * 
 * */ 

CREATE TABLE IF NOT EXISTS tb_produto (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	categoria VARCHAR(20) NOT NULL,
	valor DECIMAL(15,2) NOT NULL
)