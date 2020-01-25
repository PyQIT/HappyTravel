import React from "react";
import Trip from "../Trip";
import EmployeeOnList from "./EmployeeOnList";
import FiredEmployeeOnList from "./FiredEmployeeOnList";
import AddEmployee from "./AddEmployee";
class Employees extends React.Component {
    constructor(props) {
        super(props);
        this.state ={
            empData: {},
            loading: true,
            showCurrent: false,
            showFired: false,
            action: 0,
        }
        this.changeCurrent = this.changeCurrent.bind(this);
        this.changeFired = this.changeFired.bind(this);
        this.fetchEmployeeList = this.fetchEmployeeList.bind(this)
    }
    componentDidMount() {
        this.fetchEmployeeList()
    }

    fetchEmployeeList(){
        console.log("UPDATE");
        fetch("http://localhost:8080/employees")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    loading: false,
                    empData: data
                })
            })
    }
    changeCurrent(){
        this.setState((prevState, props) => ({
            showCurrent: !prevState.showCurrent,
            showFired: prevState.showFired
        }));
    }
    changeFired(){
        this.setState((prevState, props) => ({
            showCurrent: prevState.showCurrent,
            showFired: !prevState.showFired
        }));
    }

    setAction(a){
        if (this.state.action === a){
            this.setState((prevState, props) => ({
                showCurrent: prevState.showCurrent,
                showFired: prevState.showFired,
                action: 0,
            }));
            return;
        }
        this.setState((prevState, props) => ({
            showCurrent: true,
            showFired: false,
            action: a
        }));
    }

    getCurrentEmployeeList(){
        if(!this.state.showCurrent)
            return null;
        if(this.state.loading)
            return ("Loading employees...");
        const empList = this.state.empData.map(emp =>(emp.firingDate==null)?<EmployeeOnList key={emp.id} emp={emp} loggedUser={this.props.loggedUser} action={this.state.action} refresh = {this.fetchEmployeeList} switch={this.props.switch}/>:null);
        return(
            <div>
                <table className='niceTable'>
                    <tbody>
                        <tr>
                            <td>Surname</td>
                            <td>Name</td>
                            <td>Position</td>
                            <td>Office</td>
                            <td>Hired</td>
                            {this.state.action!=='none'?<td>Action</td>:null}
                        </tr>
                       {empList}
                    </tbody>
                </table>
            </div>
        )
    }



    getFiredEmployeeList(){
        if(!this.state.showFired)
            return null;
        if(this.state.loading)
            return ("Loading employees...");
        const empList = this.state.empData.map(emp =>(emp.firingDate!=null)?<FiredEmployeeOnList key={emp.id} emp={emp}/>:null);
        return(
            <div>
                <table className='niceTable'>
                    <tbody>
                    <tr>
                        <td>Surname</td>
                        <td>Name</td>
                        <td>Position</td>
                        <td>Office</td>
                        <td>Hired</td>
                        <td>Left</td>
                    </tr>
                    {empList}
                    </tbody>
                </table>
            </div>
        )
    }

    render(){
        return(
        <div>
            <p>Employee Management</p>
            <div>
                <button className='blueButton' onMouseDown={()=> this.props.switch(<AddEmployee switch={this.props.switch} loggedUser={this.props.loggedUser}/>)}>Add</button>
                <button className='blueButton' onMouseDown={()=> this.setAction(1)}>Modify</button>
                <button className='blueButton' onMouseDown={()=> this.setAction(2)}>Fire</button>

            </div>
            <p onMouseDown={this.changeCurrent}>Current Employees</p>
            {this.getCurrentEmployeeList()}
            <p onMouseDown={this.changeFired}>Former Employees</p>
            {this.getFiredEmployeeList()}
        </div>
        )
    }
}

export default Employees;