import React, { Component } from 'react';
import './home.css';
import  jquery from 'jquery';
import FormDiv from './FormDiv.js'

class Home extends Component {

	constructor(props){

		super(props);

		this.state = {message:'', messageclass:''};

		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleSubmit(event){

		let thisPointer = this;

		jquery.ajax({

			type:"post",
			url:'http://localhost:8080/gamesysDemo/fly',

			data: JSON.stringify({
				galacticalId: document.getElementById('galacticalId').value,
				date: document.getElementById('date').value,
				place: document.getElementById('place').value
			}),

			contentType:'application/x-www-form-urlencoded',
			dataType: "json",

			}).done(function(response) {
				
				const messageInString = "Personal Id ("+  response.galacticalId +
				 ") will be travelling to "+ response.place +   " on " + response.dateOfTravel + " in Flight no "
				 + response.flightId + " and Seat No " + response.seatNumber;

				thisPointer.setState({message:messageInString, messageclass:"green"});

			})
			.fail(function(xhr) {

			    thisPointer.setState({message:xhr.responseJSON.errorMessage, messageclass:"red"});
			});
	
		
		event.preventDefault();
	}

	render() {

		return (
			<div className="homecontent">

				<label className={this.state.messageclass}>{this.state.message}</label>

				<form onSubmit = {this.handleSubmit}>

					<FormDiv idName="Galactic Id" uniqueId ="galacticalId" type="text"/>
					
					<FormDiv idName="Date to travel" uniqueId ="date" type="date"/>

					<FormDiv idName="Place to travel" uniqueId ="place" type="text"/>

					<FormDiv idName="submit" uniqueId ="Submit" type="submit"/>
					
				</form>
			</div>
		);
	}
}

export default Home;