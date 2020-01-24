import React from 'react';
import './App.css'


import MainPage from './Pages/MainPage.js'
import SignUp from './Authorization/SignUp.js'
import SignIn from './Authorization/SignIn.js'
import NavMenu from "./Navigation/NavMenu";
import Employees from "./Pages/Manager/Employees";

import baner from './baner.png'
import EmployeeOnList from "./Pages/Manager/EmployeeOnList";
import AddEmployee from "./Pages/Manager/AddEmployee";
import NewReservation from "./Pages/Customer/NewReservation";
import Trip from "./Pages/Trip";

class App extends React.Component {



    constructor(props) {
        super(props);
        console.log("App constructor()");
        this.changeScreen = this.changeScreen.bind(this);
        this.signIn = this.signIn.bind(this);
        this.signOut = this.signOut.bind(this);
        this.openSignUpForm = this.openSignUpForm.bind(this);

        this.state = {
            signedIn: false,
            user: {},
            dbdata: [],
            trip: {},
            trips: []
        }

    }
    componentDidMount() {


        this.setState((prevState, props) => ({
            currentScreen: <MainPage/>
        }));
    }


    changeScreen(screen){
        this.setState((prevState, props) => ({
            currentScreen: screen
        }));
    }

    signIn(i, newUser){
        if(i == 1) {
            this.setState((prevState, props) => ({
                user: newUser,
                currentScreen: prevState.currentScreen,
                signedIn: true
            }));
        }
    }
    signOut(){
            this.setState((prevState, props) => ({
                user: {},
                currentScreen: prevState.currentScreen,
                signedIn: false
            }));
    }


    openSignUpForm(){
        this.setState((prevState, props) => ({
            user: prevState.user,
            currentScreen: <SignUp switch={this.changeScreen}/>,
            signedIn: false
        }));
    }

    render(){
        let loginWindow
        const trips = this.state.dbdata.map(trip => <NewReservation key={trip.id} trip={trip}/>)
        if(this.state.signedIn){
            loginWindow = (
                <div className='signInScreen'>
                    <p>Signed in as {this.state.user.login}</p>
                    <button className='blueButton' onMouseDown={this.signOut}>Sign Out</button><hr/>
                </div>

            )
        }
        else{
            loginWindow =(
                <div>
                    <SignIn login={this.signIn}/>
                    <br/>
                    <hr/>
                    Not registered yet?<br/>
                    <button className='blueButton' onMouseDown={this.openSignUpForm}>Sign Up</button>
                    <br/><hr/>
                </div>
            )
        }

      return (
          <div>
              <div className = 'NAGLOWEK'>
                  <img onMouseDown={()=> this.changeScreen(<MainPage switch={this.changeScreen}/>)} src ={baner} style={{width: '100%'}}></img>
              </div>
              <div>
                  <div className = 'MENU'>
                      {loginWindow}
                      <NavMenu type={this.state.user.userType} switch={this.changeScreen} loggedUser={(this.state.user?this.state.user.id:null)}/>
                  </div>
                  <div className = 'TRESC'>
                          {this.state.currentScreen}
                  </div>
              </div>
              <div className = 'STOPKA'>
                  Happy Travel 2020
              </div>
          </div>
      )
    }
}

export default App;
