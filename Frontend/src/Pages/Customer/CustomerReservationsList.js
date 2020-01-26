import React from "react";

class CustomerReservationsList extends React.Component{

    constructor(props){
        super(props);
        this.handleCancelReservation = this.handleCancelReservation.bind(this);
    }

    handleCancelReservation(rid,cid){
        let url = "http://localhost:8080/cancelReservation?"+"reservationID="+rid+"&clientID="+cid;
        console.log(url);
        fetch(url)
            .then(response => response.json());
        this.props.refresh();
    }

    render(){
        const divStyle = {
            border:"solid",
            width:"200px",
            overflow:"auto",
            float:"left",
            margin:"10px 10px 10px 10px"
        };
        return(
            <div style={divStyle}>
                <table className="niceTable">
                    <tbody>
                        <tr>
                            <td>Reservation Id:</td><td>{this.props.crItem.id}</td>
                        </tr>
                        <tr>
                            <td>Hotel:</td><td>{this.props.crItem.travelID.hotelID.hotelName}</td>
                        </tr>
                        <tr>
                            <td>Country:</td><td>{this.props.crItem.travelID.hotelID.adresID.country}</td>
                        </tr>
                        <tr>
                            <td>City:</td><td>{this.props.crItem.travelID.hotelID.adresID.city}</td>
                        </tr>
                        <tr>
                            <td>Street:</td><td>{this.props.crItem.travelID.hotelID.adresID.street}</td>
                        </tr>
                        <tr>
                            <td>Apartment:</td><td>{this.props.crItem.travelID.hotelID.adresID.apartment}</td>
                        </tr>
                        <tr>
                            <td>Start date:</td><td>{(new Date(this.props.crItem.travelID.startDate)).toLocaleDateString()}</td>
                        </tr>
                        <tr>
                            <td>End date:</td><td>{(new Date(this.props.crItem.travelID.endDate)).toLocaleDateString()}</td>
                        </tr>
                        <tr>
                            <td>Adults:</td><td>{this.props.crItem.adultNumber}</td>
                        </tr>
                        <tr>
                            <td>Children:</td><td>{this.props.crItem.childrenNumber}</td>
                        </tr>
                        <tr>
                            <td>Catering:</td><td>{this.props.crItem.cateringType}</td>
                        </tr>
                        <tr>
                            <td>Alcohol Type:</td><td>{this.props.crItem.alcoholType}</td>
                        </tr>
                        <tr>
                            <td>Entertainment Type:</td><td>{this.props.crItem.entertaimentType}</td>
                        </tr>
                        <tr>
                            <td>Rating:</td><td>{this.props.crItem.ratingType}</td>
                        </tr>
                        <tr>
                            <td>Payment Type:</td><td>{this.props.crItem.paymentType}</td>
                        </tr>
                        {(this.props.showHistory === false)?<tr><td></td><td><button onMouseDown={()=>this.handleCancelReservation(this.props.crItem.id,this.props.loggedUser.id)}>Cancel</button></td></tr>:""}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default CustomerReservationsList;