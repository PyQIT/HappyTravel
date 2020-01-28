import React from "react";
import NewReservation from "./NewReservation";
import SignUp from "../../Authorization/SignUp";

class AvailableTravelsList extends React.Component{
    handleBooking(){
        console.log("loggedUser = " + this.props.loggedUser);
        if(this.props.loggedUser === null)
            this.props.switch(<SignUp switch={this.props.switch}/>)
        else
            this.props.switch(<NewReservation switch={this.props.switch} loggedUser={this.props.loggedUser} trip={this.props.atitem}/>)
    }
    render(){
        return(
            <tr>
                <td>{this.props.atitem.hotelID.hotelName}</td>
                <td>{this.props.atitem.hotelID.adresID.country}</td>
                <td>{this.props.atitem.hotelID.adresID.city}</td>
                <td>{this.props.atitem.hotelID.adresID.street} {this.props.atitem.hotelID.adresID.houseNR}</td>
                <td>{this.props.atitem.hotelID.adresID.apartmentNr}</td>
                <td>{(new Date(this.props.atitem.startDate)).toLocaleDateString()}</td>
                <td>{(new Date(this.props.atitem.endDate)).toLocaleDateString()}</td>
                <td>{this.props.atitem.adultCost}</td>
                <td>{this.props.atitem.childCost}</td>
                <td>{this.props.atitem.cateringCost}</td>
                <td>{this.props.atitem.entertainmentCost}</td>
                <td>{this.props.atitem.description}</td>
                <td onMouseDown={()=>this.handleBooking()} className="actionCell">Book</td>
            </tr>
        )
    }
}

export default AvailableTravelsList;