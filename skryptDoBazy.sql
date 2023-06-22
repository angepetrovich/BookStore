
drop table if exists `autorzy_to_ksiazki`;
drop table if exists `autorzy`;
drop table if exists `ksiazki`;
drop table if exists `kategorie`;
 DROP TABLE IF EXISTS `authorities`;
drop table if exists `users`;


CREATE TABLE `autorzy` (  
	 `id` smallint(6) NOT NULL AUTO_INCREMENT,  
	 `imie` varchar(30) DEFAULT NULL, 
	 `nazwisko` varchar(40) DEFAULT NULL,
	 PRIMARY KEY (`id`)
 );
 
 CREATE TABLE `kategorie` (  
	 `id` mediumint(9) NOT NULL AUTO_INCREMENT,  
	 `nazwa` varchar(40) DEFAULT NULL, 
	 PRIMARY KEY (`id`)
 );
 
  CREATE TABLE `ksiazki` (  
	 `id` int(11) NOT NULL AUTO_INCREMENT,  
	 `nazwa` varchar(100) DEFAULT NULL, 
	 `wydawnictwo` varchar(50) DEFAULT NULL, 
	 `cena` float DEFAULT NULL,
     `kategoria_id` mediumint(9) default NULL,
	 PRIMARY KEY (`id`),
	 FOREIGN KEY (`kategoria_id`) REFERENCES `kategorie` (`id`) 
 );
 
CREATE TABLE `autorzy_to_ksiazki` (
 `ksiazka_id` int(11) NOT NULL,
`autor_id` SMALLINT NOT NULL,
primary key(`ksiazka_id`, `autor_id`),
FOREIGN KEY (`ksiazka_id`) REFERENCES `ksiazki`(`id`),
FOREIGN KEY (`autor_id`) REFERENCES `autorzy`(`id`)
 ); 


INSERT INTO `kategorie`(`nazwa`) VALUES ( 'brak');
INSERT INTO `kategorie`(`nazwa`)  VALUES ( 'Literatura polska');
INSERT INTO `kategorie`(`nazwa`)  VALUES ( 'Literatura zagraniczna');
INSERT INTO `ksiazki` (`nazwa`, `wydawnictwo`, `cena`, `kategoria_id`) VALUES ( 'Hamlet', 'AAA', 6.5, 3);
INSERT INTO `ksiazki`(`nazwa`, `wydawnictwo`, `cena`, `kategoria_id`)  VALUES ( 'Makbet', 'AAA', 6.8, 2);
INSERT INTO `ksiazki`(`nazwa`, `wydawnictwo`, `cena`, `kategoria_id`)   VALUES ( 'Potop', 'BBB', 18.4, 2);
INSERT INTO `ksiazki`(`nazwa`, `wydawnictwo`, `cena`, `kategoria_id`)  VALUES ( 'Quo vadis', 'BBB', 17.99, 2);
INSERT INTO `ksiazki`(`nazwa`, `wydawnictwo`, `cena`, `kategoria_id`)   VALUES ( 'Pan Tadeusz', 'CCC', 13.78, 2);
INSERT INTO `ksiazki` (`nazwa`, `wydawnictwo`, `cena`, `kategoria_id`)  VALUES ( 'Nad Niemnem', 'CCC', 15.45, 2);
INSERT INTO `autorzy` (`imie` , `nazwisko`) VALUES('William', 'Shakespeare'),('Henryk', 'Sienkiewicz'),('Adam', 'Mickiewicz'),('Eliza', 'Orzeszkowa'),('Jan', 'Kowalski');

INSERT INTO `autorzy_to_ksiazki`VALUES (1, 1);
INSERT INTO `autorzy_to_ksiazki` VALUES (1, 5);
INSERT INTO `autorzy_to_ksiazki` VALUES (2, 1);
INSERT INTO `autorzy_to_ksiazki` VALUES (2, 5);
INSERT INTO `autorzy_to_ksiazki` VALUES (3, 2);
INSERT INTO `autorzy_to_ksiazki` VALUES (4, 2);
INSERT INTO `autorzy_to_ksiazki` VALUES (5, 3);
INSERT INTO `autorzy_to_ksiazki` VALUES (6, 4);

CREATE TABLE users (
 username VARCHAR(25) NOT NULL,
 password VARCHAR(60) NOT NULL,
 enabled boolean NOT NULL DEFAULT TRUE,
 PRIMARY KEY (username)
 );
 

CREATE TABLE authorities (
 username varchar(50) NOT NULL,
 authority varchar(50) NOT NULL,

 UNIQUE KEY `authorieties_idx_1` (`username`, `authority`),
 CONSTRAINT `authorities_ibfk_1`
foreign key (`username`)
 REFERENCES `users` (`username`)
);




