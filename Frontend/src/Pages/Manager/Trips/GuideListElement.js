import React from "react";

class GuideListElement extends React.Component{

    render(){
        return(
            <option value={this.props.guide.id}>{this.props.guide.employeeID.personID.surname} {this.props.guide.employeeID.personID.name}</option>
        )
    }
}

export default GuideListElement