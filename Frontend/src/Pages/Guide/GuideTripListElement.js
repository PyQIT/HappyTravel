import React from "react";

class GuideTripListElement extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            upcoming: this.props.trip.startDate >= new Date()
        }
    }

    isUpcoming(){
        return this.state.upcoming;
    }


    render() {

        if((this.props.mode === 0 &&  this.state.upcoming)|| (this.props.mode === 1 && !this.state.upcoming)) {
            return (
                <tr>
                    <td>{(new Date(this.props.trip.startDate)).toLocaleDateString()}</td>
                    <td>{(new Date(this.props.trip.endDate)).toLocaleDateString()}</td>
                    <td>{this.props.trip.hotelID.adresID.city}</td>
                    <td>{this.props.trip.hotelID.adresID.country}</td>
                    <td>{this.props.trip.hotelID.hotelName}</td>
                </tr>
            )
        }
        return null;
    }
}

export default GuideTripListElement
