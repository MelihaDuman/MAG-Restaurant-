INSERT INTO MAG.stores VALUES
(0,'MAG1','0643556932','info@acroparkny.com', 'Via Gradenigo, Padova'),
(1,'M1G2','0643556934','public@aquafun.com', 'Corso Milano, Vicenza'),
(3,'MAG3','0643556966','customerservice@rideadventures.com', 'Via Parco della Vittoria, Monopoli');


INSERT INTO MAG.account VALUES
('amine@hotmail.com',md5('amine'),'gu', 'fag','admin'),
('John@hotmail.com',md5('JonhPassword'),'jo','cr','customer'),
('aylin.yilmaz@hotmail.com',md5('aylinYilmaz'),'jo','cr','admin'),
('Paul@hotmail.com',md5('PaulPassword'),'paul','p','customer'),
('admin@hotmail.com',md5('adminPassword'),'admin','a','admin'),
('customer@hotmail.com',md5('customerPassword'),'customer','p','customer'),
('user@hotmail.com',md5('userPassword'),'user','p','user');




INSERT INTO MAG.categories VALUES
(0,'Pizza', 'pizza'),
(1,'Sushi', 'sushi'),
(2,'Burger', 'burger');



INSERT INTO MAG.products VALUES
(1,'marinara',0, 4,'tomato, garlic and oregano', 'http://localhost:8080/wa2122-mag-1.0/html/images/marinara.jpg' ),
(2,'4 Formaggi',0, 7,'tomato, mozzarella, gorgonzola, emmenthal and asiago', 'http://localhost:8080/wa2122-mag-1.0/html/images/4formaggi.png' ),
(3,'margarita',0, 5,'tomato, mozarella', 'http://localhost:8080/wa2122-mag-1.0/html/images/margarita.jpg' ),
(4,'Neapolitan',0, 8,'tomato, mozzarella, gorgonzola, emmenthal and asiago', 'http://localhost:8080/wa2122-mag-1.0/html/images/Neapolitanpizza.jpg' ),
(5,'Prosciutto e Fungi',0, 9,'tomato, mozzarella, gorgonzola, emmenthal and asiago', 'http://localhost:8080/wa2122-mag-1.0/html/images/prosciutto_funghi.jpg' ),


(6,'Sake',1, 1.5, 'Salmon Nigiri', 'http://localhost:8080/wa2122-mag-1.0/html/images/sake.jpg'),
(7,'Suzuki',1, 1.5, 'Sea bass nigiri', 'http://localhost:8080/wa2122-mag-1.0/html/images/suzuki.jpg'),
(8,'Tako',1, 1.5, 'Octopus nigiri *', 'http://localhost:8080/wa2122-mag-1.0/html/images/tako.jpg'),
(9,'Amaebi',1, 1.5, 'Raw shrimp nigiri *', 'http://localhost:8080/wa2122-mag-1.0/html/images/amaebi.jpg'),
(10,'Gunkan Maguro',1, 1.5, 'Seaweed puffs with rice and salmon roe', 'http://localhost:8080/wa2122-mag-1.0/html/images/gunkanmaguro.jpg'),
(11,'Tamago',1, 1.5, 'Omelette nigiri', 'http://localhost:8080/wa2122-mag-1.0/html/images/tamago.jpg'),
(12,'Unagi',1, 1.5, 'Eel nigiri *', 'http://localhost:8080/wa2122-mag-1.0/html/images/unagi.jpg')



(13,'Cheese Burger',2,9,'rucola, beef, cheese, tomato, onion,pickled,cucumber,sauce','http://localhost:8080/wa2122-mag-1.0/html/images/cheeseburger.webp'),
(14,'Chicken Burger',2,6,'Chicken and tasty cassar sauce between two soft slices of bread', 'http://localhost:8080/wa2122-mag-1.0/html/images/chickenburger.jpg'),
(15,'Falafel Burger',2,5,'The outside of the veggie burger is golden and crunchy, while the inside remains soft.','http://localhost:8080/wa2122-mag-1.0/html/images/falafelburger.jpg'),
(16,'Classic Hamburger',2,8,'Bread *, hamburger *, white onion, tomato and gherkins, served with potato * Fries', 'http://localhost:8080/wa2122-mag-1.0/html/images/hamburger.jpg'),
(17,'BIG Hamburger',2,12,'Gluten, Mustard, Soy, Milk, Eggs, Sesame.', 'http://localhost:8080/wa2122-mag-1.0/html/images/bighamburger.jpg');



