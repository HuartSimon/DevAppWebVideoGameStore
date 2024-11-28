DROP SCHEMA IF EXISTS video_game_store;
CREATE SCHEMA video_game_store DEFAULT CHARACTER SET utf8 ;
USE video_game_store;

set @@global.time_zone = '+00:00' ;
set @@session.time_zone = '+00:00' ;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS translation;
DROP TABLE IF EXISTS language;
DROP TABLE IF EXISTS discount;
DROP TABLE IF EXISTS order_line;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;


-- TABLE
CREATE TABLE user (
                      username                    VARCHAR(50)     PRIMARY KEY,
                      first_name                  VARCHAR(50)     NOT NULL,
                      last_name                   VARCHAR(50)     NOT NULL,
                      email                       VARCHAR(50)     NOT NULL,
                      address                     VARCHAR(50)     NOT NULL,
                      password                    VARCHAR(60)     NOT NULL,
                      phone_number                VARCHAR(15)     NOT NULL,
                      is_man                      TINYINT(1)      NULL,
                      authorities                 VARCHAR(500)    NOT NULL,
                      non_expired                 TINYINT(1)      NOT NULL,
                      non_locked                  TINYINT(1)      NOT NULL,
                      credentials_non_expired     TINYINT(1)      NOT NULL,
                      enabled                     TINYINT(1)      NOT NULL
);

CREATE TABLE `order` (
                         id                          INTEGER         PRIMARY KEY     AUTO_INCREMENT,
                         order_date                  DATETIME        NOT NULL,
                         is_payed                    TINYINT(1)      NOT NULL,
                         user                        VARCHAR(50)     NOT NULL        REFERENCES user(username)
);

CREATE TABLE language (
                          label                       VARCHAR(50)     PRIMARY KEY
);

CREATE TABLE category (
                          id                          INTEGER         PRIMARY KEY     AUTO_INCREMENT
);

CREATE TABLE translation (
                             id                          INTEGER         PRIMARY KEY     AUTO_INCREMENT,
                             name                        VARCHAR(50)     NOT NULL,
                             description                 VARCHAR(250)    NOT NULL,
                             category                    INTEGER         NOT NULL        REFERENCES category(id),
                             language                    VARCHAR(50)     NOT NULL        REFERENCES language(label)
);

CREATE TABLE product (
                         id                          INTEGER         PRIMARY KEY     AUTO_INCREMENT,
                         name                        VARCHAR(50)     NOT NULL,
                         description                 VARCHAR(250)    NOT NULL,
                         price                       DOUBLE(7, 2)    NOT NULL,
                         category                    INTEGER         REFERENCES category(id)
);

CREATE TABLE discount (
                          id                          INTEGER         PRIMARY KEY     AUTO_INCREMENT,
                          discount_val                DOUBLE(5, 2)    NOT NULL,
                          begin_date                  DATETIME        NOT NULL,
                          end_date                    DATETIME        NOT NULL,
                          category                    INTEGER         REFERENCES category(id)
);

CREATE TABLE order_line (
                            id                          INTEGER         PRIMARY KEY     AUTO_INCREMENT,
                            quantity                    INTEGER         NOT NULL,
                            price                       DOUBLE(7, 2)    NOT NULL,
                            discount                    TINYINT(1),
                            `order`                     INTEGER         NOT NULL    REFERENCES `order`(id),
                            product                     INTEGER         NOT NULL    REFERENCES product(id)
)
