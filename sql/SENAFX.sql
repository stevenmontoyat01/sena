
CREATE database sena;
USE sena;

CREATE TABLE personas (
  id int PRIMARY KEY AUTO_INCREMENT,
  identificacion char(20) NULL,
  nombre varchar(45) NULL,
  apellido varchar(45) NULL,
  edad varchar(45) NULL,
  tipo int NULL,
  email VARCHAR(100) NULL
);

CREATE TABLE tipo (
  idtipo int not null PRIMARY KEY AUTO_INCREMENT,
  Descripcion char(20) NULL
);

ALTER TABLE tipo ADD FOREIGN KEY (idtipo) REFERENCES personas(id);

CREATE TABLE cursos (
  codigo int not null PRIMARY KEY AUTO_INCREMENT,
  nombre varchar(45) NULL,
  instructor INT NULL
);

ALTER TABLE cursos ADD FOREIGN KEY (instructor) REFERENCES personas(id);

CREATE TABLE horarios (
  idHorario int not null PRIMARY KEY AUTO_INCREMENT,
  curso INT NULL,
  fecha DATE NULL,
  hora time
);

ALTER TABLE horarios ADD FOREIGN KEY (curso) REFERENCES cursos(codigo);

CREATE TABLE registro_cursos (
	id_registro INT AUTO_INCREMENT PRIMARY KEY,
    alumno INT NULL,
    curso  INT NULL
);

ALTER TABLE registro_cursos ADD FOREIGN KEY (alumno) REFERENCES personas(id);
ALTER TABLE registro_cursos ADD FOREIGN KEY (curso) REFERENCES cursos(codigo);


/*------------------------------------------------------------------------------------------*/
CREATE USER 'sena'@'localhost' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON sena.* TO 'sena'@'localhost';
FLUSH PRIVILEGES;