/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jonas & simon
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
    pnummer int REFERENCES werknemers(pNummer),
    negatief int DEFAULT 0
);

CREATE TABLE onkosten
(
    onkostId int NOT NULL,
    omschrijving varchar(100) NOT NULL,
    datum varchar(30) NOT NULL,
    onkostenBedrag double NOT NULL,
    status varchar(30) NOT NULL,
    PRIMARY KEY (onkostId),
    pnummer int REFERENCES werknemers(pNummer),
    krNummer int DEFAULT 0 REFERENCES kredieten(krNummer)
);

/* Werknemers */
INSERT INTO werknemers VALUES (999,'admin',23,999);
INSERT INTO werknemers VALUES (1,'gewoon',1,999);
INSERT INTO werknemers VALUES (2,'boekhouder',2,999);
INSERT INTO werknemers VALUES (3,'manager',3,999);
INSERT INTO werknemers VALUES (4,'bm',23,999);
INSERT INTO werknemers VALUES (5,'manager',3,999);

/* Onkosten */
INSERT INTO onkosten VALUES (1, "Omschrijving: onkost id: 1, bla bla bla", "20/12/2016", 123456, "Doorgestuurd", 999, DEFAULT);
INSERT INTO onkosten VALUES (2, "Omschrijving: onkost id: 2, bli bli bli", "21/12/2016", 987654, "In aanmaak", 999, DEFAULT);
INSERT INTO onkosten VALUES (3, "Omschrijving: onkost id: 3, bla bla bla", "20/12/2016", 465240, "Doorgestuurd", 999, DEFAULT);
INSERT INTO onkosten VALUES (4, "Omschrijving: onkost id: 4, bli bli bli", "21/12/2016", 456781, "In aanmaak", 999, DEFAULT);

INSERT INTO onkosten VALUES (5, "Omschrijving: onkost id: 5, bla bla bla", "1/01/2017", 20000, "Doorgestuurd", 1, DEFAULT);
INSERT INTO onkosten VALUES (6, "Omschrijving: onkost id: 6, bla bla bla", "5/01/2017", 90000, "In aanmaak", 1, DEFAULT);
INSERT INTO onkosten VALUES (7, "Omschrijving: onkost id: 7, bla bla bla", "5/01/2017", 30000, "In aanmaak", 1, DEFAULT);

INSERT INTO onkosten VALUES (8, "Omschrijving: onkost id: 8, bla bla bla", "1/01/2017", 10000, "Doorgestuurd", 2, DEFAULT);
INSERT INTO onkosten VALUES (9, "Omschrijving: onkost id: 9, bla bla bla", "5/01/2017", 30000, "In aanmaak", 2, DEFAULT);


/* Kredieten */
INSERT INTO kredieten VALUES (1, 5000, 1, 999, DEFAULT);
INSERT INTO kredieten VALUES (2, 25000, 2, 999, DEFAULT); /* gewaarborgd krediet */
INSERT INTO kredieten VALUES (3, 15000, 1, 999, DEFAULT);

INSERT INTO kredieten VALUES (4, 30000, 1, 3, DEFAULT);
INSERT INTO kredieten VALUES (5, 10000, 2, 3, DEFAULT); /* gewaarborgd krediet */

INSERT INTO kredieten VALUES (6, 30000, 1, 5, DEFAULT);
INSERT INTO kredieten VALUES (7, 10000, 2, 5, DEFAULT); /* gewaarborgd krediet */