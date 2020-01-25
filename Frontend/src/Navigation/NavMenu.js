import React from "react";

import Employees from "../Pages/Manager/Employees/Employees";
import Offices from "../Pages/Manager/Office/Offices";
import UserSettings from "../Pages/User/UserSettings";
import TripList from "../Pages/Manager/Trips/TripList";
import AvailableTravels from "../Pages/Customer/AviableTravels";

class NavMenu extends React.Component{

    getMenu(){
        console.log(this.props.type);
        if(this.props.type == null){
            return(
                <div>
                    <button className='panelButton'>Browse</button>
                    <button className='panelButton'>About us</button>
                    <button className='panelButton'>Contact</button>
                </div>
            );
        }
        if(this.props.type === 'Klient'){
            return(
                <div>
                    <button className='panelButton' onMouseDown = {() => this.props.switch(<AvailableTravels loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Browse</button>
                    <button className='panelButton'>My Trips</button>
                    <button className='panelButton' onMouseDown={()=> this.props.switch(<UserSettings loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Account</button>
                    <button className='panelButton'>About us</button>
                    <button className='panelButton'>Contact</button>
                </div>
            );
        }
        if(this.props.type === 'Kierownik'){
            return(
                <div>
                    <button className='panelSpecialButton' onMouseDown={()=> this.props.switch(<Employees loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>Employees</button>
                    <button className='panelSpecialButton' onMouseDown={()=> this.props.switch(<Offices loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>Offices</button>
                    <button className='panelSpecialButton' onMouseDown={()=> this.props.switch(<TripList loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>Trips</button><hr/>
                    <button className='panelButton' onMouseDown = {() => this.props.switch(<AvailableTravels loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Browse</button>
                    <button className='panelButton' onMouseDown={()=> this.props.switch(<UserSettings loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Account</button>
                    <button className='panelButton'>About us</button>
                    <button className='panelButton'>Contact</button>
                </div>
            );
        }
        if(this.props.type === 'Sprzedawca'){
            return(
                <div>
                    <button className='panelSpecialButton'>Reserve</button>
                    <button className='panelButton' onMouseDown = {() => this.props.switch(<AvailableTravels loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Browse</button>
                    <button className='panelButton' onMouseDown={()=> this.props.switch(<UserSettings loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Account</button>
                    <button className='panelButton'>About us</button>
                    <button className='panelButton'>Contact</button>
                </div>
            );
        }

    }

    render(){
        return this.getMenu();
    }
}

export default NavMenu;