DROP TABLE Staff;
DROP TABLE Customer;
DROP TABLE Customer_Service;
DROP TABLE Recipes; 
DROP TABLE Recipes_created;
DROP TABLE Order_Placed_Ordered;
DROP TABLE Recipe_To_Menu;
DROP TABLE Menu_Price;  
DROP TABLE Stock;
DROP TABLE Requires;

CREATE TABLE Staff(
 SIN CHAR(11),
 Name CHAR(25),
 primary key(SIN)
 ON DELETE CASCADE);


CREATE TABLE Customer(
 CID Integer,
 Name CHAR(25),
 primary key(CID));

CREATE TABLE Customer_Service(
CID Integer,
serv_date timestamp,
SIN CHAR(11),
primary key(CID,Date),
foreign key (SIN) references Staff(SIN));

CREATE TABLE Recipes(
 rName CHAR(25),
 Ingredients char(100),
 primary key(rName));


CREATE TABLE Recipes_Created(
rName CHAR(25),
SIN CHAR(11),
primary key(rName),
foreign key (SIN) references Staff(SIN) 
ON DELETE CASCADE);

CREATE TABLE Order_Placed_Ordered(
ID Integer,
CID Integer,
order_date TIMESTAMP,
mName CHAR(25),
primary key(ID,CID),
foreign key (CID) references Customer_Serves(CID),
foreign key (mName) references Recipes_Created(rName));

CREATE TABLE Recipe_To_Menu(
rName Char(25),
mName Char(25),
primary key(rName, mName),
foreign key (rName) references Recipes_Created(rName)
ON DELETE CASCADE);

CREATE TABLE Menu_Price(
rName CHAR(25),
Price Decimal,
primary key(rName),
foreign key rName references Recipes_Created(rName));

CREATE TABLE Stock(
sName CHAR(15),
Quantity Integer,
UnitPrice Decimal,
primary key(sName));

CREATE TABLE Requires(
sName CHAR(15),
mName CHAR(25),
primary key(sName, mName),
foreign key (sName) references Stock(sName) ,
foreign key (mName) references Menu_Featured(mName));
