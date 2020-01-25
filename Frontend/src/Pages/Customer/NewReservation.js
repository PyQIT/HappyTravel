import React from "react";
import AvailableTravels from "./AvailableTravels";

class NewReservation extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            adults: 0,
            children: 0,
            catering: false,
            alcohol: false,
            touring: false,
            response: null,
        }
        this.handleChange = this.handleChange.bind(this);

    }

    handleCatering(){
        this.setState((prevState, props) => ({
            catering: !prevState.catering,
        }));
    }
    handleAlcohol(){
        this.setState((prevState, props) => ({
            alcohol: !prevState.alcohol,
        }));
    }
    handleTouring(){
        this.setState((prevState, props) => ({
            touring: !prevState.touring,
        }));
    }

    handleChange(event) {
        let {name, value} = event.target;
        if(value == null) value = 0;
        if(value == "") value = 0;
        if(value < 0){ value = 0; event.target.value = 0}

        console.log(name + ": " + value);
        this.setState({
            [name]: value
        })
    }

    addReservation(){
        if(this.state.adults>0){
            var url = "http://localhost:8080/makeReservation"
                + "?adultNumber=" + this.state.adults
                +"&alcoholtype=" + this.state.alcohol
                +"&cateringtype=" + this.state.catering
                +"&childrennumber=" + this.state.children
                +"&entertainmenttype=" + this.state.touring
                +"&clientid=" + this.props.loggedUser
                +"&travelid=" + this.props.trip.id;
            console.log(url);
            fetch(url)
        }

    }

    render(){

        const diffTime = Math.abs(new Date(this.props.trip.endDate) - new Date(this.props.trip.startDate));
        const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        let totalCost = parseInt(this.state.children) * parseInt(this.props.trip.childCost) + parseInt(this.state.adults) * parseInt(this.props.trip.adultCost);
        if(this.state.catering) totalCost += ((parseInt(this.state.children) + parseInt(this.state.adults)) * parseInt(this.props.trip.cateringCost));
        if(this.state.touring) totalCost += (parseInt(this.props.trip.entertainmentCost));
        if(this.state.alcohol) totalCost += (parseInt(this.state.adults)*parseInt(this.props.trip.alcoholCost));
        return(
            <div>
                <p>Register a new reservation</p>
                <div className='contentBlock'>
                    <h1>{this.props.trip.hotelID.adresID.country}  </h1>
                    Hotel: {this.props.trip.hotelID.hotelName},  {this.props.trip.hotelID.adresID.city}<br/>
                    Starts: {(new Date(this.props.trip.startDate)).toLocaleDateString()}<br/>
                    Ends: {(new Date(this.props.trip.endDate)).toLocaleDateString()} ({diffDays} days)<br/>
                    {this.props.trip.description}
                </div>
                <form>
                    <table>
                        <tbody>
                        <tr>
                            <td>
                                Number of adults
                            </td>
                            <td>
                                <input type="number" name='adults' onChange={this.handleChange}/>
                            </td>
                            <td>
                                {this.state.adults * this.props.trip.adultCost}zł
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Number of children
                            </td>
                            <td>
                                <input type="number" name='children' onChange={this.handleChange}/>
                            </td>
                            <td>
                                {this.state.children * this.props.trip.childCost}zł
                            </td>

                        </tr>
                        <tr>
                            <td>
                                Include catering
                            </td>
                            <td>
                                <input type="checkbox" name='catering' onChange={()=>{this.handleCatering()}} />
                            </td>
                            <td>
                                {(this.state.catering)?((parseInt(this.state.children) + parseInt(this.state.adults))*this.props.trip.cateringCost): null}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Include alcohol
                            </td>
                            <td>
                                <input type="checkbox" name='alcohol' onChange={()=>this.handleAlcohol()}/>
                            </td>
                            <td>
                                {(this.state.alcohol)?((parseInt(this.state.adults))*this.props.trip.alcoholCost) + "zł": null}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Include touring
                            </td>
                            <td>
                                <input type="checkbox" name='touring' onChange={()=>this.handleTouring()}/>
                            </td>
                            <td>
                                {(this.state.touring)?(parseInt(this.props.trip.entertainmentCost)) + "zł": null}
                            </td>
                        </tr>
                        <tr>
                            <td>

                            </td>
                            <td>
                                <h2>Total cost</h2>
                            </td>
                            <td>
                                {totalCost}zł
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
                <button className='blueButton' onMouseDown={()=>this.props.switch(<AvailableTravels loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Cancel</button>
                <button className='blueButton' onMouseDown={()=>this.addReservation()}>Accept</button>
                {this.state.response}
            </div>

        )
    }
}

export default NewReservation;