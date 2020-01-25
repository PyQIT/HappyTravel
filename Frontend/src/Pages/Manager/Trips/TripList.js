import React from "react";
import TripListElement from "./TripListElement";
import NewTrip from "./NewTrip";

class TripList extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            tripsData: [],
            action: 0,
        }
        this.getTravels = this.getTravels.bind(this);
    }

    getTravels(){
        fetch("http://localhost:8080/futureTravels")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    tripsData: data
                })
            })
    }

    componentDidMount() {
       this.getTravels();
    }

    changeAction(a){
        if(this.state.action === a)
            this.setState({
                action: 0,
            })
        else
            this.setState({
                action: a,
            })
    }

    render(){
        const listElements = this.state.tripsData.map(trip => <TripListElement key={trip.id} trip={trip} action={this.state.action} loggedUser={this.props.loggedUser} update={this.getTravels}/>);
        return(
            <div>
                <p>Upcoming Trips</p>
                <button className='blueButton' onMouseDown={()=>this.props.switch(<NewTrip switch={this.props.switch} loggedUser={this.props.loggedUser}/>)}>Add</button>
                <button className='blueButton' onMouseDown={()=>this.changeAction(1)}>Manage</button>
                <button className='blueButton' onMouseDown={()=>this.changeAction(2)}>Delete</button>
                <table className='niceTable'><tbody>
                <tr>
                    <td>Starts</td>
                    <td>Ends</td>
                    <td>City</td>
                    <td>Country</td>
                    <td>Hotel</td>
                    <td>Reservations</td>
                    {(this.state.action!==0)? <td>Action</td>:null}
                </tr>
                {listElements}
                </tbody></table>
            </div>
        )
    }
}

export default TripList;
