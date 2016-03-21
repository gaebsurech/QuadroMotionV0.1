package com.quadromotion.convertion;

// converts the input angle value to the output speed 
public class AngleToSpeedConverter implements IAngleToSpeedConverter{
	
	private final int maxAngle = 90;
	private final int maxSpeed = 50;
	
	private double inputValue;
	private double outputValue;
	
	public AngleToSpeedConverter(){
		inputValue = 0;
		outputValue = 0;
	}
	
	public AngleToSpeedConverter(int inputValue){
		this.inputValue = inputValue;
	}

	@Override
	public double expConverter(double inputValue) {
		// TODO exponentielle umrechnung
		
		
		outputValue = inputValue;
		return outputValue;
	}

	@Override
	public double linearConverter(double inputValue) {
		// TODO lineare umrechnung
		outputValue = inputValue;
		return outputValue;
	}

	@Override
	public double getInputValue() {
		return inputValue;
	}

	@Override
	public void setInputValue(int inputValue) {
		this.inputValue = inputValue;
	}

	@Override
	public double getOutputValue() {
		// TODO Auto-generated method stub
		return outputValue;
	}

	public int getMaxAngle() {
		return maxAngle;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

}
