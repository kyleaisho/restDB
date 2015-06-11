drop table order_placed_ordered;
drop table recipe_to_menu;
drop table customer_service;
drop table requires;
drop table menu_price;
drop table recipes_created;
drop table customer;
drop table recipes;
drop table stock;
drop table staff;

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
CID Integer unique,
serv_date timestamp,
SIN CHAR(11),
Name CHAR(25),
primary key(CID, serv_date),
foreign key (SIN) references Staff(SIN));

CREATE TABLE Recipes_Created(
rName CHAR(25) unique,
SIN CHAR(11),
primary key(rName, SIN),
Ingredients char(100),
foreign key (SIN) references Staff(SIN));

CREATE TABLE Order_Placed_Ordered(
ID Integer,
CID Integer,
order_date TIMESTAMP,
mName CHAR(25),
primary key(ID,CID),
foreign key (CID) references Customer_Service(CID),
foreign key (mName) references Recipes_Created(rName));


CREATE TABLE Recipe_To_Menu(
rName Char(25),
mName Char(25),
primary key(rName, mName),
foreign key (rName) references Recipes_Created(rName));

CREATE TABLE Menu_Price(
rName CHAR(25),
Price Decimal,
primary key(rName),
foreign key (rName) references Recipes_Created(rName));

CREATE TABLE Stock(
sName CHAR(15),
Quantity Integer,
UnitPrice Decimal,
primary key(sName));

CREATE TABLE Requires(
sName CHAR(15),
mName CHAR(25),
primary key(sName, mName),
foreign key (sName) references Stock(sName),
foreign key (mName) references Menu_Price(rName));