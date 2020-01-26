import React from "react";

import Employees from "../Pages/Manager/Employees/Employees";
import Offices from "../Pages/Manager/Office/Offices";
import UserSettings from "../Pages/User/UserSettings";
import TripList from "../Pages/Manager/Trips/TripList";
import AvailableTravels from "../Pages/Customer/AviableTravels";
import About from "../Pages/About";
import GuideTrips from "../Pages/Guide/GuideTrips";

class NavMenu extends React.Component{

    getMenu(){
        let browse = (
            <button className='panelButton' onMouseDown = {() => this.props.switch(<AvailableTravels loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>Browse</button>
        );
        let userMenu;
        if(this.props.type === 'Klient'){
            userMenu = (
                <div>
                    <button className='panelButton'>My Trips</button>
                    <button className='panelButton' onMouseDown={()=> this.props.switch(<UserSettings loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Account</button>
                </div>
            );
        }
        if(this.props.type === 'Kierownik'){
            userMenu = (
                <div>
                    <button className='panelSpecialButton' onMouseDown={()=> this.props.switch(<Employees loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>Employees</button>
                    <button className='panelSpecialButton' onMouseDown={()=> this.props.switch(<Offices loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>Offices</button>
                    <button className='panelSpecialButton' onMouseDown={()=> this.props.switch(<TripList loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>Trips</button>
                    <button className='panelButton' onMouseDown={()=> this.props.switch(<UserSettings loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Account</button>
                </div>
            );
        }
        if(this.props.type === 'Sprzedawca'){
            userMenu = (
                <div>
                    <button className='panelButton' onMouseDown={()=> this.props.switch(<UserSettings loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Account</button>
                </div>
            );
        }
        if(this.props.type === 'Przewodnik'){
            userMenu = (
                <div>
                    <button className='panelSpecialButton' onMouseDown={()=> this.props.switch(<GuideTrips loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>My Trips</button>
                </div>
            );
        }
        const genericMenu = (
            <div>
                <button className='panelButton' onMouseDown={()=> this.props.switch(<About/>)}>About us</button>
                <button className='panelButton'>Contact</button>
            </div>
        );
        return(
            <div>
                {browse}
                {userMenu}
                {genericMenu}
            </div>
        )

    }

    render(){
        return this.getMenu();
    }
}

export default NavMenu;