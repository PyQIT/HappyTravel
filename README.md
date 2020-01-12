# HappyTravel

Project needs global variable. You can easily add it using VM Options in InteliJ Idea.

Variable example:
-Dapp.home=C:\Users\Asus\HappyTravel\Backend\src\main\resources

In sql script change file link to your path.

Example:

INSERT INTO Reservation(id,clientID,sellerID,travelID,adultnumber,childrennumber,cateringtype,alcoholtype,entertaimenttype,ratingtype,paymenttype) SELECT * FROM CSVREAD([b]'C:/Users/Asus/HappyTravel/Backend/src/main/resources/data/Rezerwacja.csv'[/b]);
