use directores;


create table directores (
    dni VARCHAR(8),
    nomApels NVARCHAR(255),
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
ALTER TABLE `directores` CHANGE `dnijefe` `dnijefe` VARCHAR(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL;
