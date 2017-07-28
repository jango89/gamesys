import React, {Component} from 'react';


class FormDiv extends Component{

	render(){

		return ( 
			<div className="formdiv">
				<label>{this.props.idName}: </label> 
				<input name={this.props.uniqueId} id={this.props.uniqueId} type={this.props.type}></input>
			</div>
		)
	}
}

export default FormDiv;