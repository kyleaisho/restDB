drop table Order_Placed_Ordered;
drop table Requires;
drop table Menu_Price;
drop table Recipe_To_Menu;
drop table Customer_Service;
drop table Recipes_Created;
drop table Customer;
drop table Recipes;
drop table Stock;
drop table Staff;
drop sequence countID;
drop sequence countCID;

create sequence countID  start with 9 increment by 1;
create sequence countCID  start with 6 increment by 1;

CREATE TABLE Staff(
 SIN CHAR(11),
 Name CHAR(25),
 primary key(SIN));
 
 CREATE TABLE Customer(
 CID Integer,
 Name CHAR(25),
 primary key(CID));
 
 CREATE TABLE Recipes(
 rName CHAR(25),
 Ingredients char(100),
 primary key(rName));

CREATE TABLE Customer_Service(
CID Integer,
serv_date timestamp,
SIN CHAR(11),
primary key(CID, serv_date),
foreign key (CID) references Customer(CID),
foreign key (SIN) references Staff(SIN)
ON DELETE CASCADE);

CREATE TABLE Recipes_Created(
rName CHAR(25),
SIN CHAR(11),
primary key(rName, SIN),
foreign key (SIN) references Staff(SIN)
ON DELETE CASCADE);

CREATE TABLE Recipe_To_Menu(
rName Char(25),
mName Char(25) unique,
primary key(rName, mName),
foreign key (rName) references Recipes(rName)
ON DELETE CASCADE);

CREATE TABLE Menu_Price(
rName CHAR(25),
Price Decimal,
primary key(rName),
foreign key (rName) references Recipes(rName));

CREATE TABLE Order_Placed_Ordered(
ID Integer,
CID Integer,
order_date TIMESTAMP,
mName CHAR(25),
primary key(ID,CID),
foreign key (CID) references Customer(CID),
foreign key (mName) references Recipe_To_Menu(mName)
ON DELETE CASCADE);


CREATE TABLE Stock(
sName CHAR(15),
Quantity Integer,
UnitPrice Decimal,
primary key(sName));

CREATE TABLE Requires(
sName CHAR(15),
mName CHAR(25),
primary key(sName, mName),
foreign key (mName) references Recipe_To_Menu(mName),
foreign key (sName) references Stock(sName));


INSERT INTO Staff
VALUES(045249013, 'Steve Rogers');

INSERT INTO Staff
VALUES(779306521, 'Maria Hill');

INSERT INTO Staff
VALUES(550841266, 'Natasha Romanoff');

INSERT INTO Staff
VALUES(941790022, 'Bruce Banner');

INSERT INTO Staff
VALUES(485034617, 'Clint Barton');

INSERT INTO Stock
VALUES('Tomatoes', 47, 0.34);

INSERT INTO Stock
VALUES('Clams', 50, 0.51);

INSERT INTO Stock
VALUES('Oysters', 50, 0.51);

INSERT INTO Stock
VALUES('Shrimp', 50, 0.51);

INSERT INTO Stock
VALUES('Olive Oil', 50, 0.51);

INSERT INTO Stock
VALUES('Saffron', 50, 0.51);

INSERT INTO Stock
VALUES('Cottage Cheese', 50, 0.51);

INSERT INTO Stock
VALUES('Black Truffle', 50, 0.51);

INSERT INTO Stock
VALUES('Sticky Rice', 50, 0.51);

INSERT INTO Stock
VALUES('Cinnamon', 50, 0.51);

INSERT INTO Stock
VALUES('Sweet Cream', 50, 0.51);

INSERT INTO Stock
VALUES('Water', 50, 0.51);

INSERT INTO Stock
VALUES('Coffee Beans', 50, 0.51);

INSERT INTO Stock
VALUES('Garlic', 50, 0.51);

INSERT INTO Stock
VALUES('Thyme', 50, 0.51);

INSERT INTO Stock
VALUES('Duck Breast', 16, 3.05);

INSERT INTO Stock
VALUES('Duck Bones', 50, 0.51);

INSERT INTO Stock
VALUES('Maple Sugar', 1000, 2.85);

INSERT INTO Stock
VALUES('Onions', 33, 0.28);

INSERT INTO Stock
VALUES('Cake Mix', 50, 0.51);

INSERT INTO Stock
VALUES('Pecan Frosting', 50, 0.51);

INSERT INTO Stock
VALUES('Vegetable Oil', 50, 0.51);

INSERT INTO Stock
VALUES('Butter', 50, 0.51);

INSERT INTO Stock
VALUES('Sugar', 50, 0.51);

INSERT INTO Stock
VALUES('Flour', 50, 0.51);

INSERT INTO Stock
VALUES('Rhubarb', 50, 0.51);

INSERT INTO Stock
VALUES('Licorice', 50, 0.51);

INSERT INTO Customer
VALUES(1, 'Oliver Queen');

INSERT INTO Customer
VALUES(2, 'Barbara Gordon');

INSERT INTO Customer
VALUES(3, 'Arthur Curry');

INSERT INTO Customer
VALUES(4, 'Selina Kyle');

INSERT INTO Customer
VALUES(5, 'Diana Prince');

INSERT INTO Recipes
VALUES('Bouillabaisse', 'Tomatoes, Clams, Oysters, Shrimp, Olive Oil, Saffron');

INSERT INTO Recipes
VALUES('Black Truffle Risotto', 'Cottage Cheese, Onions, Black Truffle, Sticky Rice');

INSERT INTO Recipes
VALUES('Coffee', 'Cinnamon, Maple Sugar, Sweet Cream, Water, Coffee Beans');

INSERT INTO Recipes
VALUES('Duck Broth', 'Onions, Garlic, Thyme, Duck Breast, Duck Bones');

INSERT INTO Recipes
VALUES('Chocolate Cake', 'Cake Mix, Coconut Frosting, Vegetable Oil, Butter, Sugar, Flour, Rhubarb, Licorice');

INSERT INTO Recipes_Created
VALUES('Bouillabaisse', 550841266);

INSERT INTO Recipes_Created
VALUES('Coffee', 941790022);

INSERT INTO Recipes_Created
VALUES('Coffee', 779306521);

INSERT INTO Recipes_Created
VALUES('Duck Broth', 550841266);

INSERT INTO Recipes_Created
VALUES('Chocolate Cake', 485034617);

INSERT INTO Customer_Service
VALUES(2, '2013-03-17 19:34:29.523', 550841266);

INSERT INTO Customer_Service
VALUES(3, '2013-11-02 12:07:11.927', 485034617);

INSERT INTO Customer_Service
VALUES(4, '2014-08-25 14:50:20.398', 045249013);

INSERT INTO Customer_Service
VALUES(5, '2015-05-29 15:31:45.028', 550841266);

INSERT INTO Customer_Service
VALUES(2, '2015-05-29 15:31:45.028', 485034617);

INSERT INTO Recipe_To_Menu
VALUES('Bouillabaisse', 'Riviera Bouillabaisse');

INSERT INTO Recipe_To_Menu
VALUES('Black Truffle Risotto', 'Black Truffle Risotto');

INSERT INTO Recipe_To_Menu
VALUES('Coffee', 'Cream Coffee');

INSERT INTO Recipe_To_Menu
VALUES('Duck Broth', 'Traditional Duck Broth');

INSERT INTO Recipe_To_Menu
VALUES('Chocolate Cake', 'Chocolate Mousse Cake');


INSERT INTO Menu_Price
VALUES('Bouillabaisse', 32.99);

INSERT INTO Menu_Price
VALUES('Black Truffle Risotto', 17.99);

INSERT INTO Menu_Price
VALUES('Coffee', 3.50);

INSERT INTO Menu_Price
VALUES('Duck Broth', 12.99);

INSERT INTO Menu_Price
VALUES('Chocolate Cake', 29.99);


INSERT INTO Order_Placed_Ordered
VALUES(1, 2, '2013-03-17 19:34:29.523', 'Traditional Duck Broth');

INSERT INTO Order_Placed_Ordered
VALUES(2, 3, '2013-11-02 12:07:11.927', 'Riviera Bouillabaisse');

INSERT INTO Order_Placed_Ordered
VALUES(3, 4, '2014-08-25 14:50:20.398', 'Chocolate Mousse Cake');

INSERT INTO Order_Placed_Ordered
VALUES(4, 5, '2015-05-29 15:31:45.028', 'Cream Coffee');

INSERT INTO Order_Placed_Ordered
VALUES(5, 2, '2015-05-29 15:31:45.028', 'Cream Coffee');

INSERT INTO Order_Placed_Ordered
VALUES(6, 2, '2015-05-29 15:31:45.028', 'Chocolate Mousse Cake');

INSERT INTO Order_Placed_Ordered
VALUES(7, 2, '2015-05-29 15:31:45.028', 'Riviera Bouillabaisse');

INSERT INTO Order_Placed_Ordered
VALUES(8, 2, '2015-05-29 15:31:45.028', 'Black Truffle Risotto');

INSERT INTO Requires
VALUES('Shrimp','Riviera Bouillabaisse');
 
INSERT INTO Requires
VALUES('Tomatoes','Riviera Bouillabaisse');

INSERT INTO Requires
VALUES('Clams','Riviera Bouillabaisse');

INSERT INTO Requires
VALUES('Oysters','Riviera Bouillabaisse');

INSERT INTO Requires
VALUES('Olive Oil','Riviera Bouillabaisse');
 
INSERT INTO Requires
VALUES('Saffron','Riviera Bouillabaisse');

INSERT INTO Requires
VALUES('Cottage Cheese', 'Black Truffle Risotto');

INSERT INTO Requires
VALUES('Onions', 'Black Truffle Risotto');

INSERT INTO Requires
VALUES('Black Truffle', 'Black Truffle Risotto');

INSERT INTO Requires
VALUES('Sticky Rice', 'Black Truffle Risotto');

INSERT INTO Requires
VALUES('Maple Sugar', 'Cream Coffee');

INSERT INTO Requires
VALUES('Cinnamon', 'Cream Coffee');

INSERT INTO Requires
VALUES('Sweet Cream', 'Cream Coffee');

INSERT INTO Requires
VALUES('Water', 'Cream Coffee');

INSERT INTO Requires
VALUES('Coffee Beans', 'Cream Coffee');

INSERT INTO Requires
VALUES('Duck Breast','Traditional Duck Broth' );

INSERT INTO Requires
VALUES('Onions','Traditional Duck Broth' );

INSERT INTO Requires
VALUES('Garlic','Traditional Duck Broth' );

INSERT INTO Requires
VALUES('Thyme','Traditional Duck Broth' );

INSERT INTO Requires
VALUES('Duck Bones','Traditional Duck Broth' );

INSERT INTO Requires
VALUES('Cake Mix','Chocolate Mousse Cake' );

INSERT INTO Requires
VALUES('Pecan Frosting','Chocolate Mousse Cake' );

INSERT INTO Requires
VALUES('Vegetable Oil','Chocolate Mousse Cake' );

INSERT INTO Requires
VALUES('Butter','Chocolate Mousse Cake' );

INSERT INTO Requires
VALUES('Sugar','Chocolate Mousse Cake' );

INSERT INTO Requires
VALUES('Flour','Chocolate Mousse Cake' );

INSERT INTO Requires
VALUES('Rhubarb','Chocolate Mousse Cake' );

INSERT INTO Requires
VALUES('Licorice','Chocolate Mousse Cake' );
