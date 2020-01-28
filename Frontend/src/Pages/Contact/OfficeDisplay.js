import React from "react";
class OfficeDisplay extends React.Component {
    render(){
        return (
            <div className='teaser'>
                <h2>{this.props.office.adresID.city}</h2>
                {this.props.office.adresID.street} {this.props.office.adresID.houseNr}<br/>
                tel.: {this.props.tel}
                <hr/>
            </div>
            )
    }
}
export default OfficeDisplay;