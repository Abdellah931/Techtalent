use Peliculas;
CREATE TABLE pelicula (
    codigo int AUTO_INCREMENT not null,
    nombre NVARCHAR(100) not null,
    califiacionEdad int not null,
    PRIMARY key (codigo));

create TABLE salas (
    codigoS int AUTO_INCREMENT not null,
    nombre NVARCHAR(100) not null ,
    pelicula int,
    PRIMARY key (codigoS),
    FOREIGN key (pelicula)
    REFERENCES pelicula(codigo)
    on DELETE set null
    on UPDATE CASCADE);

INSERT INTO pelicula (nombre, califiacionEdad) VALUES
('Pelicula A', 18),
('Pelicula B', 12),
('Pelicula C', 15),
('Pelicula D', 12),
('Pelicula E', 18),
('Pelicula F', 15),
('Pelicula G', 12),
('Pelicula H', 18),
('Pelicula I', 15),
('Pelicula J', 12);


INSERT INTO salas (nombre, pelicula) VALUES
('Sala 1', 1),
('Sala 2', 2),
('Sala 3', 3),
('Sala 4', 4),
('Sala 5', 5),
('Sala 6', 6),
('Sala 7', 7),
('Sala 8', 8),
('Sala 9', 9),
('Sala 10', 10);


SELECT nombre from pelicula;

SELECT califiacionEdad from pelicula;

SELECT nombre from salas
where pelicula = 'null'

select * from pelicula,salas


SELECT s.codigo, s.nombre AS nombre_pelicula, p.nombre AS nombre_sala, p.pelicula AS calificacion_edad
FROM pelicula s
LEFT JOIN salas p ON s.salas = p.codigoS;

SELECT p.codigo, p.nombre AS nombre_pelicula, p.califiacionEdad AS calificacion_edad, s.codigoS, s.nombre AS nombre_sala
FROM pelicula p
LEFT JOIN salas s ON p.codigo = s.pelicula;


SELECT p.nombre AS nombre_pelicula
FROM pelicula p
LEFT JOIN salas s ON p.codigo = s.pelicula
WHERE s.pelicula IS NULL;


INSERT INTO pelicula (codigo,nombre,califiacionEdad) VALUES
(33,'Uno,Dos,Tres',7)

UPDATE pelicula
SET califiacionEdad = 'no recomendables para menores de 13 años'
WHERE califiacionEdad IS NULL;

DELETE FROM salas
WHERE pelicula IN (SELECT codigo FROM pelicula WHERE califiacionEdad = 0);