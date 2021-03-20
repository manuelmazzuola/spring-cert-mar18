CREATE TABLE Address
(
    lat           double NOT NULL,
    lon           double NOT NULL,
    region        varchar(255) DEFAULT NULL,
    city          varchar(255) DEFAULT NULL,
    state         varchar(255) DEFAULT NULL,
    current_meteo text,
    address       varchar(255) DEFAULT NULL,
    PRIMARY KEY (lat, lon)
);
