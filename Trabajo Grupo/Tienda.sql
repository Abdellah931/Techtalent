
use Tienda;

CREATE TABLE producto(
IVA int,
Precio DOUBLE,
inventario int,
ID INT AUTO_INCREMENT,
Nombre varchar(20),
PRIMARY KEY (ID)
);

CREATE TABLE Compra (
    id_compra INT AUTO_INCREMENT,
    precio_total INT NOT NULL,
    primary KEY (id_compra)
);

create table secompone (
    id_com int AUTO_INCREMENT,
    id_producto int T,
    cantidad int,
    precio_articulos int,
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

CREATE TABLE ticket (
    id_compra INT,
    id_ticket INT AUTO_INCREMENT, 
    PRIMARY KEY (id_ticket),
    fOREIGN key (id_compra)
    REFERENCES compra(id_compra)    
    on DELETE CASCADE
    on UPDATE CASCADE); 
