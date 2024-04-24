use Peliculas;
CREATE TABLE pelicula (
    codigo int AUTO_INCREMENT not null,
    nombre NVARCHAR(100) not null,
    califiacionEdad int not null,
    PRIMARY key (codigo));

create TABLE salas (
    codigoS int AUTO_INCREMENT not null,
    nombre NVARCHAR(100) not null ,
    pelicula int,
    PRIMARY key (codigoS),
    FOREIGN key (pelicula)
    REFERENCES pelicula(codigo)
    on DELETE set null
    on UPDATE CASCADE);

