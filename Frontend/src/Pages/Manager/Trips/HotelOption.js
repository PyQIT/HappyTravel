import React from "react";

class HotelOption extends React.Component{
    render(){
        return(
            <option value={this.props.hotel.id}>
                {this.props.hotel.adresID.city}, {this.props.hotel.adresID.country} - {this.props.hotel.hotelName}
            </option>
        )
    }
}

export default HotelOption;