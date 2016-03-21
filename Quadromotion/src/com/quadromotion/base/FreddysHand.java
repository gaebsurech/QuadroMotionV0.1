package com.quadromotion.base;

public class FreddysHand {

	private double pitch, yaw, roll, sphereRadius;

	public FreddysHand() {
		this.pitch = 0;
		this.yaw = 0;
		this.roll = 0;
		this.sphereRadius = 0;
	}

	public FreddysHand(double pitch, double yaw, double roll, double sphereRadius) {

		// super();
		this.pitch = pitch;
		this.yaw = yaw;
		this.roll = roll;
		this.sphereRadius = sphereRadius;

	}

	public double getPitch() {
		return pitch;
	}

	public void setPitch(double pitch) {
		this.pitch = pitch;
	}

	public double getYaw() {
		return yaw;
	}

	public void setYaw(double yaw) {
		this.yaw = yaw;
	}

	public double getRoll() {
		return roll;
	}

	public void setRoll(double roll) {
		this.roll = roll;
	}

	public double getSphereRadius() {
		return sphereRadius;
	}

	public void setSphereRadius(double sphereRadius) {
		this.sphereRadius = sphereRadius;
	}

}
