    use losinvestigadores;
    create table facultad (
        cod int,
        nombre NVARCHAR(100),
        primary key (cod)
    );

    create table investigadores (
        DNI VARCHAR(8),
        nomApels NVARCHAR(255),
        facultad int,
        primary key (DNI),
        FOREIGN key (facultad)
        REFERENCES facultad (cod)
        on DELETE CASCADE
        on UPDATE CASCADE
    );

    create table equipos(
        numSer char(4),
        nombre NVARCHAR(100),
        facultades int,
        primary key (numSer),
        FOREIGN key (facultades)
        REFERENCES facultad (cod)
        on DELETE CASCADE
        on UPDATE CASCADE
    );

    create table reserva (
        DNI varchar(8),
        numSer char(4),
        comienzo datetime,
        fin datetime,
        primary key (DNI,numSer),
        FOREIGN key (DNI)
        REFERENCES investigadores(DNI)
        on DELETE CASCADE
        on UPDATE CASCADE,
        FOREIGN key (numSer)
        REFERENCES equipos (numSer)
        on DELETE CASCADE
        on UPDATE CASCADE
    );