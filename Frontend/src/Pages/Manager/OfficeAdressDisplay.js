import React from "react";

class OfficeAdressDisplay extends React.Component{
    render(){
        return(
            <option value ={this.props.office.id}>{this.props.office.adresID.city}, {this.props.office.adresID.street} {this.props.office.adresID.houseNr}</option>
        )
    }
}

export default OfficeAdressDisplay;