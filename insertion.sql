INSERT INTO Staff
VALUES(045 249 013, 'Steve Rogers');

INSERT INTO Staff
VALUES(779 306 521, 'Maria Hill');

INSERT INTO Staff
VALUES(550 841 266, 'Natasha Romanoff');

INSERT INTO Staff
VALUES(941 790 022, 'Bruce Banner');

INSERT INTO Staff
VALUES(485 034 617, 'Clint Barton');


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


INSERT INTO Customer_Serves
VALUES(17, 2013-03-17 19:34:29.523, 550 841 266);

INSERT INTO Customer_Serves
VALUES(1378, 2013-11-02 12:07:11.927, 485 034 617);

INSERT INTO Customer_Serves
VALUES(756, 2014-08-25 14:50:20.398, 045 249 013);

INSERT INTO Customer_Serves
VALUES(4352, 2015-05-29 15:31:45.028, 550 841 266);

INSERT INTO Customer_Serves
VALUES(17, 2015-05-29 15:31:45.028, 485 034 617);


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


INSERT INTO Order_Placed_Ordered
VALUES(13345, 17, 2013-03-17 19:34:29.523, 'Traditional Duck Broth');

INSERT INTO Order_Placed_Ordered
VALUES(20041, 1378, 2013-11-02 12:07:11.927, 'Riviera Bouillabaisse');

INSERT INTO Order_Placed_Ordered
VALUES(57802, 756, 2014-08-25 14:50:20.398, 'Chocolate Mousse Cake');

INSERT INTO Order_Placed_Ordered
VALUES(80927, 4352, 2015-05-29 15:31:45.028, 'Cream Coffee');

INSERT INTO Order_Placed_Ordered
VALUES(80927, 17, 2015-05-29 15:31:45.028, 'Cream Coffee');


INSERT INTO Recipes_Created
VALUES('Bouillabaisse', 550 841 266);

INSERT INTO Recipes_Created
VALUES('Coffee', 941 790 022);

INSERT INTO Recipes_Created
VALUES('Coffee', 779 306 521);

INSERT INTO Recipes_Created
VALUES('Duck Broth', 550 841 266);

INSERT INTO Recipes_Created
VALUES('Chocolate Cake', 485 034 617);


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


INSERT INTO Recipe_To_Menu
VALUES('Bouillabaisse', 32.99);

INSERT INTO Recipe_To_Menu
VALUES('Black Truffle Risotto', 17.99);

INSERT INTO Recipe_To_Menu
VALUES('Coffee', 3.50);

INSERT INTO Recipe_To_Menu
VALUES('Duck Broth', 12.99);

INSERT INTO Recipe_To_Menu
VALUES('Chocolate Cake', 29.99);


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