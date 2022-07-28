
CREATE DATABASE MAGstoredb OWNER MAGadmin ENCODING = 'UTF8';

-- Connect to the new db
c MAGdb


CREATE SCHEMA MAG;


CREATE TYPE MAG.roles AS ENUM (
'base',
'user',
'admin'
);

CREATE TABLE MAG.account (
                             email VARCHAR(64) PRIMARY KEY,
                             password TEXT NOT NULL,
                             first_name VARCHAR(64) NOT NULL,
                             last_name VARCHAR(66) NOT NULL,
                             role MAG.roles DEFAULT 'base' NOT NULL
);


CREATE TABLE  MAG.stores (
                             store_id int PRIMARY KEY,
                             store_name VARCHAR (255) NOT NULL,
                             phone VARCHAR (25),
                             email VARCHAR (255),
                             address VARCHAR (255)
);


CREATE TABLE MAG.categories (
                                categorie_id int PRIMARY KEY,
                                categorie_name VARCHAR (255) NOT NULL,
                                description VARCHAR (255)

);



CREATE TABLE MAG.products (
                              product_id int PRIMARY KEY,
                              product_name VARCHAR (255) NOT NULL,
                              categorie_id INT NOT NULL,
                              list_price DECIMAL (10, 2) NOT NULL,
                              description TEXT,
                              product_url VARCHAR (255),
                              FOREIGN KEY (categorie_id)
                                  REFERENCES MAG.categories (categorie_id)
                                  ON DELETE CASCADE ON UPDATE CASCADE

);


CREATE TABLE MAG.cart (
                            cart_id SERIAL primary key,
                            product_id INT,
                            email VARCHAR(64),
                            FOREIGN KEY (email)
                                REFERENCES MAG.account (email)
                                ON DELETE CASCADE ON UPDATE CASCADE,
                            FOREIGN KEY (product_id)
                                REFERENCES MAG.products (product_id)
                                ON DELETE CASCADE ON UPDATE CASCADE

);




CREATE TABLE MAG.stocks (
                            store_id INT,
                            product_id INT,
                            quantity INT,
                            PRIMARY KEY (store_id, product_id),
                            FOREIGN KEY (store_id)
                                REFERENCES MAG.stores (store_id)
                                ON DELETE CASCADE ON UPDATE CASCADE,
                            FOREIGN KEY (product_id)
                                REFERENCES MAG.products (product_id)
                                ON DELETE CASCADE ON UPDATE CASCADE
);