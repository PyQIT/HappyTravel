import React from "react";

class CustomerReservationsList extends React.Component{

    constructor(props){
        super(props);
        this.handleCancelReservation = this.handleCancelReservation.bind(this);
    }

    handleCancelReservation(rid,cid){
        let url = "http://localhost:8080/cancelReservation?"+"reservationID="+rid+"&clientID="+cid;
        console.log(url);
        fetch(url)
            .then(data => {
                this.props.refresh();
                });
    }

    render(){
        const divStyle = {
            border:"solid",
            width:"200px",
            overflow:"auto",
            float:"left",
            margin:"10px 10px 10px 10px"
        };
        return(
            <div className='contentBlock'>
                <table className="niceTable">
                    <tbody>

                        <tr>
                            <td>Country:</td><td>{this.props.crItem.travelID.hotelID.adresID.country}</td>
                        </tr>
                        <tr>
                            <td>City:</td><td>{this.props.crItem.travelID.hotelID.adresID.city}</td>
                        </tr>
                        <tr>
                            <td>Hotel:</td><td>{this.props.crItem.travelID.hotelID.hotelName}, {this.props.crItem.travelID.hotelID.adresID.street} {this.props.crItem.travelID.hotelID.adresID.houseNr}</td>
                        </tr>
                        <tr>
                            <td>Start date:</td><td>{(new Date(this.props.crItem.travelID.startDate)).toLocaleDateString()}</td>
                        </tr>
                        <tr>
                            <td>End date:</td><td>{(new Date(this.props.crItem.travelID.endDate)).toLocaleDateString()}</td>
                        </tr>
                        <tr>
                            <td>Adults:</td><td>{this.props.crItem.adultNumber}</td>
                        </tr>
                        <tr>
                            <td>Children:</td><td>{this.props.crItem.childrenNumber}</td>
                        </tr>
                        <tr>
                            <td>Catering included:</td><td>{(this.props.crItem.cateringType==='NONE')?"No":"Yes"}</td>
                        </tr>
                        <tr>
                            <td>Alcohol included:</td><td>{(this.props.crItem.alcoholType==='NONE')?"No":"Yes"}</td>
                        </tr>
                        <tr>
                            <td>Touring included:</td><td>{(this.props.crItem.entertaimentType==='NONE')?"No":"Yes"}</td>
                        </tr>
                        {(this.props.showHistory === false)?<tr><td></td><td><button className='blueButton' onMouseDown={()=>this.handleCancelReservation(this.props.crItem.id,this.props.loggedUser.id)}>Cancel</button></td></tr>:""}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default CustomerReservationsList;