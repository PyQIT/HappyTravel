import React from "react";
import HotelOption from "./HotelOption";
import CountryOption from "../../../Components/CountryOption";

class NewTrip extends React.Component {
    constructor(props) {
        super(props);
        this.state ={
            newHotel: false,
            hotels: [],
            //Trip Form
            hotel: null,
            //HotelMenu
            h_country:null,
            h_name:null,
            h_city: null,
            h_street:null,
            h_housenr:null,

        };
        this.flipHotelMenu = this.flipHotelMenu.bind(this);
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

    newHotelMenu(){
        return(
            <div>
            <table>
                <tbody>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="h_street"/></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td><CountryOption name="h_country" onChange={this.handleChange}/></td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td><input type="text" name="h_city"/></td>
                </tr>
                <tr>
                    <td>Street:</td>
                    <td><input type="text" name="h_street"/></td>
                </tr>
                <tr>
                    <td>House nr:</td>
                    <td><input type="text" name="h_housenr"/></td>
                </tr>
                <tr>
                    <td><button className='blueButton'>Add</button></td>
                    <td><button className='blueButton'>Cancel</button></td>
                </tr>

                </tbody>
            </table>
                {this.state.h_errcode}
            </div>
        )
    }



    render(){
        const hotelOptions = this.state.hotels.map(hotel => <HotelOption hotel={hotel}/>);
        return(
            <div>
                <p>Add a new Trip</p>
                <div className='contentBlock'>
                    <h2>Location</h2>
                    <table style={{width: '100%'}}><tbody><tr>
                        <td>
                            Hotel:<br/>
                            <select name='hotel'>{hotelOptions}</select>
                        </td>
                        <td>{(this.state.newHotel)?this.newHotelMenu():<button className='blueButton' onMouseDown={()=>this.flipHotelMenu()}>Add hotel</button>}</td>
                    </tr></tbody></table>
                    <h2>Schedule</h2>
                    <table style={{width: '100%'}}><tbody>
                    <tr>
                        <td>Starts:</td>
                        <td><input type="data" name={"starts"}/></td>
                    </tr>
                    <tr>
                        <td>Ends:</td>
                        <td><input type="data" name={"ends"}/></td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td><input maxLength={255} type="textarea" name={"desc"}/><br/><small>{255-this.state.desc.length}</small></td>
                    </tr>
                    </tbody></table>
                </div>
            </div>
        )
    }
}

export default NewTrip;