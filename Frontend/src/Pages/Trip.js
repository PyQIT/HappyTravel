import React from "react"

function Trip (props) {
    return (
        <div >
            <li className="tripElement">

               <h3 >{props.trip.hotelID.adresID.city}, {props.trip.hotelID.adresID.country}</h3>
               <p>
                   {(new Date(props.trip.startDate)).toLocaleDateString()} - {(new Date(props.trip.endDate)).toLocaleDateString()}<br/><br/>
                   {props.trip.description}<br/>
                   Koszt osoby: {props.trip.adultCost}zł ( {props.trip.childCost}zł dzieci)<br/>
               </p>
            </li>
        </div>
    )

}

export default  Trip