CREATE TABLE IF NOT EXISTS country(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
     name                   VARCHAR(52) NOT NULL,
     iso2                 VARCHAR(2) NOT NULL,
     iso3                 VARCHAR(3) NOT NULL,
     country_code            VARCHAR(10) NOT NULL,
     iso              VARCHAR(13) NOT NULL
);

CREATE TABLE IF NOT EXISTS city(
     id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT
    ,name       VARCHAR(49) NOT NULL
    ,lat        NUMERIC(8,4) NOT NULL
    ,lng        NUMERIC(9,4) NOT NULL
    ,country    VARCHAR(45) NOT NULL
    ,iso2       VARCHAR(2) NOT NULL
    ,iso3       VARCHAR(3) NOT NULL
);