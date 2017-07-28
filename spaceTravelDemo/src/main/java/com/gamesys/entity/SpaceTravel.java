package com.gamesys.entity;

public class SpaceTravel {

    private String personalGalaticalNumber;
    private String place;

	public SpaceTravel(String personalGalaticalNumber, String place) {
		this.personalGalaticalNumber = personalGalaticalNumber;
		this.place = place;
	}

	public String getPersonalGalaticalNumber() {
		return personalGalaticalNumber;
	}
	
	public void setPersonalGalaticalNumber(String personalGalaticalNumber) {
		this.personalGalaticalNumber = personalGalaticalNumber;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personalGalaticalNumber == null) ? 0 : personalGalaticalNumber.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpaceTravel other = (SpaceTravel) obj;
		if (personalGalaticalNumber == null) {
			if (other.personalGalaticalNumber != null)
				return false;
		} else if (!personalGalaticalNumber.equals(other.personalGalaticalNumber))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}
	
   
}
