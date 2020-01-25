import React from "react";
import EditEmployee from "./EditEmployee";

class EmployeeOnList extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            action: this.props.action,
            loggedUser: this.props.loggedUser
        }
    }

    isFired(){
        return (this.props.emp.firingDate == null)
    }

    fire(u, id){
        console.log("Fire");
        fetch("http://localhost:8080/fireEmployee?loggedUser="+u+"&employeeID="+id)
            .then(response => response.json())
        this.props.refresh();
    }

    modify(u, id){
        this.props.switch(<EditEmployee emp={this.props.emp} switch={this.props.switch} loggedUser={u}/>)
    }

    takeAction(logedUser, id){
        console.log("Action Taken: " + this.props.action)
        if (this.props.action === 2) {this.fire(logedUser, id);}
        if (this.props.action === 1) {this.modify(logedUser, id);}
        this.props.refresh();
    }

    render(){

        return(
            <tr>
                <td>{this.props.emp.personID.surname}</td>
                <td>{this.props.emp.personID.name}</td>
                <td>{this.props.emp.position}</td>
                <td>{this.props.emp.officeID.id}</td>
                <td>{(new Date(this.props.emp.hiringDate)).toLocaleDateString()}</td>
                {(this.props.action !==0)?<td onMouseDown={()=>this.takeAction(this.props.loggedUser, this.props.emp.id)} className='actionCell'>{(this.props.action==1)?"Modify":"Fire"}</td>:null}
            </tr>
        )
    }
}

export default EmployeeOnList;