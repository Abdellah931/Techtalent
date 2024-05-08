
USE tiendainfo;

CREATE TABLE fabricantes (
    codigo INT,
    nombre VARCHAR(100),
    PRIMARY KEY (codigo));

ALTER TABLE `fabricantes` CHANGE `codigo` `codigo` INT(11) NOT NULL AUTO_INCREMENT;

INSERT INTO `fabricantes` (`codigo`, `nombre`) VALUES (NULL, 'HP');
INSERT INTO fabricantes (nombre) VALUES ('LG');


CREATE TABLE articulos (
    codart INT  NOT NULL  AUTO_INCREMENT,
    nombre VARCHAR(100),
    precio FLOAT,
    fabricante INT,
    PRIMARY KEY (codart),
    FOREIGN KEY (fabricante) 
    REFERENCES fabricantes (codigo) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE);


    INSERT INTO fabricantes (nombre) VALUES ('HP'), ('LG');


    INSERT INTO articulos (nombre, precio, fabricante) VALUES 
('Laptop HP Pavilion', 800.0, 1),
('Monitor LG UltraWide', 300.0, 2),
('Impresora HP LaserJet', 250.0, 1),
('Teclado y ratón inalámbricos HP', 50.0, 1),
('Smartphone LG G8', 600.0, 2);


select nombre from articulos;

select nombre,precio from articulos;

select nombre from articulos
where precio =< 200;

select * from articulos
where precio between 60 and 120;

select nombre,precio ROUND(precio * 166.386) AS `Precio Pesetas` FROM articulos;

select AVG(precio) AS`precio medio` from articulos;

select AVG(precio) AS`precio medio` from articulos
where fabricantes = 2;

SELECT COUNT(codart) AS `Número de articulos` FROM articulos 
where precio >= 180;


SELECT nombre, precio FROM articulos 
WHERE precio >= 180 
ORDER BY precio DESC, nombre ASC;

select nombre, precio from articulos

SELECT articulos.nombre AS "Artículo", fabricantes.nombre AS "Fabricante", precio AS "Precio de artículos por cada fabricante" FROM articulos, fabricantes WHERE articulos.fabricante = fabricantes.codigo;
SELECT fabricantes.nombre AS "Fabricante", articulos.nombre AS "Artículo",  precio AS "Precio de artículos por cada fabricante" FROM articulos INNER JOIN fabricantes ON articulos.fabricante = fabricantes.codigo ORDER BY fabricantes.nombre;

SELECT fabricante AS "Código fabricante", ROUND(AVG(precio),2) AS "Media de precios" FROM articulos GROUP BY fabricante ORDER BY ROUND(AVG(precio),2);

SELECT f.nombre AS "Nombre fabricante", ROUND(AVG(a.precio),2) AS "Media de precios" FROM articulos a INNER JOIN fabricantes f
ON a.fabricante = f.codigo 
GROUP BY a.fabricante ORDER BY ROUND(AVG(a.precio),2);

SELECT f.nombre AS "Fabricantes AVG(a.precio) >= 150", ROUND(AVG(a.precio),2) AS "Precio Medio"
FROM articulos a INNER JOIN fabricantes f 
ON a.fabricante = f.codigo
GROUP BY f.nombre
HAVING AVG(a.precio) >= 150
ORDER BY AVG(a.precio);

select nombre,precio from articulos
where precio = (SELECT MIN(precio) FROM articulos);

SELECT a.nombre AS "Articulo más caro", a.precio, f.nombre AS "por Fabricante"
FROM articulos a, fabricantes f
WHERE a.fabricante = f.codigo AND a.precio = 
(
    SELECT MAX(ar.precio)
    FROM articulos ar
    WHERE ar.fabricante = f.codigo
)
ORDER BY a.fabricante;

INSERT INTO articulos (nombre, precio, fabricante) 
VALUES ('Altavoces LG', 69.99, 2);

UPDATE articulos 
SET nombre = 'Impresora Laser'
WHERE codart = 8;

UPDATE articulos 
SET precio = precio * 0.9;

UPDATE articulos
SET precio = precio - 10
WHERE precio >= 120;