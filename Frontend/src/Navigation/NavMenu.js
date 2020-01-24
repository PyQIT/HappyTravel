import React from "react";

import Employees from "../Pages/Manager/Employees";
import Offices from "../Pages/Manager/Offices";
import UserSettings from "../Pages/User/UserSettings";

class NavMenu extends React.Component{

    constructor(props) {
        super(props);

    }



    getMenu(){
        console.log(this.props.type)
        if(this.props.type == null){
            return(
                <div>
                    <button className='panelButton'>Browse</button>
                    <button className='panelButton'>About us</button>
                    <button className='panelButton'>Contact</button>
                </div>
            );
        }
        if(this.props.type == 'Klient'){
            return(
                <div>
                    <button className='panelButton'>Browse</button>
                    <button className='panelButton'>My Trips</button>
                    <button className='panelButton' onMouseDown={()=> this.props.switch(<UserSettings loggedUser={this.props.loggedUser} switch={this.props.switch}/>)}>Account</button>
                    <button className='panelButton'>About us</button>
                    <button className='panelButton'>Contact</button>
                </div>
            );
        }
        if(this.props.type == 'Kierownik'){
            return(
                <div>
                    <button className='panelSpecialButton' onMouseDown={()=> this.props.switch(<Employees loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>Pracownicy</button>
                    <button className='panelSpecialButton' onMouseDown={()=> this.props.switch(<Offices loggedUser={this.props.loggedUser.id} switch={this.props.switch}/>)}>Biura</button><hr/>
                    <button className='panelButton'>Browse</button>
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