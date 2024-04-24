CREATE DATABASE Tienda;
use Tienda;
CREATE TABLE Compra (
    id_compra INT AUTO_INCREMENT,
    precio_total INT NOT NULL,
    devolucion VARCHAR(255),
    nombre_producto varchar(20),
    cantidad int,
    primary KEY (id_compra)
);

create table secompone (
    id_com int AUTO_INCREMENT,
    id_producto int AUTO_INCREMENT,
    cantidad int,
    primary key (id_com,id_producto),
    fOREIGN key (id_com)
    REFERENCES compra (id_compra)
    on DELETE CASCADE
    on UPDATE CASCADE,
    fOREIGN key(id_producto)
    REFERENCES producto (ID)
    on DELETE CASCADE
    on UPDATE CASCADE
);