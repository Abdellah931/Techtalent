use cursos;

CREATE TABLE profesores (
  dni_prof varchar(8) NOT NULL,
  nombre_prof varchar(12) NOT NULL,
  apellido1_prof varchar(12) DEFAULT NULL,
  apellido2_prof varchar(12) DEFAULT NULL,
  direccion varchar(100) DEFAULT NULL,
  titulo varchar(100) DEFAULT NULL,
  gana int(11) NOT NULL,
  UNIQUE (nombre_prof),
  PRIMARY KEY (dni_prof)
);

CREATE TABLE curso (
    cod_curso VARCHAR(2) NOT NULL,
    nombre_curso VARCHAR(20) NOT NULL,
    dni_profe VARCHAR(8),
    max_alum INT,
    fecha_inicio DATETIME,
    fecha_fin DATETIME,
    num_horas INT NOT NULL,
    PRIMARY KEY (cod_curso),
    FOREIGN KEY (dni_profe)
    REFERENCES profesores (dni_prof)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);



create table alumnos(
    DNI varchar(8)NOT NULL,
    nombre varchar(12)NOT NULL,
    apellido1 varchar(12)NOT NULL,
    apellido2 varchar(12),
    direccion varchar(100),
    sexo char,
    fecha_nacimiento datetime,
    curs varchar(2) NOT NULL,
    primary key (DNI),
    UNIQUE (nombre),
    FOREIGN key (curs)
    REFERENCES curso (cod_curso)
    on DELETE CASCADE
    on UPDATE CASCADE
);
