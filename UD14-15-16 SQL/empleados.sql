use Empleados;

CREATE TABLE departamentos (
    codigo INT AUTO_INCREMENT,
    nombre NVARCHAR(100) NOT NULL,
    presupuesto INT,
    PRIMARY KEY (codigo));

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

    INSERT INTO departamentos (nombre, presupuesto) VALUES
('Departamento A', 100000),
('Departamento B', 150000),
('Departamento C', 200000),
('Departamento D', 120000),
('Departamento E', 180000),
('Departamento F', 90000),
('Departamento G', 220000),
('Departamento H', 130000),
('Departamento I', 170000),
('Departamento J', 140000);


INSERT INTO empleados (dni, nombre, apellidos, departamento) VALUES
('111111111', 'Empleado1', 'Apellido1', 1),
('222222222', 'Empleado2', 'Apellido2', 2),
('333333333', 'Empleado3', 'Apellido3', 3),
('444444444', 'Empleado4', 'Apellido4', 4),
('555555555', 'Empleado5', 'Apellido5', 5),
('666666666', 'Empleado6', 'Apellido6', 6),
('777777777', 'Empleado7', 'Apellido7', 7),
('888888888', 'Empleado8', 'Apellido8', 8),
('999999999', 'Empleado9', 'Apellido9', 9),
('123456789', 'Empleado10', 'Apellido10', 10);

select apellidos from empleados;

select distinct apellidos from empleados;

select * from empleados
where apellidos = 'lopez';

select * from empleados
where apellidos = 'lopez' or
apellidos = 'perez';

select * from empleados
where departamentos= 14;

select * from empleados
where departamentos= 77 and
departamentos = 37;

Select * from empleados
where nombre = P%;

SELECT SUM(presupuesto) AS "Suma de presupuestos" FROM departamentos;

select departamento,count(*) as 'numero de empleados' from empleados
group by departamentos

select * from empleados;

select empleados.nombre, empleados.apellidos, departamentos.nombre, departamentos.presupuesto
from empleados e inner join departamentos d
on e.departamento = d.codigo;

select nombre,apellidos from empleados
where presupuesto >= 60000



SELECT * FROM departamentos
where presupuesto = ( MAX(`media presupuestos`)
from (
    select AVG(presupuesto) as `media presupuestos` from departamentos
    group by codigo

) AS `max media`);

select nombre from departamento
where empleados > 2;

insert into departamento (codigo,nombre,presupuesto) values
(11,'Calidad',40000);

insert into empleado (dni,nombre,apellidos,departamento) values
(89267109,'Esther','Vazquez',11);

UPDATE departamentos
set presupuesto = presupuesto * 0,9;

UPDATE empleados 
set departamento = 14
where departamento = 77;

DELETE FROM Empleados
where departamento = 14;

delete from Empleados
where presupuesto in
    (SELECT codigo FROM departamentos
    WHERE presupuesto >= 60000);

delete from empleados;