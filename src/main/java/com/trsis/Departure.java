package com.trsis;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Departure {
	private int id;
	private String source;
	private String destination;
	private LocalDateTime fromTimestamp;
	private LocalDateTime toTimestamp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDateTime getFromTimestamp() {
		return fromTimestamp;
	}
	public void setFromTimestamp(LocalDateTime fromTimestamp) {
		this.fromTimestamp = fromTimestamp;
	}
	public LocalDateTime getToTimeStamp() {
		return toTimestamp;
	}
	public void setToTimestamp(LocalDateTime toTimeStamp) {
		this.toTimestamp = toTimeStamp;
	}
	
	public static Departure fromParameterMap(Map<String, String[]> parameterMap)
	{
		Map<String, String> props = new HashMap<String, String>();
		
		parameterMap.forEach((k, v) -> {			
			if (v.length > 0) {
				props.put(k, v[0]);
			}
		});
		
		return fromPropertyMap(props);			
	}
	
	public static Departure fromPropertyMap(Map<String, String> parameterMap)
	{
		Departure dep = new Departure();
		
		if (parameterMap.containsKey("source")) {
			dep.setSource(parameterMap.get("source"));
		}
		
		if (parameterMap.containsKey("destination")) {
			dep.setDestination(parameterMap.get("destination"));
		}
		
		if (parameterMap.containsKey("fromTimestamp")) {
			String timestamp = parameterMap.get("fromTimestamp");
			
			//DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(timestamp);	
			
			dep.setFromTimestamp(dateTime);
		}
		
		if (parameterMap.containsKey("toTimestamp")) {
			String timestamp = parameterMap.get("toTimestamp");
			
			//DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(timestamp);
			
			dep.setToTimestamp(dateTime);
		}
		
		return dep;
	}
	
	
}
