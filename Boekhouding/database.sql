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
    datum date NOT NULL,
    onkostenBedrag double NOT NULL,
    status varchar(30) NOT NULL,
    PRIMARY KEY (onkostId),
    pnummer int REFERENCES werknemers(pNummer)
);

INSERT INTO users VALUES (999,'admin','3');