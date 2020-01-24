import React from "react"
import Trip from "./Trip.js"

class TripList extends React.Component {

    constructor() {
        super()
        this.state = {
            loading: true,
            dbdata: [],
            hoteldata: [],
            adresdata: [],
            tripComponents: {}
        }
    }

    componentDidMount(){

        this.setState({loading: true})

        fetch("http://localhost:8080/travel")
            .then(response => response.json())
            .then(data => {
            this.setState({
                loading: false,
                dbdata: data
            })
        })
    }

    draw (element, index, array){
        console.log("draw()")
        return "-AAA-\n"
    }

    render () {
        const text = this.state.loading ? "loading..." : "loaded!";


         const trips = this.state.dbdata.map(trip => <Trip key={trip.id} trip={trip}/>)

        console.log(trips);
        console.log(this.state.dbdata);
        return(
            <div>
                {text}
                <ul>
                {trips}
                </ul>
            </div>
        )

    }


}
export default TripList;
