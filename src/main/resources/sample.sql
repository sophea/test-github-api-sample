 
CREATE database sample;

use sample;

DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 name VARCHAR(200), 
 country VARCHAR(200)
 )DEFAULT CHARSET=utf8;
 INSERT INTO Person (id, name, country) values(1,'sophea', 'Cambodia');