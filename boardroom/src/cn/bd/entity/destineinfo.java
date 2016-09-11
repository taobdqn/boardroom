package cn.bd.entity;

import java.util.Date;


public class destineinfo {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getDestine_name() {
		return destine_name;
	}
	public void setDestine_name(String destine_name) {
		this.destine_name = destine_name;
	}
	
	private String room_name;
	private String destine_name;
	
	
	private String destine_time;
	public String getDestine_time() {
		return destine_time;
	}
	public void setDestine_time(String destine_time) {
		this.destine_time = destine_time;
	}
}
