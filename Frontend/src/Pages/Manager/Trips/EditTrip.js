import React from "react";
import GuideListElement from "./GuideListElement";

class EditTrip extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            guidesData: [],
            availableGuides: [],
            assignedGuides:[],
            //form
            assigned: -1,
            available: -1,
            //
            initialAss: [],
            initialAv: [],
            //from props
            lu : this.props.loggedUser,
            trip: this.props.trip,
        };
        this.getGuides = this.getGuides.bind(this);
        this.addGuide = this.addGuide.bind(this);
        this.removeGuide = this.removeGuide.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.delGuides = this.delGuides.bind(this);
        this.insGuides = this.insGuides.bind(this);
    }

    componentDidMount() {
       this.getGuides();
    }

    getGuides(){
        fetch("http://localhost:8080/guides")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    guidesData: data,


                });
                fetch("http://localhost:8080/getGuidesOnTravel?travelID="+this.props.trip.id)
                    .then(response => response.json())
                    .then(data => {
                        this.setState({assignedGuides: data, initialAss: data,});
                        let filteredArray = this.state.guidesData.filter(item => (this.state.assignedGuides.indexOf(item.id) < 0));
                        this.setState({availableGuides: filteredArray, initialAv: filteredArray,});
                    })
            });
    }

    delGuides(element, index, array){
        console.log("STATE: " + this.state.availableGuides);
        const url = "http://localhost:8080/removeGuideFromTravel"
            + "?loggedUser=" + this.state.lu
            + "&guideID=" + element.id
            + "&travelID=" + this.state.trip.id;
            console.log(url);
            fetch(url);
    }

    insGuides(element, index, array){
        const url = "http://localhost:8080/addGuideToTravel"
            + "?loggedUser=" + this.state.lu
            + "&guideID=" + element.id
            + "&travelID=" + this.state.trip.id;
        console.log(url);
        fetch(url);
    }

    saveGuides(){
        console.log("saveGuides()");
        this.state.availableGuides.forEach(this.delGuides);
        this.state.assignedGuides.forEach(this.insGuides);
    }
    handleChange(event) {
        const {name, value} = event.target;
        console.log(name + ": " + value);
        this.setState({
            [name]: value

        })
    }

    clear(){
        this.getGuides();
    }


    removeGuide(id) {
        if(this.state.assigned < 0) return;
        let filteredArray = this.state.assignedGuides.filter(item => item.id != id);
        let delArray = this.state.assignedGuides.filter(item => item.id == id);
        this.setState({assignedGuides: filteredArray});
        let avg = this.state.availableGuides.concat(delArray);
        this.setState({availableGuides: avg, assigned: -1});
    }

    addGuide(id) {
        if (this.state.available < 0) return;
        let filteredArray = this.state.availableGuides.filter(item => item.id != id);
        let delArray = this.state.availableGuides.filter(item => item.id == id);
        this.setState({availableGuides: filteredArray});
        let asg = this.state.assignedGuides.concat(delArray);
        this.setState({assignedGuides: asg, available: -1});
    }

    render(){
        const avGuideList = this.state.availableGuides.map  (guide => <GuideListElement key={guide.id} guide={guide}/>);
        const asGuideList = this.state.assignedGuides.map   (guide => <GuideListElement key={guide.id} guide={guide}/>);
        return(
            <div className='contentBlock'>
                <div>
                    <h2>Trip specificts</h2>
                    <table><tbody>
                        <tr>
                            <td>Hotel:</td>
                            <td>{this.props.trip.hotelID.hotelName}</td>
                        </tr>
                        <tr>
                            <td>Starts:</td>
                            <td>{(new Date(this.props.trip.startDate)).toLocaleDateString()}</td>
                        </tr>
                        <tr>
                            <td>Ends:</td>
                            <td>{(new Date(this.props.trip.endDate)).toLocaleDateString()}</td>
                        </tr>
                    </tbody></table>
                    <h2>Guides</h2>
                    <table><tbody>
                        <tr>
                            <td>
                                Assigned<br/>
                                <select name='assigned' size='10' style={{width:'300px', height: '400px'}} onChange={this.handleChange}>
                                    {asGuideList}
                                </select>
                            </td>
                            <td>
                                <button className='blueButton' onMouseDown={()=>this.addGuide(this.state.available)}>{"<<<"}</button><br/>
                                <button className='blueButton' onMouseDown={()=>this.removeGuide(this.state.assigned)}>{">>>"}</button><br/><hr/>
                                <button className='blueButton' onMouseDown={()=>this.clear()}>Clear</button><hr/>
                                <button className='blueButton' onMouseDown={()=>this.saveGuides()}>Save</button>
                            </td>
                            <td>
                               Available<br/>
                                <select name='available' size='10'  style={{width:'300px', height: '400px'}} onChange={this.handleChange}>
                                    {avGuideList}
                                </select>
                            </td>
                        </tr>
                    </tbody></table>


                </div>
            </div>
        )
    }

}

export default EditTrip;