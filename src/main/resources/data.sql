drop table SUPPLY;

CREATE TABLE IF NOT EXISTS SUPPLY
(
    ID BIGINT AUTO_INCREMENT NOT NULL,
    type       varchar(45),
    name       varchar(45),
    provider   varchar(45),
    weight     int,
    price      int,
    date       date,
    sum_price  int,
    sum_weight int,
    count      int,
    PRIMARY KEY (id)

);


