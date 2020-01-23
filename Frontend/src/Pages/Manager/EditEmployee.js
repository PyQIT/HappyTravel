import React from "react";
import OfficeAdressDisplay from "./OfficeAdressDisplay";

class EditEmployee extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            editingSalary: false,
            editingPosition: false,
            editingOffice: false,
            off: {},
            salary: null,
            office: null,
            position: null,
            emp: this.props.emp,
        }
        this.flipOffice = this.flipOffice.bind(this);
        this.flipSalary = this.flipSalary.bind(this);
        this.flipPosition = this.flipPosition.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        const {name, value} = event.target;
        this.setState({
            [name]: value
        })
        console.log(name + ": " + value);
    }

    flipSalary(){
        this.Update();
        this.setState((prevState, props) => ({
            editingSalary: !prevState.editingSalary
        }))}

    flipOffice(){
        this.Update();
        this.setState((prevState, props) => ({
            editingOffice: !prevState.editingOffice
        }))}

    flipPosition(){
        this.Update();
        this.setState((prevState, props) => ({
            editingPosition: !prevState.editingPosition
        }))}


    Update(){
        fetch("http://localhost:8080/getEmployee?id=" + this.props.emp.id)
            .then(response => response.json())
            .then(data => {
                this.setState({
                    emp: data,
                })
            })
    }

    changeSalary(){

        if(this.state.salary){
        fetch("http://localhost:8080/updateSalary?loggedUser=" + this.props.loggedUser + "&salary=" + this.state.salary + "&employeeID=" + this.props.emp.id);
            this.flipSalary()
            this.Update();
        }
    }

    changePosition(){
        if(this.state.position){
            fetch("http://localhost:8080/updatePosition?loggedUser=" + this.props.loggedUser + "&position=" + this.state.position + "&employeeID=" + this.props.emp.id);
            this.flipPosition()
            this.Update();
        }
    }
    changeOffice(){
        if(this.state.office){
            fetch("http://localhost:8080/updateOffice?loggedUser=" + this.props.loggedUser + "&officeID=" + this.state.office + "&employeeID=" + this.props.emp.id);
            this.flipOffice();
            this.Update();
        }
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

    render(){
        return(
            <div>
                <p>Editing {this.state.emp.personID.surname} {this.state.emp.personID.name}</p>
                <table>
                    <tbody>

                    <tr>
                        <td>Salary</td>
                        <td>{this.state.emp.salary}</td>
                        <td>{
                            (this.state.editingSalary) ?
                                <button className='blueButton' onMouseDown={()=>this.changeSalary()}>Save</button>
                                :
                                <button className='blueButton' onMouseDown={()=>this.flipSalary()}>Edit</button>
                        }
                        </td>
                        {
                            (this.state.editingSalary) ?
                                <td><input type='number' name='salary' onChange={this.handleChange}/></td>
                                :
                                <td></td>
                        }
                    </tr>
                    <tr>
                        <td>Position</td>
                        <td>{this.state.emp.position}</td>
                        <td>{
                            (this.state.editingPosition) ?
                                <button className='blueButton' onMouseDown={()=>this.changePosition()}>Save</button>
                                :
                                <button className='blueButton' onMouseDown={()=>this.flipPosition()}>Edit</button>
                        }
                        </td>
                        {
                            (this.state.editingPosition) ?
                                <td><select name='position' onChange={this.handleChange}>
                                    <option disabled selected value> -- select a position -- </option>
                                    <option value='Sprzedawca'>Sprzedawca</option>
                                    <option value='Kierownik'>Kierownik</option>
                                    <option value='Przewodnik'>Przewodnik</option>
                                </select>
                                </td>
                                :
                                <td></td>
                        }
                    </tr>
                    <tr>
                        <td>Office</td>
                        <td>{this.state.emp.officeID.adresID.city}, {this.state.emp.officeID.adresID.street} {this.state.emp.officeID.adresID.houseNr}</td>
                        <td>{
                            (this.state.editingOffice) ?
                                <button className='blueButton' onMouseDown={()=>this.changeOffice()}>Save</button>
                                :
                                <button className='blueButton' onMouseDown={()=>this.flipOffice()}>Edit</button>
                        }
                        </td>
                        {
                            (this.state.editingOffice) ?
                                <td><select name='office' onChange={this.handleChange}>
                                    <option disabled selected value> -- select an office -- </option>
                                    {this.displayOfficeList()}
                                </select>
                                </td>
                                :
                                <td></td>
                        }
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }

}
export default EditEmployee;