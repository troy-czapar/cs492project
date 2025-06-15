-- Preloads menu entries
INSERT INTO MENU_ENTRIES (ID,NAME,DESCRIPTION,PRICE,IMAGE,QUANTITY) VALUES (1,'Cheese','All Cheese Pizza',12.99,'/images/cheese.png',0);
INSERT INTO MENU_ENTRIES (ID,NAME,DESCRIPTION,PRICE,IMAGE,QUANTITY) VALUES (2,'Bacon and Ranch','Pizza with Bacon and ranch',13.99,'/images/baconranch.png',0);
INSERT INTO MENU_ENTRIES (ID,NAME,DESCRIPTION,PRICE,IMAGE,QUANTITY) VALUES (3,'Meatza','Pizza with 4 meats: Bacon, Pepperoni, Salami, and Sausage',15.99,'/images/meatza.png',0);

-- Preloads users
INSERT INTO USER_ENTRIES (ID,DISPLAY_NAME, EMAIL,ROLE,PASSWORD) VALUES (1,'customer1','customer1@gmail.com','user','123456');
INSERT INTO USER_ENTRIES (ID,DISPLAY_NAME, EMAIL,ROLE,PASSWORD) VALUES (2,'customer2','customer2@gmail.com','user','123456');
INSERT INTO USER_ENTRIES (ID,DISPLAY_NAME, EMAIL,ROLE,PASSWORD) VALUES (3,'manager','manager@gmail.com','manager','123456');

-- Create carts for each user
INSERT INTO ORDER_ENTRIES (ID, STATUS) VALUES (1,0);
INSERT INTO ORDER_ENTRIES (ID, STATUS) VALUES (2,0);
INSERT INTO ORDER_ENTRIES (ID, STATUS) VALUES (3,0);




