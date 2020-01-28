import React from "react";
import EditTrip from "./EditTrip";

class TripListElement extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            reservations: 0,
        }
    }

    componentDidMount() {
        fetch("http://localhost:8080/countReservations?travelID=" + this.props.trip.id)
            .then(response => response.json())
            .then(data => {
                this.setState({
                    reservations: data,
                })})
    }

    deleteTrip(){
        const url = "http://localhost:8080/deleteTravel?travelID=" + this.props.trip.id + "&loggedUser=" + this.props.loggedUser;
        fetch(url)
            .then(data => {
                this.props.update();
                })

    }

    editTrip(){
        this.props.switch(<EditTrip trip={this.props.trip} loggedUser={this.props.loggedUser} switch={this.props.switch}/>);
    }

    clicked(){
        if(this.props.action === 2) this.deleteTrip();
        if(this.props.action === 1) this.editTrip();
    }

    render() {
        let action;
        if(this.props.action === 1)
            action = "Manage";
        if(this.props.action === 2)
            action = "Delete";
        return(
            <tr>
                <td>{(new Date(this.props.trip.startDate)).toLocaleDateString()}</td>
                <td>{(new Date(this.props.trip.endDate)).toLocaleDateString()}</td>
                <td>{this.props.trip.hotelID.adresID.city}</td>
                <td>{this.props.trip.hotelID.adresID.country}</td>
                <td>{this.props.trip.hotelID.hotelName}</td>
                <td>{this.state.reservations}</td>
                {(this.props.action!==0)?<td className='actionCell' onMouseDown={()=>this.clicked()}>{action}</td>:null}
            </tr>
        )
    }
}

export default TripListElement;