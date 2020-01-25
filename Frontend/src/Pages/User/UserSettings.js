import React from "react";

class UserSettings extends React.Component{
    constructor(props) {
        super(props);
        this.state ={
            person: {},
            mode: 0,
            oPass: '',
            nPass: '',
            rPass: '',
            nEmail: '',
            errorCode: '',
            result: null,
        }
        this.changeMode = this.changeMode.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.changeEmail =this.changeEmail.bind(this);
        this.changePassword = this.changePassword.bind(this);
        this.fetchPerson = this.fetchPerson.bind(this);
    }

    handleChange(event) {
        const {name, value} = event.target
        this.setState({
            [name]: value
        })
    }

    fetchPerson(){
        fetch("http://localhost:8080/getPersonByUserID?userID="+this.props.loggedUser.id)
            .then(response => response.json())
            .then(data => {
                console.log(data);
                this.setState({
                    person: data
                })})
    }

    changeMode(m){
        if (this.state.mode === m)  {
            this.setState({
                    mode: 0,
                })
        }
        else{
            this.fetchPerson();
            this.setState({
                mode: m,
                errorCode: '',
                result: null,
            })
        }
    }

    changePassword(){
        if(this.state.nPass !== this.state.rPass){
            this.setState({
                errorCode: 'Please repeat the password correctly!'
            })
            return;
        }
        if(this.state.nPass < 6){
            this.setState({
                errorCode: 'Password must be at least 6 characters long!'
            })
            return;
        }
        if(this.state.oPass){
            const url = "http://localhost:8080/changePass"
            + "?oldPass=" + this.state.oPass
            + "&newPass=" + this.state.nPass
            + "&loggedUser=" + this.props.loggedUser.id;
            fetch(url)
                .then(response => response.json())
                .then(data => {
                    console.log('data: '+ data);
                    this.setState({
                        result: data
                    })
                    if(this.state.result === -1) {
                        this.setState({
                            errorCode: 'Incorrect password!'
                        })
                    }
                    else {
                        this.changeMode(0);
                    }
                })
        }
        else{
            this.setState({
                errorCode: 'All fields must be filled',
            })
        }
    }

    changeEmail() {
        if(this.state.nEmail && this.state.oPass) {
            const url = "http://localhost:8080/changeMail"
                + "?pass=" + this.state.oPass
                + "&newMail=" + this.state.nEmail
                + "&loggedUser=" + this.props.loggedUser.id;
            console.log(url);
            fetch(url)
                .then(response => response.json())
                .then(data => {
                    this.setState({
                        result: data
                    })
                    if(this.state.result === -1) {
                        this.setState({
                            errorCode: 'Incorrect password!'
                        })
                    }
                    else {
                        this.changeMode(0);
                    }
                })

        }
        else {
            this.setState({
                errorCode: 'All fields must be filled'
            })
        }
    }

    componentDidMount() {
        this.fetchPerson()
    }

    showSettings(){
        return(
            <div>
                <p>My account</p>
                <table className='contentBlock'><tbody>
                <tr>
                    <td>
                        <b>Login:</b>
                    </td>
                    <td>
                        {this.props.loggedUser.login}
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>Password:</b>
                    </td>
                    <td>
                        <button className='actionCell' onMouseDown={()=>this.changeMode(1)}>Change</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>e-mail</b>
                    </td>
                    <td>
                        {this.state.person.email}
                    </td>
                    <td>
                        <button className='actionCell' onMouseDown={()=>this.changeMode(2)}>Change</button>
                    </td>
                </tr>

                </tbody></table>
            </div>
        )
    }

    passwordChangeScreen(){
        return(
            <div>
                <p>Change password</p>
                <table className='contentBlock'><tbody>
                    <tr>
                        <td>Old password: </td>
                        <td><input type="password" name="oPass" onChange={this.handleChange}/></td>
                    </tr>
                    <tr>
                        <td>New password: </td>
                        <td><input type="password" name="nPass" onChange={this.handleChange}/></td>
                    </tr>
                    <tr>
                        <td>Repeat password: </td>
                        <td><input type="password" name="rPass" onChange={this.handleChange}/></td>
                    </tr>
                </tbody></table>
                <button className='blueButton' onMouseDown={()=>this.changePassword()}>Change</button>
                <button className='blueButton' onMouseDown={()=>this.changeMode(0)}>Cancel</button><br/>
                {this.state.errorCode}
            </div>
        )
    }

    emailChangeScreen(){
        return(
            <div>
                <p>Change email</p>
                <table className='contentBlock'><tbody>
                <tr>
                    <td>New email:</td>
                    <td><input type="text" name="nEmail" onChange={this.handleChange}/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="oPass" onChange={this.handleChange}/></td>
                </tr>
                </tbody></table>
                <button className='blueButton' onMouseDown={()=>this.changeEmail()}>Change</button>
                <button className='blueButton' onMouseDown={()=>this.changeMode(0)}>Cancel</button><br/>
                {this.state.errorCode}
            </div>
        )
    }

    render() {
        if (this.state.mode === 0) return this.showSettings();
        if (this.state.mode === 1) return this.passwordChangeScreen();
        if (this.state.mode === 2) return this.emailChangeScreen();
    }


}

export default UserSettings;