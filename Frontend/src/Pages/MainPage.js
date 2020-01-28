import React from "react";
import TeaserSlide from "./TeaserSlide";

class MainPage extends React.Component{
    render() {
        return(
            <TeaserSlide switch={this.props.switch} loggedUser={this.props.loggedUser}/>
        )
    }
}
export default MainPage