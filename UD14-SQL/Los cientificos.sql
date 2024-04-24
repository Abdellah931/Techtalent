use loscientificos;
create table cientificos (
    DNI VARCHAR(8),
    nomApels NVARCHAR(255),
    primary key (DNI)
);

create table proyecto(
    Id char(4),
    nombre NVARCHAR(255),
    horas int,
    primary key (ID)
);

CREATE TABLE asignado (
    DNI VARCHAR(8),
    Id char(4),
    primary key (DNI,Id),
    FOREIGN key (DNI)
    REFERENCES cientificos (DNI)
    on DELETE CASCADE
    on UPDATE CASCADE,
    FOREIGN key (Id)
    REFERENCES proyecto (Id)
    on DELETE CASCADE
    on UPDATE CASCADE
);