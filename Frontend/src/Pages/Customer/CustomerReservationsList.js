import React from "react";

class CustomerReservationsList extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            ratingValue: "BAD"
        };
        this.handleCancelReservation = this.handleCancelReservation.bind(this);
        this.handleRatingChange = this.handleRatingChange.bind(this);
        this.handleSendRating = this.handleSendRating.bind(this);
    }

    handleCancelReservation(rid,cid){
        let url = "http://localhost:8080/cancelReservation?"+"reservationID="+rid+"&clientID="+cid;
        console.log(url);
        fetch(url)
            .then(data => {
                this.props.refresh();
                });
    }

    handleRatingChange(event){
        this.setState({
            ratingValue:event.target.value
        });
    }

    handleSendRating(rid,cid){
        console.log(this.state.ratingValue);
        let url = "http://localhost:8080/rateTravel?"+"ratingType="+this.state.ratingValue+"&reservationID="+rid+"&loggedUser="+cid;
        console.log(url);
        fetch(url).then(response => response.json());
        this.props.refresh();
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
                        {(this.props.showHistory === false)?<tr><td></td><td><button onMouseDown={()=>this.handleCancelReservation(this.props.crItem.id,this.props.loggedUser.id)}>Cancel</button></td></tr>
                            :((this.props.crItem.ratingType === "NONE")?<tr><td><select value={this.state.ratingValue} onChange={this.handleRatingChange}><option value="BAD">Bad</option><option value="AVERAGE">Average</option><option value="OK">Ok</option><option value="GOOD">Good</option><option value="BEST">Best</option></select></td><td><button onMouseDown={()=>this.handleSendRating(this.props.crItem.id,this.props.loggedUser.id)}>Rate!</button></td></tr>
                                :<tr><td>Rated:</td><td>{this.props.crItem.ratingType}</td></tr>)}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default CustomerReservationsList;