import React from "react";
import CustomerReservationsList from "./CustomerReservationsList";

class CustomerReservations extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            crData: {},
            loading: true,
            showHistory: false
        };
        this.fetchReservations = this.fetchReservations.bind(this);
        this.switchReservations = this.switchReservations.bind(this);
    }

    fetchReservations(){
        console.log("Update");
        fetch("http://localhost:8080/reservations")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    loading: false,
                    crData: data
                })
            });
    }

    componentDidMount() {
        this.fetchReservations();
    }

    switchReservations(){
        this.setState((prevState)=> ({
            showHistory: !prevState.showHistory
        }));
    }

    render() {
        if (this.state.loading) return "Loading...";
        const crList = this.state.crData.filter(crItem =>{
            let id = parseInt(this.props.loggedUser.id,10);
            if((crItem.clientID.personID.userID.id === id)){
                return <CustomerReservationsList loggedUser={this.props.loggedUser} switch={this.props.switch}
                                                 key={crItem.id} crItem={crItem} refresh={this.fetchReservations}/>
            } else {
                return null
            }
        });
        const crListH = crList.map(crItem =>{
            if(new Date(crItem.travelID.endDate) < new Date()){
                return <CustomerReservationsList loggedUser={this.props.loggedUser} switch={this.props.switch} showHistory={this.state.showHistory}
                                                  key={crItem.id} crItem={crItem} refresh={this.fetchReservations}/>}
            else {
                return null
            }
        });

        const crListC = crList.map(crItem =>{
            if(new Date(crItem.travelID.endDate) > new Date()){
                return <CustomerReservationsList loggedUser={this.props.loggedUser} switch={this.props.switch} showHistory={this.state.showHistory}
                                                 key={crItem.id} crItem={crItem} refresh={this.fetchReservations} />}
            else {
                return null}});
        console.log(crList);
        return (
            <div>
                {(this.state.showHistory === false)?<button className="blueButton" onMouseDown={()=>this.switchReservations()}>History</button>:<button className="blueButton" onMouseDown={()=>this.switchReservations()}>Current</button>}
                <div>
                    {(this.state.showHistory === false)?crListC:crListH}
                </div>
            </div>
        )
    }
}

export default CustomerReservations;