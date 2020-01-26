import React from 'react';
import './App.css'


import MainPage from './Pages/MainPage.js'
import SignUp from './Authorization/SignUp.js'
import SignIn from './Authorization/SignIn.js'
import NavMenu from "./Navigation/NavMenu";

import baner from './baner.png'


class App extends React.Component {



    constructor(props) {
        super(props);
        this.changeScreen = this.changeScreen.bind(this);
        this.signIn = this.signIn.bind(this);
        this.signOut = this.signOut.bind(this);
        this.openSignUpForm = this.openSignUpForm.bind(this);

        this.state = {
            signedIn: false,
            user: {},
            dbdata: [],
            trip: {},
            trips: [],
        }

    }
    componentDidMount() {
        this.setState((prevState, props) => ({
            currentScreen: <MainPage switch={this.changeScreen} loggedUser={(this.state.signedIn)?this.state.user.id:null}/>
        }));
    }


    changeScreen(screen){
        this.setState((prevState, props) => ({
            currentScreen: screen
        }));
    }

    signIn(i, newUser){
        if(i === 1) {
            this.setState((prevState, props) => ({
                user: newUser,
                signedIn: true,
                currentScreen: null,
            }));
            this.setState({
                currentScreen: <MainPage switch={this.changeScreen} loggedUser={newUser.id} />,
            })
        }
    }
    signOut(){
            this.setState((prevState, props) => ({
                user: {},
                currentScreen: prevState.currentScreen,
                signedIn: false
            }));
            this.changeScreen( <MainPage switch={this.changeScreen} loggedUser={this.state.user.id}/>)
    }


    openSignUpForm(){
        this.setState((prevState, props) => ({
            user: prevState.user,
            currentScreen: <SignUp switch={this.changeScreen}/>,
            signedIn: false
        }));
    }

    render(){
        let loginWindow;
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
                  <img alt = 'baner.png' onMouseDown={()=> this.changeScreen(<MainPage switch={this.changeScreen} loggedUser={(this.state.signedIn)?this.state.user.id:null}/>)} src ={baner} style={{width: '100%'}}></img>
              </div>
              <div>
                  <div className = 'MENU'>
                      {loginWindow}
                      <NavMenu type={this.state.user.userType} switch={this.changeScreen} loggedUser={(this.state.signedIn?this.state.user:null)}/>
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
