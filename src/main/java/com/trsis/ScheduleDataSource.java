package com.trsis;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class ScheduleDataSource {
	
	// да, это синглтон
	private static ScheduleDataSource instance = null;
	
	public static ScheduleDataSource getInstance() {
		
		// да, это непотокобезопасно
		if (instance == null)
		{
			instance = new ScheduleDataSource();
			
			// test - начальное состояние
			Departure dep = new Departure();
			
			dep.setSource("SPB");
			dep.setDestination("MSK");
			dep.setFromTimestamp(LocalDateTime.parse("2024-02-12T00:00:00"));
			dep.setToTimestamp(LocalDateTime.parse("2024-02-12T01:00:00"));
			dep.setDepartureType(DepartureType.Train);
			
			instance.addDeparture(dep);
		}
		
		return instance;
	}

	private ArrayList<Departure> departures = new ArrayList<Departure>();
	
	public ArrayList<Departure> getDepartures(){
		return new ArrayList<Departure>(departures);
	}
	
	public Departure getDeparture(int id) {
		
		Optional<Departure> dep = departures.stream().filter(d -> d.getId() == id).findAny();
		
		return dep.isPresent() ? dep.get() : null;		
	}
	
	public boolean removeDeparture(int id) {
		
		int pos = -1;
		
		for (int i = 0; i <= departures.size(); i ++){
			if (departures.get(i).getId() == id) {
				pos = i;
				break;
			}
		}
		
		if (pos != -1) {
			departures.remove(pos);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addDeparture(Departure dep) {
		
		int newId = 0;
		
		Optional<Integer> maxId = departures.stream().map(d -> d.getId()).max(Integer::compare);
		
		if (maxId.isPresent()) {
			newId = maxId.get() + 1;
		} else {
			newId = 1;
		}
		
		dep.setId(newId);		
		departures.add(dep);
	}
	
	public boolean editDeparture(Departure dep) {
		int id = dep.getId();
		
		if (!this.removeDeparture(dep.getId())) {
			return false;
		}
		
		this.addDeparture(dep);
		dep.setId(id);
		
		return true;
	}
}
