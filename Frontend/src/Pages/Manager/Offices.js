import React from "react";
import OfficeListElement from "./OfficeListElement";

class Offices extends  React.Component {
    constructor(props) {
        super(props);
        this.state = {
            offData: [],
        }
    }

    componentDidMount() {
       fetch("http://localhost:8080/offices")
           .then(response => response.json())
           .then(data => {
               this.setState({
                   offData: data
               })})
    }



    render(){
        const off = this.state.offData.map(office => <OfficeListElement key={office.id} office={office}/>)

        return(
            <div>
                <p>Offices Report</p>
                {off}
            </div>
        )
    }


}

export default Offices;