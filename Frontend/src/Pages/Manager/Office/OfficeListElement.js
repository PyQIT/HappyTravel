import React from "react";

class OfficeListElement extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            report: {},
        }
    }

    componentDidMount() {
        fetch("http://localhost:8080/countEmployees?officeID="+this.props.office.id)
            .then(response => response.json())
            .then(data => {
                this.setState({
                    report: data,
                })})
    }

    render(){
        return(
            <div className='contentBlock'>
                <h1>{this.props.office.adresID.city}</h1>
                <h2>{this.props.office.adresID.street} {this.props.office.adresID.houseNr} </h2><hr/>
                Salesmen: {this.state.report.salesmen}<br/>
                Guides: {this.state.report.guides}<br/>
                Managers: {this.state.report.managers}<br/>
            </div>
        )
    }
}

export  default OfficeListElement;