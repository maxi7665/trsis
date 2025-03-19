package com.trsis;

public enum DepartureType {
	None,
	Train,
	Plane,
	Ship;
	
	public String toString() {
		switch (this) {
		case Plane:
			return "Самолет";
		case Ship:
			return "Корабль";
		case Train:
			return "Поезд";
		default:
			return "";
		
		}
	}
}
