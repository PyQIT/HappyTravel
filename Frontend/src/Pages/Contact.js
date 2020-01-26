import React from "react";
import OfficeDisplay from "./Contact/OfficeDisplay";

class Contact extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            officeData: [],
        }
    }

    componentDidMount() {
        fetch("http://localhost:8080/offices")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    officeData: data
                })})
    }


    render(){
        const off = this.state.officeData.map(office => <OfficeDisplay key={office.id} office={office} tel={664235879}/>);
        return(
            <div className='textBlock'>
                <p>Our offices</p>
                {off}
            </div>

        )
    }
}

export default Contact