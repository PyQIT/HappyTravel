import React from "react";
import AvailableTravelsList from "./AviableTravelsList";

class AvailableTravels extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            atData: {},
            loading: true
        };
        this.fetchAvailableTravels = this.fetchAvailableTravels.bind(this)
    }

    componentDidMount() {
        this.fetchAvailableTravels()
    }

    fetchAvailableTravels(){
        fetch("http://localhost:8080/futureTravels")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    loading: false,
                    atData: data
                })
            });
    }

    render(){
        if (this.state.loading) return "Loading...";
        const atlist = this.state.atData.map(atitem => <AvailableTravelsList loggedUser={this.props.loggedUser} switch={this.props.switch} key={atitem.id} atitem={atitem}/>)

        return(
            <div>
                <table className='niceTable'>
                    <tbody>
                    <tr>
                        <td>Hotel</td>
                        <td>Country</td>
                        <td>City</td>
                        <td>Street</td>
                        <td>Apartment</td>
                        <td>Start date</td>
                        <td>End date</td>
                        <td>Price per adult</td>
                        <td>Price per child</td>
                        <td>Catering cost</td>
                        <td>Entertainment cost</td>
                        <td>Description</td>
                        <td>Make a reservation</td>
                    </tr>
                    {atlist}
                    </tbody>
                </table>
            </div>
        )

    }
}
export default AvailableTravels;