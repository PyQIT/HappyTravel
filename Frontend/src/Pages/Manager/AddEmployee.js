import React from "react";
import EmployeeOnList from "./EmployeeOnList";
import Trip from "../Trip";
import OfficeAdressDisplay from "./OfficeAdressDisplay";
import Employees from "./Employees";

class AddEmployee extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            off: [],
            name: '',
            lname: '',
            pnumber: null,
            phone: null,
            email: null,
            position: null,
            office: 0,
            salary: null,
            created: false,
            errorMsg: "",
            result: {}
        }
        this.handleChange = this.handleChange.bind(this);
        this.addEmployee = this.addEmployee.bind(this);
    }

    componentDidMount() {
        fetch("http://localhost:8080/offices")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    off: data
                })
            })
    }

    displayOfficeList(){
        const offices = this.state.off.map(office => <OfficeAdressDisplay key={office.id} office={office}/>)
        return offices
    }

    handleChange(event) {
        const {name, value} = event.target
        this.setState({
            [name]: value

        })
    }

    changeErrorMsg(msg){
        this.setState({
            errorMsg: msg

        })
    }



    display(){
        if(!this.state.created){
            return(
                <div>
                    <p>Create an account for new employee</p><hr/>
                    <form style= {{width: '100%'}}>
                        <h1>Personal data</h1><hr/>
                        <div>
                            <div className='formField'>Name:</div>
                            <div className='formField'><input type='text' name='name' maxLength="25" onChange={this.handleChange}/></div><br/>
                        </div>
                        <div>
                            <div className='formField'>Last Name:</div>
                            <div className='formField'><input type='text' name='lname' maxLength="25" onChange={this.handleChange}/></div><br/>
                        </div>

                        <div>
                            <div className='formField'>Personal number:</div>
                            <div className='formField'><input type='text' name='pnumber' maxLength="25" onChange={this.handleChange}/></div><br/>
                        </div>
                        <h1>Contact</h1><hr/>
                        <div>
                            <div className='formField'>phone:</div>
                            <div className='formField'><input type='text' name='phone' maxLength="25" onChange={this.handleChange}/></div><br/>
                        </div>
                        <div>
                            <div className='formField'>e-mail:</div>
                            <div className='formField'><input type='text' name='email' maxLength="25" onChange={this.handleChange}/></div><br/>
                        </div>
                        <h1>Organization</h1><hr/>
                        <div>
                            <div className='formField'>Position:</div>
                            <div className='formField'>
                                <select name='position' onChange={this.handleChange}>
                                    <option disabled selected value> -- select a position -- </option>
                                    <option value='Sprzedawca'>Sprzedawca</option>
                                    <option value='Kierownik'>Kierownik</option>
                                    <option value='Przewodnik'>Przewodnik</option>
                                </select>
                            </div>
                        </div><br/>

                        <div>                        <div className='formField'>Office:</div>
                            <div className='formField'>
                                <select name='office' onChange={this.handleChange}>
                                    <option disabled selected value> -- select an office -- </option>
                                    {this.displayOfficeList()}
                                </select>
                            </div>
                        </div><br/>
                        <div>
                            <div className='formField'>Salary:</div>
                            <div className='formField'><input type='number' name='salary' step='100' maxLength="25" onChange={this.handleChange}/><br/></div>
                        </div><br/>
                    </form><br/>
                    <button className='blueButton' onMouseDown={this.addEmployee}>Add</button>
                    <button className='blueButton' onMouseDown={()=> this.props.switch(<Employees loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Return</button>
                </div>
            )
        }
        else{
            return(
                <div>
                    <p>
                        Account created for {this.state.lname} {this.state.name}!<br/>
                        login: {this.state.result.login}<br/>
                        password: {this.state.result.password}<br/>
                        <button className='blueButton' onMouseDown={()=> this.props.switch(<Employees loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>OK</button>
                    </p>
                </div>
            )
        }
    }


    addEmployee(){
        if(this.state.name && this.state.lname && this.state.pnumber && this.state.email && this.state.phone && this.state.position && this.state.salary && this.state.office){
            let url = "http://localhost:8080/signEmployee?loggedUser=" + 0
            + "&name=" + this.state.name
            + "&lastName=" + this.state.lname
            + "&email=" + this.state.email
            + "&pesel=" + this.state.pnumber
            + "&phoneNumber=" + this.state.phone
            + "&type=" + this.state.position
            + "&salary=" + this.state.salary
            + "&officeID=" + this.state.office;
            console.log(url);
            fetch(url)
                .then(response => response.json())
                .then(data => {
                    console.log("Data: " + data);
                    this.setState({
                        result: data,
                        created: true,
                    })
                })
        }
    }

    render(){
        return(this.display());
    }
}

export default AddEmployee;