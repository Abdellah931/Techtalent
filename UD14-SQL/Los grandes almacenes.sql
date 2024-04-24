use losgrandesalmacenes;
create table cajeros (
    codigo int AUTO_INCREMENT,
    nomApels NVARCHAR(255),
    primary key (codigo)
);

create table productos (
    codigo int AUTO_INCREMENT,
    nombre NVARCHAR(100),
    precio int,
    primary key (codigo)
);

create table maquinas_registradoras (
    codigo int AUTO_INCREMENT,
    piso int,
    primary key (codigo)
);

create table venta (
    cajero int,
    maquina int,
    producto int,
    primary key(cajero,maquina,producto),
    FOREIGN key (cajero)
    REFERENCES cajeros (codigo)
    on DELETE CASCADE
    on UPDATE CASCADE,
    FOREIGN key (maquina)
    REFERENCES maquinas_registradoras (codigo)
    on DELETE CASCADE
    on UPDATE CASCADE,
    FOREIGN key (producto)
    REFERENCES productos (codigo)
    on DELETE CASCADE
    on UPDATE CASCADE
);