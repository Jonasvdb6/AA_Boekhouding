/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  simon
 * Created: Nov 29, 2016
 */

DROP TABLE onkosten;
DROP TABLE kredieten;
DROP TABLE werknemers;

CREATE TABLE werknemers
(
    pNummer int NOT NULL,
    pswd varchar(30) NOT NULL,
    werkType int NOT NULL,
    bNummer int NOT NULL,
    PRIMARY KEY (pNummer)
);

CREATE TABLE kredieten
(
    krNummer int NOT NULL,
    krSaldo double NOT NULL,
    krType int NOT NULL,
    PRIMARY KEY (krNummer),
    pnummer int REFERENCES werknemers(pNummer)
);

CREATE TABLE onkosten
(
    onkostId int NOT NULL,
    omschrijving varchar(100) NOT NULL,
    datum varchar(30) NOT NULL,
    onkostenBedrag double NOT NULL,
    status varchar(30) NOT NULL,
    PRIMARY KEY (onkostId),
    pnummer int REFERENCES werknemers(pNummer)
);

INSERT INTO werknemers VALUES (999,'admin',3,999);
INSERT INTO werknemers VALUES (1,'gewoon',1,999);
INSERT INTO werknemers VALUES (2,'boekhouder',2,999);
INSERT INTO werknemers VALUES (3,'manager',3,999);
INSERT INTO werknemers VALUES (4,'bm',23,999);

INSERT INTO onkosten VALUES (1, "Omschrijving: onkost id: 1, bla bla bla", "20/12/2016", 123456, "afgehandelt", 999);
INSERT INTO onkosten VALUES (2, "Omschrijving: onkost id: 2, bli bli bli", "21/12/2016", 987654, "niet afgehandelt", 999);