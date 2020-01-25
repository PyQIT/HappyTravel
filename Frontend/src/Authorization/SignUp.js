import React from 'react';

import MainPage from "../Pages/MainPage";

class SignUp extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            succeded: false,
            //Form data
            login: "",
            pass: "",
            pass2: "",
            type: "Klient",
            resp: 1,
            fname: "",
            lname: "",
            pnumber: "",
            phone: "",
            email: ""
        };
        this.handleChange = this.handleChange.bind(this);
        this.signUp = this.signUp.bind(this);
    }


    signUp(){
        let correct = true;
        console.log("signUp()");
        if(this.state.pass !== this.state.pass2){
            correct = false;
            this.setState((prevState, props) => ({
                pass: prevState.pass,
                pass2: prevState.pass2,
                error: "Passwords doesn't match!"
            }));
        }
        if(this.state.pass.length < 6){
            correct = false;
            this.setState((prevState, props) => ({
                pass: prevState.pass,
                pass2: prevState.pass2,
                error: "Password must be 6 characters or longer!"
            }));
        }

        if(correct){
            if(this.state.login && this.state.pass && this.state.fname && this.state.lname && this.state.email && this.state.phone && this.state.pnumber){
                console.log(this.state.pass + " = " + this.state.pass2);
                const url ="http://localhost:8080/signup?login=" + this.state.login + "&pass=" + this.state.pass + "&name=" + this.state.fname + "&lastName=" + this.state.lname
                    + "&email=" + this.state.email + "&pesel=" + this.state.pnumber + "&phoneNumber=" + this.state.phone
                console.log(url);
                fetch(url)
                    .then(response => response.json())
                    .then(data => {
                        let r;
                        console.log(data);
                        if (data === 0) {
                            r = "Dodano pomyslnie";
                            this.setState({
                                succeded: true
                            })
                        }
                        else{
                            if(data === -1){
                                this.setState((prevState, props) => ({
                                    error: "This username is already taken!"
                                }));
                            }
                            if(data === -2){
                                this.setState((prevState, props) => ({
                                    error: "This email is already used!"
                                }));
                            }
                        }

                        this.setState({
                            resp: r
                        })
                    })
                //
            }
            else{
                this.setState((prevState, props) => ({
                    error: "All fields must be filled!"
                }))
            }
        }

    }

    handleChange(event) {
        const {name, value} = event.target;
        this.setState({
            [name]: value
        })
    }

    returnToMainPage(){
        this.props.switch(<MainPage switch={this.props.switch} />)
    }

    render(){
        let content;
        if(!this.state.succeded){
            content = (
                <div className='signUpScreen'>
                    <form  style= {{width: '100%'}}>
                        <hr/>
                        <h1>User data</h1>
                        <div>
                            <div style= {{width: '40%', float: 'left'}}>Username:</div>
                            <div style= {{width: '50%', float: 'left'}}><input type='text' name='login' maxLength="25" onChange={this.handleChange}/><br/></div>
                        </div>
                        <div>
                            <div style= {{width: '40%', float: 'left'}}>Password:</div>
                            <div style= {{width: '50%', float: 'left'}}><input type='password' maxLength="25" name='pass' onChange={this.handleChange}/><br/></div>
                        </div>
                        <div>
                            <div style= {{width: '40%', float: 'left'}}>Repeat Password:</div>
                            <div style= {{width: '50%', float: 'left'}}><input type='password' maxLength="25" name='pass2' onChange={this.handleChange}/><br/></div>
                        </div>



                        <h1>Personal Data</h1>
                        <div>
                            <div style= {{width: '40%', float: 'left'}}>First Name:</div>
                            <div style= {{width: '50%', float: 'left'}}><input type='text' name='fname' onChange={this.handleChange}/><br/></div>
                        </div>
                        <div>
                            <div style= {{width: '40%', float: 'left'}}>Last Name:</div>
                            <div style= {{width: '50%', float: 'left'}}><input type='text' name='lname' onChange={this.handleChange}/><br/></div>
                        </div>
                        <div>
                            <div style= {{width: '40%', float: 'left'}}>Email Address:</div>
                            <div style= {{width: '50%', float: 'left'}}><input type='text' name='email' onChange={this.handleChange}/><br/></div>
                        </div>
                        <div>
                            <div style= {{width: '40%', float: 'left'}}>Personal Number:</div>
                            <div style= {{width: '50%', float: 'left'}}><input type='number' maxLength="10" name='pnumber' onChange={this.handleChange}/><br/></div>
                        </div>
                        <div>
                            <div style= {{width: '40%', float: 'left'}}>Phone number:</div>
                            <div style= {{width: '50%', float: 'left'}}><input type='number' maxLength="11" name='phone' onChange={this.handleChange}/><br/></div>
                        </div>
                        <div style={{clear: 'both', paddingTop: '10px'}}><hr/></div>

                    </form>
                    <button className='blueButton' onClick={this.signUp}>Sign Up</button><br/>
                    <div style={{color: 'red'}}><b>{this.state.error}</b></div>

                </div>
            )
        }
        else {
            content = (
                <div className="signUpScreen">
                    Account <b>{this.state.login}</b> has been created!<br/> Use sidebar to sign in.<br/>
                    <button className="blueButton" onMouseDown={() => this.props.switch(<MainPage switch={this.props.switch}/>)}>OK</button>
                </div>
            )
        }

        return(
            <div>
                {content}
            </div>
            )
    }
}

export default SignUp