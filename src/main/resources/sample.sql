 
CREATE database sample;

use sample;

DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
 id bigint(20) NOT NULL AUTO_INCREMENT primary key,
 name VARCHAR(200), 
 country VARCHAR(200),
 createdDate timestamp,
 updatedDate timestamp,
 version bigint(5) 
 )DEFAULT CHARSET=utf8;
 INSERT INTO Person (name, country) values('sophea', 'Cambodia');