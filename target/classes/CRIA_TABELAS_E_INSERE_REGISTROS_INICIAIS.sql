CREATE TABLE exame (
	rowid BIGINT AUTO_INCREMENT, 
	nm_exame VARCHAR(255)
);
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue');

CREATE TABLE funcionario (
	rowid BIGINT auto_increment,
	nm_funcionario VARCHAR(255)
);
INSERT INTO funcionario (nm_funcionario) VALUES ('Erick'), ('Bruno'), ('Vitor'), ('Lucas');

CREATE TABLE exame_realizado (
	rowid BIGINT AUTO_INCREMENT,
	id_exame BIGINT, 
	id_funcionario BIGINT, 
	dt_exame_realizado DATE
);
INSERT INTO exame_realizado (id_exame, id_funcionario, dt_exame_realizado) VALUES
(1, 1, '2024-08-01'),
(2, 2, '2024-08-02'),
(3, 3, '2024-08-03'),
(4, 4, '2024-08-04');
