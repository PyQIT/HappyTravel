import React from "react"

class SignIn extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            login: "",
            pass: "",
            error: "",
            result: {}
        };
        this.handleChange = this.handleChange.bind(this);
        this.signIn = this.signIn.bind(this);
    }

    handleChange(event){
        const {name, value} = event.target;
        this.setState({
            [name]: value
        })
    }

    signIn(){
        const url ="http://localhost:8080/signin?login=" + this.state.login + "&pass=" + this.state.pass;
        fetch(url)
            .then(response => response.json())
            .then(data =>{
                console.log(data);
                if(data.result === 0) {
                    this.setState({
                        result: data.user,
                        error: "",
                    });
                    this.props.login(1,this.state.result)
                }
                else{
                    this.setState({
                        result: {},
                        error: "Error hasło nieprawidłowe",
                    })
                }
            })
    }



    render(){
        return(
            <div>
                <form  style= {{width: '100%'}}>
                    <div>
                       Username:<br/>
                       <input type='text' name='login'  maxLength="25" onChange={this.handleChange}/><br/>
                    </div>
                    <div>
                   Password:<br/>
                       <input type='password' name='pass'  maxLength="25" onChange={this.handleChange}/><br/>
                    </div>
                </form>
                <div style={{clear: "both"}}>

                </div>
                <div >
                    {this.state.error}
                    <br/>
                    <button className='blueButton' onMouseDown={this.signIn}>Sign In</button><br/>
                </div>
            </div>
        )
    }
}

export default SignIn