import React from "react";
import Teaser from "./Teaser";

class TeaserSlide extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            seconds: 0,
            teasers: [],
            loaded: false,
            current: 0,
        }
    }

    tick() {
        this.setState(prevState => ({
            seconds: prevState.seconds + 1
        }));
        if(this.state.seconds % 10 === 9 && this.state.loaded) {
            let nc = this.state.current + 1;
            if (nc >= this.state.teasers.length)
                nc = 0;
            this.setState(prevState => ({
                current: nc,
            }));
        }
    }


    componentDidMount(){
        this.interval = setInterval(() => this.tick(), 1000);
        fetch("http://localhost:8080/futureTravels")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    teasers: data.map(trip => <Teaser key={trip.id} trip={trip} loggedUser={this.props.loggedUser} switch={this.props.switch}/>),
                    loaded: true,
                    current: Math.floor(Math.random()*(data.length-1)),
                })})
    }

    componentWillUnmount() {
        clearInterval(this.interval);
    }



    render (){
        return (
            <div>
                {this.state.teasers[this.state.current]}
            </div>
        )
    }
}



export default TeaserSlide;