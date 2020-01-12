# HappyTravel

Travel agency website solution

## First steps

### Global variable

Project needs global variable. You can easily add it using VM Options in InteliJ Idea.

Example:
```
-Dapp.home=C:\Users\Asus\HappyTravel\Backend\src\main\resources
```

### SQL file path

In sql script change file link to your path.

```
INSERT INTO Reservation(id,clientID,sellerID,travelID,adultnumber,childrennumber,cateringtype,alcoholtype,entertaimenttype,ratingtype,paymenttype) SELECT * FROM CSVREAD(**'C:/Users/Asus/HappyTravel/Backend/src/main/resources/data/Rezerwacja.csv'**);
```

Example:
**'C:/Users/Asus/HappyTravel/Backend/src/main/resources/data/Rezerwacja.csv'**
