use Empleados;

CREATE TABLE empleados (
    dni VARCHAR(9) NOT NULL,
    nombre NVARCHAR(100) NOT NULL,
    apellidos NVARCHAR(255),
    departamento INT,
    PRIMARY KEY (dni),
    FOREIGN KEY (departamento) 
    REFERENCES departamentos (codigo) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE);