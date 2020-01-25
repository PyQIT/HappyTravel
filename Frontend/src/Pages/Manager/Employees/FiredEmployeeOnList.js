import React from "react";

class FiredEmployeeOnList extends React.Component{
    render(){
        return(
            <tr>
                <td>{this.props.emp.personID.surname}</td>
                <td>{this.props.emp.personID.name}</td>
                <td>{this.props.emp.position}</td>
                <td>{this.props.emp.officeID.id}</td>
                <td>{(new Date(this.props.emp.hiringDate)).toLocaleDateString()}</td>
                <td>{(new Date(this.props.emp.firingDate)).toLocaleDateString()}</td>
            </tr>
        )
    }
}

export default FiredEmployeeOnList;