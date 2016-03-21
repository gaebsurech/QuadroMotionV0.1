package com.quadromotion.time;

public class Chrono {
	
	private long startTime = 0;
	private long endTime = 0;
	
	
	public Chrono() {
		super();
		this.startTime = System.nanoTime();
	}
	
	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	

}
