import React from "react";
import TripList from "../Manager/Trips/TripList";
import TripListElement from "../Manager/Trips/TripListElement";
import GuideTripListElement from "./GuideTripListElement";

class GuideTrips extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tripData: [],
            loaded: false,
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/getGuidesTravels?loggedUser=" + this.props.loggedUser)
            .then(response => response.json())
            .then(data => {
                this.setState({
                    tripData: data,
                    loaded: true,
                })
            })
    }


    render(){
            const upTrips = this.state.tripData.map(trip => <GuideTripListElement trip={trip} key={trip.id} mode={0}/>);
            const oldTrips = this.state.tripData.map(trip => <GuideTripListElement trip={trip} key={trip.id} mode={1}/>);
        return(

            <div className='contentBlock'>
                <p>My upcoming trips</p>
                <table className='niceTable'><tbody >{upTrips}</tbody></table>
                <p>Previous trips</p>
                <table className='niceTable'><tbody >{oldTrips}</tbody></table>
            </div>
        )
    }

}

export default GuideTrips;