import React from "react";
import HotelOption from "./HotelOption";
import CountryOption from "../../../Components/CountryOption";
import TripList from "./TripList";

class NewTrip extends React.Component {
    constructor(props) {
        super(props);
        this.state ={
            newHotel: false,
            hotels: [],
            //Trip Form
            hotel: null,
            starts: new Date(),
            ends: new Date(),
            desc: "",
            adult: null,
            child: null,
            alcohol: null,
            ent: null,
            catering: null,
            errorCode: '',
            //HotelMenu
            h_country:null,
            h_name:null,
            h_city: null,
            h_street:null,
            h_housenr:null,
            h_errcode: "",

        };
        this.flipHotelMenu = this.flipHotelMenu.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.addHotel = this.addHotel.bind(this);
        this.addTrip = this.addTrip.bind(this);
    }

    componentDidMount() {
        this.getHotelOptions();
    }

    getHotelOptions(){
        fetch("http://localhost:8080/hotels")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    hotels: data,
                })})
    }

    flipHotelMenu(){
        this.setState((prevState, props)=>({
            newHotel: !prevState.newHotel,
        }));
    }

    handleChange(event) {
        const {name, value} = event.target;
        this.setState({
            [name]: value
        })
    }

    addHotel(){
        if((this.state.h_city) && (this.state.h_country) && (this.state.h_housenr) && (this.state.h_street) && (this.state.h_name)){
            const url = "http://localhost:8080/addAdressAndHotel"
                + "?loggedUser=" + this.props.loggedUser
                + "&city=" + this.state.h_city
                + "&country=" + this.state.h_country
                + "&hNR=" + this.state.h_housenr
                + "&street=" + this.state.h_street
                + "&hotelName=" + this.state.h_name;

            fetch(url)
                .then(response => response.json())
                .then(data => {
                    this.getHotelOptions()});
            this.flipHotelMenu();
        }
        else{
            this.setState({
                h_errcode: "All fields must be filled",
            })
        }

    }

    newHotelMenu(){
        return(
            <div>
            <table>
                <tbody>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="h_name" onChange={this.handleChange}/></td>
                </tr>
                <tr>
                    <td>Country:</td>
                  <td><CountryOption name="h_country" onChange={this.handleChange}/></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><input type="text" name="h_city" onChange={this.handleChange}/></td>
                </tr>
                <tr>
                    <td>Street:</td>
                    <td><input type="text" name="h_street" onChange={this.handleChange}/></td>
                </tr>
                <tr>
                    <td>House nr:</td>
                    <td><input type="text" name="h_housenr" onChange={this.handleChange}/></td>
                </tr>
                <tr>
                    <td><button className='blueButton' onMouseDown={this.addHotel}>Add</button></td>
                    <td><button className='blueButton' onMouseDown={this.flipHotelMenu}>Cancel</button></td>
                </tr>
                </tbody>
            </table>
                {this.state.h_errcode}
            </div>
        )
    }


    addTrip(){
        if(this.state.start > this.state.end){
            this.setState({
                errorCode: "Trip start date must be earlier than the end date!",
            })
        }
        if(this.state.starts && this.state.ends && this.state.hotel && this.state.desc && this.state.adult && this.state.child){
            const alco = (this.state.alcohol)?this.state.alcohol:-1;
            const cat = (this.state.catering)?this.state.catering:-1;
            const e = (this.state.e)?this.state.e:-1;
            const url = "http://localhost:8080/addTravel"
            + "?adultCost=" + this.state.adult
            + "&alcoholCost=" + alco
            + "&cateringCost=" + cat
            + "&childCost=" + this.state.child
            + "&description=" + this.state.desc
            + "&endDate=" + this.state.ends
            + "&entertainmentCost=" + e
            + "&startDate=" + this.state.starts
            + "&hotelID=" + this.state.hotel
            + "&loggedUser=" +this.props.loggedUser;

            fetch(url)
                .then(response => response.json())
                .then(data => {
                    this.props.switch(<TripList loggedUser={this.props.loggedUser} switch={this.props.switch}/>);
                   })
        }
        else{
            this.setState({
                errorCode: 'All fields must be filled!',
            })
        }
    }

    render(){
        const hotelOptions = this.state.hotels.map(hotel => <HotelOption key={hotel.id} hotel={hotel}/>);
        return(
            <div>
                <p>Add a new Trip</p>
                <div className='textBlock'>
                    <h2>Location</h2>
                    <table style={{width: '100%'}}><tbody><tr>
                        <td>
                            Hotel:<br/>
                            <select name='hotel' onChange={this.handleChange} defaultValue='default'>
                                <option disabled value='default'> -- select a hotel -- </option>
                                {hotelOptions}
                            </select>
                        </td>
                        <td>{(this.state.newHotel)?this.newHotelMenu():<button className='blueButton' onMouseDown={()=>this.flipHotelMenu()}>Add hotel</button>}</td>
                    </tr></tbody></table>
                    <h2>Schedule</h2>
                    <table style={{width: '100%'}}><tbody>
                    <tr>
                        <td>Starts:</td>
                        <td><input type="date" onChange={this.handleChange} name={"starts"}/></td>
                    </tr>
                    <tr>
                        <td>Ends:</td>
                        <td><input type="date" onChange={this.handleChange} name={"ends"}/></td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td><textarea maxLength='255' name="desc" onChange={this.handleChange} /><br/><small>{255-this.state.desc.length} characters left</small></td>
                    </tr>
                    </tbody></table>
                    <h2>Pricing</h2>
                    <table><tbody>
                    <tr>
                        <td>Cost per adult</td>
                        <td><input type="number" name="adult" onChange={this.handleChange}/></td>
                    </tr>
                    <tr>
                        <td>Cost per child</td>
                        <td><input type="number" name="child" onChange={this.handleChange}/></td>
                    </tr>
                    <tr><td><h3>Additional services:</h3></td></tr>
                    <tr>
                        <td>Catering cost</td>
                        <td><input type="number" name="catering" onChange={this.handleChange}/></td>
                    </tr>
                    <tr>
                        <td>Entertainment cost</td>
                        <td><input type="number" name="ent" onChange={this.handleChange}/></td>
                    </tr>
                    <tr>
                        <td>Alcohol cost</td>
                        <td><input type="number" name="alcohol" onChange={this.handleChange}/></td>
                    </tr>

                    <tr>
                        <td><button className='blueButton' onMouseDown={this.addTrip}>Add</button> </td>
                        <td><button className='blueButton'>Cancel</button> </td>
                    </tr>
                    <tr><td style={{color: 'red'}}>{this.state.errorCode}</td></tr>
                    </tbody></table>
                </div>
            </div>
        )
    }
}

export default NewTrip;