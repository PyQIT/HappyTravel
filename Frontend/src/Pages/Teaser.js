import React from "react";
import NewReservation from "./Customer/NewReservation";
import SignUp from "../Authorization/SignUp";

class Teaser extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            colors: ['darkgoldenrod', 'crimson', 'dodgerblue', 'seagreen', 'darkred', 'darkblue', 'lightsalmon'],
            color: ''
        }
        this.pickColor = this.pickColor.bind(this);


    }

    componentDidMount() {
        this.pickColor();
    }

    pickColor(){
        const n =(this.state.colors[Math.floor(Math.random()*this.state.colors.length)]);
        console.log("n = " + n);
        this.setState({
            color: n
        })
    }

    clicked(){
        if(this.props.loggedUser === null)
            this.props.switch(<SignUp switch={this.props.switch}/>)
        else
            this.props.switch(<NewReservation switch={this.props.switch} loggedUser={this.props.loggedUser} trip={this.props.trip}/>)
    }

    render(){
        const divStyle = {
            backgroundColor: this.state.color
        };
        console.log(this.state.color);
        return(
            <div className='teaser' style={divStyle} onClick={()=>this.clicked()}>
                <table style={{width: '100%'}}><tbody>
                    <tr>
                        <td> <h2>{this.props.trip.hotelID.adresID.country}</h2></td>
                        <td>Just {this.props.trip.adultCost} zł!<br/></td>
                    </tr>
                    <tr>
                        <td><i>{this.props.trip.description}</i></td>
                        <td><button className='panelSpecialButton'>Sign up now!</button></td>
                    </tr>

                </tbody></table>
            </div>
        )
    }
}

export default Teaser;