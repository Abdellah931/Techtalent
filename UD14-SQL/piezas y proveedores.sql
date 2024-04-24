use PyProveedores;


create table suministros(
    codigo int AUTO_INCREMENT,
    id char(4),
    precio int,
    primary key(codigo,id),
    FOREIGN key (codigo)
    REFERENCES piezas(codigo)
    on DELETE CASCADE
    on UPDATE CASCADE,
    FOREIGN key (id)
    REFERENCES proveedores(id)
    on DELETE CASCADE
    on UPDATE CASCADE);
