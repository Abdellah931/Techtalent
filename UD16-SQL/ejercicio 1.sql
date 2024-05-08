UPDATE articulos
SET precio = precio - 10
WHERE precio >= 120;


DELETE FROM empleados
WHERE codigo_dep = 14