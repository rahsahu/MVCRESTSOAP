package org.externalservice.bean;

public class Film{
	
	int id;
	String theaterName;	
	String time;
	
	public Film() {
		super();
	}
	public Film(int i, String theaterName,String time) {
		super();
		this.id = i;
		this.theaterName = theaterName;
		this.time=time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}	
	
}