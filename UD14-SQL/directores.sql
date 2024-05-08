use directores;

    create TABLE despachos (
        numero int AUTO_INCREMENT,
        capacidad int not null,
        primary key (numero));

create table director (
    dni VARCHAR(8),
    nomApels VARCHAR(255),
    dnijefe VARCHAR(8),
    despacho int not null,
    primary key (dni),
    FOREIGN key (dnijefe)
    REFERENCES directores(dni)
    on DELETE CASCADE
    on UPDATE CASCADE,
    FOREIGN key (despacho)
    REFERENCES despachos(numero)
    on DELETE CASCADE
    on UPDATE CASCADE);

    ALTER TABLE despachos CHANGE numero numero INT(11) NOT NULL AUTO_INCREMENT;

-- Rectificamos el valor NOT NULL de DNIjefe
ALTER TABLE `director` CHANGE `dnijefe` `dnijefe` VARCHAR(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL;

INSERT INTO despachos (capacidad) VALUES
(5),
(5),
(5),
(5),
(5),
(5),
(5),
(5),
(5),
(5);

INSERT INTO director (dni, nomApels, dnijefe, despacho)values
('12345678', 'Juan Pérez', NULL, 1),
('23456789', 'María López', '12345678', 2),
('34567890', 'Carlos Martínez', '12345678', 3),
('45678901', 'Ana García', '23456789', 4),
('56789012', 'Pedro Rodríguez', '23456789', 5),
('67890123', 'Laura Sánchez', '34567890', 6),
('78901234', 'José Gómez', '34567890', 7),
('89012345', 'Sofía Díaz', '45678901', 8),
('90123456', 'David Ruiz', '45678901', 9),
('01234567', 'Elena Torres', '56789012', 10);