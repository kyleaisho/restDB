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
foreign key (SIN) references Staff(SIN));

CREATE TABLE Recipes_Created(
rName CHAR(25),
SIN CHAR(11),
primary key(rName, SIN),
foreign key (SIN) references Staff(SIN));

CREATE TABLE Recipe_To_Menu(
rName Char(25),
mName Char(25) unique,
primary key(rName, mName),
foreign key (rName) references Recipes(rName));

CREATE TABLE Menu_Price(
mName CHAR(25),
Price Decimal,
primary key(mName),
foreign key (mName) references Recipe_To_Menu(mName));

CREATE TABLE Order_Placed_Ordered(
ID Integer,
CID Integer,
order_date TIMESTAMP,
mName CHAR(25),
primary key(ID,CID),
foreign key (CID) references Customer(CID),
foreign key (mName) references Menu_Price (mName));


CREATE TABLE Stock(
sName CHAR(15),
Quantity Integer,
UnitPrice Decimal,
primary key(sName));

CREATE TABLE Requires(
sName CHAR(25),
mName CHAR(25),
primary key(mName, sName),
foreign key (mName) references Menu_Price(mName),
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
VALUES('Duck Breast', 16, 3.05);

INSERT INTO Stock
VALUES('Maple Sugar', 1000, 2.85);

INSERT INTO Stock
VALUES('Shrimp', 72, 2.62);

INSERT INTO Stock
VALUES('Onions', 33, 0.28);

INSERT INTO Stock
VALUES('Tomatoes', 47, 0.34);

INSERT INTO Customer
VALUES(265, 'Oliver Queen');

INSERT INTO Customer
VALUES(17, 'Barbara Gordon');

INSERT INTO Customer
VALUES(1378, 'Arthur Curry');

INSERT INTO Customer
VALUES(756, 'Selina Kyle');

INSERT INTO Customer
VALUES(4352, 'Diana Prince');

INSERT INTO Recipes
VALUES('Bouillabaisse', 'Tomatoes, Clams, Oysters, Shrimp, Olive Oil, Saffron');

INSERT INTO Recipes
VALUES('Black Truffle Risotto', 'Cottage Cheese, Onions, Black Truffle, Sticky Rice');

INSERT INTO Recipes
VALUES('Coffee', 'Cinnamon, Maple Sugar, Sweet Cream, Water, Roasted Coffee Beans');

INSERT INTO Recipes
VALUES('Duck Broth', 'Onions, Garlic, Thyme, Duck Breast, Duck Bones');

INSERT INTO Recipes
VALUES('Chocolate Cake', 'Chocolate Cake Mix, Coconut Pecan Frosting, Vegetable Oil, Butter, Sugar, Flour, Rhubarb, Licorice');

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
VALUES(17, '2013-03-17 19:34:29.523', 550841266);

INSERT INTO Customer_Service
VALUES(1378, '2013-11-02 12:07:11.927', 485034617);

INSERT INTO Customer_Service
VALUES(756, '2014-08-25 14:50:20.398', 045249013);

INSERT INTO Customer_Service
VALUES(4352, '2015-05-29 15:31:45.028', 550841266);

INSERT INTO Customer_Service
VALUES(17, '2015-05-29 15:31:45.028', 485034617);

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
VALUES('Riviera Bouillabaisse', 32.99);

INSERT INTO Menu_Price
VALUES('Black Truffle Risotto', 17.99);

INSERT INTO Menu_Price
VALUES('Cream Coffee', 3.50);

INSERT INTO Menu_Price
VALUES('Traditional Duck Broth', 12.99);

INSERT INTO Menu_Price
VALUES('Chocolate Mousse Cake', 29.99);


INSERT INTO Order_Placed_Ordered
VALUES(13345, 17, '2013-03-17 19:34:29.523', 'Traditional Duck Broth');

INSERT INTO Order_Placed_Ordered
VALUES(20041, 1378, '2013-11-02 12:07:11.927', 'Riviera Bouillabaisse');

INSERT INTO Order_Placed_Ordered
VALUES(57802, 756, '2014-08-25 14:50:20.398', 'Chocolate Mousse Cake');

INSERT INTO Order_Placed_Ordered
VALUES(80927, 4352, '2015-05-29 15:31:45.028', 'Cream Coffee');

INSERT INTO Order_Placed_Ordered
VALUES(80927, 17, '2015-05-29 15:31:45.028', 'Cream Coffee');

INSERT INTO Requires
VALUES('Riviera Bouillabaisse', 'Shrimp');

INSERT INTO Requires
VALUES('Riviera Bouillabaisse', 'Tomatoes');

INSERT INTO Requires
VALUES('Cream Coffee', 'Maple Sugar');

INSERT INTO Requires
VALUES('Traditional Duck Broth', 'Duck Breast');

INSERT INTO Requires
VALUES('Black Truffle Risotto', 'Onions');