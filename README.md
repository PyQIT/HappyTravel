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
INSERT INTO Reservation(id,clientID,sellerID,travelID,adultnumber,childrennumber,cateringtype,alcoholtype,entertaimenttype,ratingtype,paymenttype) SELECT * FROM CSVREAD('C:/Users/Asus/HappyTravel/Backend/src/main/resources/data/Rezerwacja.csv');
```

Example:
**'C:/Users/Asus/HappyTravel/Backend/src/main/resources/data/Rezerwacja.csv'**


## Frontend startup

### Node.js is required

Frontend is written in react.js so you have to have node.js installed.
If you hasn't got it on your PC already just download framework through link [Node.js](https://nodejs.org/en/)

### React.js is required too

Here you can get [React.js](https://react-cn.github.io/react/downloads.html) library.

### Startup finally...

To startup project's frontend open folder then open terminal/cmd/powershell and type ***npm start***.
If doesn't work try ***npm install*** before.

## Backend startup

### InteliJ Idea is recommended

You can turn on the project using InteliJ Idea by JetBrains.
Here is a link to download [Intelij](https://www.jetbrains.com/idea/download/).

After installation turn on the environment, select project, write your VM options variable and change SQL link.
Done!
***Now just turn it on!***
