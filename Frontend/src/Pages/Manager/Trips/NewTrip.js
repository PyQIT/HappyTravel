import React from "react";
import HotelOption from "./HotelOption";

class NewTrip extends React.Component {
    constructor(props) {
        super(props);
        this.state ={
            newHotel: false,
            hotels: [],
        }

    }

    getHotelOptions(){
        fetch("http://localhost:8080/hotels" + this.props.trip.id)
            .then(response => response.json())
            .then(data => {
                this.setState({
                    hotels: data,
                })})
    }

    newHotelMenu(){
        return(
            <div>

            </div>
        )
    }

    render(){
        const hotelOptions = this.state.hotels.map(hotel => <HotelOption hotel={hotel}/>)
        return(
            <div>
                <p>Add a new Trip</p>
                <div>
                    <h2>Location</h2>
                    <table><tbody><tr>
                        <td>
                            Hotel:<br/>
                            <select name='hotel'>{hotelOptions}</select>
                        </td>
                    </tr></tbody></table>
                </div>
            </div>
        )
    }
}

export default NewTrip;