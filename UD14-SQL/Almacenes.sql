use Almacenes;

CREATE TABLE almacen(
    codigo int,
    lugar VARCHAR(100),
    capacidad int,
    PRIMARY key (codigo)
)

CREATE TABLE cajas (
    numReferencia CHAR(5) not null,
    contenido NVARCHAR(100),
    valor int,
    almacenA int,
    PRIMARY key(numReferencia),
    FOREIGN key (almacenA)
    REFERENCES almacen (codigo)
    on DELETE CASCADE
    on UPDATE CASCADE);

    INSERT INTO almacen (codigo, lugar, capacidad) VALUES
(1, 'Almacén A', 100),
(2, 'Almacén B', 150),
(3, 'Almacén C', 200),
(4, 'Almacén D', 120),
(5, 'Almacén E', 180),
(6, 'Almacén F', 90),
(7, 'Almacén G', 220),
(8, 'Almacén H', 130),
(9, 'Almacén I', 170),
(10, 'Almacén J', 140);

INSERT INTO cajas (numReferencia, contenido, valor, almacenA) VALUES
('00001', 'Documentos', 50, 1),
('00002', 'Electrónicos', 200, 2),
('00003', 'Ropa', 100, 3),
('00004', 'Alimentos', 150, 4),
('00005', 'Herramientas', 80, 5),
('00006', 'Juguetes', 120, 6),
('00007', 'Libros', 70, 7),
('00008', 'Artículos de decoración', 90, 8),
('00009', 'Productos de limpieza', 60, 9),
('00010', 'Material de oficina', 110, 10);

select * from almacen;

select * from cajas
where valor > 150;

select contenido from cajas;

select AVG(valor) from cajas;

select ROUND(AVG(valor)) as 'media' from cajas;

select almacenA,ROUND(AVG(valor)) as 'media' from cajas
group by almacen;

-- Valor medio por cada almacén
--  SELECT almacenA, AVG(valor) from cajas GROUP BY almacenA;

-- Cuenta cuantas cajas tiene cada almacén
-- SELECT almacenA, COUNT(numReferencia) FROM cajas GROUP BY almacenA;


SELECT almacenA AS "Número almacén con valor medio >150€" FROM cajas GROUP BY almacenA HAVING AVG(valor) > 150;


select numReferencia, lugar FROM almacen,cajas
WHERE almacenA=codigo

select count(*) as `num cajas`,almacenA from cajas group by almacenA;


SELECT codigo, COUNT(nref), lugar
FROM almacenes a LEFT JOIN cajas c
ON a.codigo = c.almacen
GROUP BY codigo;

SELECT c.nref AS "bilbao cajas"
FROM cajas c RIGHT JOIN almacenes a 
ON c.almacen = a.codigo
WHERE a.lugar = 'bilbao';

INSERT into almacen (codigo,lugar,capacidad) VALUES
(333,'Barcelona',3);

INSERT int cajas (numReferencia,contenido,valor,almacenA) VALUES
('H5RT','Papel',200,2);

UPDATE cajas
set valor = valor * 0,85

UPDATE cajas
set valor = valor * 0,80
WHERE valor 

UPDATE cajas
SET valor = CASE
   WHEN valor > (SELECT AVG(valor) FROM cajas) THEN valor * 0.80
   ELSE valor
END;

DELETE * FROM cajas
WHERE valor < 100

DELETE FROM cajas
WHERE almacenA IN (
    SELECT almacenA
    FROM cajas
    GROUP BY almacenA
    HAVING COUNT(*) > (SELECT capacidad FROM almacen WHERE codigo = almacenA)
);




