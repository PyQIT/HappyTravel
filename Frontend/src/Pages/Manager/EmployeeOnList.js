import React from "react";

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
        fetch("http://localhost:8080/fireEmployee?loggedUser="+u+"&employeeID="+id)
            .then(response => response.json())
        this.props.refresh();
    }

    takeAction(){
        console.out('Action taken');
        if (this.state.action == 'fire') this.fire();
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
                {(this.props.action !='none')?<td onMouseDown={()=>this.fire(this.props.loggedUser, this.props.emp.id)} className='actionCell'>{this.props.action}</td>:null}
            </tr>
        )
    }
}

export default EmployeeOnList;