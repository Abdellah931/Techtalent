use Almacenes;


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