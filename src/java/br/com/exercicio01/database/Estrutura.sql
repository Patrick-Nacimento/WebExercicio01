DROP DATABASE IF EXISTS exercicio_web_01;
CREATE DATABASE IF NOT EXISTS exercicio_web_01;
USE exercicio_web_01;

CREATE TABLE alunos(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100),
	codigoMatricula VARCHAR(10),
	nota1 DOUBLE,
	nota2 DOUBLE,
	nota3 DOUBLE,
	frequencia TINYINT,
	media DOUBLE,
	situacao VARCHAR(100)
);

INSERT INTO alunos (nome, codigoMatricula, nota1, nota2, nota3, frequencia, media, situacao) 
VALUES 
('Patrick Otavio', 0800471822, 7, 7, 7, 95, 7, 'APROVADO'),
('Otavio Nacimento', 8000221847, 10, 10, 10, 50, 10, 'REPROVADO POR FREQUENCIA');