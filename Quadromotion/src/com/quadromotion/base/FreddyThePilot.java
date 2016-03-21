package com.quadromotion.base;

/**
 * 
 * @author Gabriel This Class stores the Commands received and converted from
 *         the Leap Motion.
 */
public class FreddyThePilot {

	private boolean takeOff;
	private boolean land;
	private boolean goForward;
	private boolean goBackward;
	private boolean goRight;
	private boolean goLeft;
	private boolean clockWise;
	private boolean counterClockWise;
	private boolean goUp;
	private boolean goDown;
	private boolean emergency;
	private boolean noCommand;

	private double forwardSpeed;
	private double backwardSpeed;
	private double rightSpeed;
	private double leftSpeed;
	private double clockWiseSpeed;
	private double counterClockWiseSpeed;
	private double upSpeed;
	private double downSpeed;

	private float xSpeed;
	private float ySpeed;
	private float zSpeed;
	private float spinSpeed;

	private int gesturesCount;

	private FreddysHand leftHand = null;
	private FreddysHand rightHand = null;

	/** constructor I */
	public FreddyThePilot() {
		// reset Commands
		setGoForward(false);
		this.goForward = false;
		this.goBackward = false;
		this.goRight = false;
		this.goLeft = false;
		this.goDown = false;
		this.goUp = false;
		this.clockWise = false;
		this.counterClockWise = false;
		this.land = false;
		this.takeOff = false;
		this.emergency = false;
		this.noCommand = true;

		this.forwardSpeed = 0;
		this.backwardSpeed = 0;
		this.rightSpeed = 0;
		this.leftSpeed = 0;
		this.clockWiseSpeed = 0;
		this.counterClockWiseSpeed = 0;
		this.upSpeed = 0;
		this.downSpeed = 0;

		this.xSpeed = 0;
		this.ySpeed = 0;
		this.zSpeed = 0;
		this.spinSpeed = 0;

		gesturesCount = 1;

		createHands();
	}

	public FreddysHand getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(FreddysHand leftHand) {
		this.leftHand = leftHand;
	}

	public void setLeftHand(double pitch, double yaw, double roll, double sphereRadius) {
		this.leftHand.setPitch(pitch);
		this.leftHand.setYaw(yaw);
		this.leftHand.setRoll(roll);
		this.leftHand.setSphereRadius(sphereRadius);
	}

	public FreddysHand getRightHand() {
		return rightHand;
	}

	public void setRightHand(FreddysHand rightHand) {
		this.rightHand = rightHand;
	}

	public void setRightHand(double pitch, double yaw, double roll, double sphereRadius) {
		this.rightHand.setPitch(pitch);
		this.rightHand.setYaw(yaw);
		this.rightHand.setRoll(roll);
		this.rightHand.setSphereRadius(sphereRadius);
	}

	public boolean isTakeOff() {
		return takeOff;
	}

	public void setTakeOff(boolean takeOff) {
		this.takeOff = takeOff;
		setNoCommand();
	}

	public boolean isLand() {
		return land;
	}

	public void setLand(boolean land) {
		this.land = land;
		setNoCommand();
	}

	public boolean isGoForward() {
		return goForward;
	}

	public void setGoForward(boolean goForward) {
		this.goForward = goForward;
		setNoCommand();
	}

	public boolean isGoBackward() {
		return goBackward;
	}

	public void setGoBackward(boolean goBackward) {
		this.goBackward = goBackward;
		setNoCommand();
	}

	public boolean isGoRight() {
		return goRight;
	}

	public void setGoRight(boolean goRight) {
		this.goRight = goRight;
		setNoCommand();
	}

	public boolean isGoLeft() {
		return goLeft;
	}

	public void setGoLeft(boolean goLeft) {
		this.goLeft = goLeft;
		setNoCommand();
	}

	public boolean isClockWise() {
		return clockWise;
	}

	public void setClockWise(boolean clockWise) {
		this.clockWise = clockWise;
		setNoCommand();
	}

	public boolean isCounterClockWise() {
		return counterClockWise;
	}

	public void setCounterClockWise(boolean counterClockWise) {
		this.counterClockWise = counterClockWise;
		setNoCommand();
	}

	public boolean isGoUp() {
		return goUp;
	}

	public void setGoUp(boolean goUp) {
		this.goUp = goUp;
		setNoCommand();
	}

	public boolean isGoDown() {
		return goDown;
	}

	public void setGoDown(boolean goDown) {
		this.goDown = goDown;
		setNoCommand();
	}

	public boolean isEmergency() {
		return emergency;
	}

	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
		setNoCommand();
	}

	public boolean isNoCommand() {
		return noCommand;
	}

	public double getForwardSpeed() {
		return forwardSpeed;
	}

	public void setForwardSpeed(double forwardSpeed) {
		this.forwardSpeed = forwardSpeed;
	}

	public double getBackwardSpeed() {
		return backwardSpeed;
	}

	public void setBackwardSpeed(double backwardSpeed) {
		this.backwardSpeed = backwardSpeed;
	}

	public double getRightSpeed() {
		return rightSpeed;
	}

	public void setRightSpeed(double rightSpeed) {
		this.rightSpeed = rightSpeed;
	}

	public double getLeftSpeed() {
		return leftSpeed;
	}

	public void setLeftSpeed(double leftSpeed) {
		this.leftSpeed = leftSpeed;
	}

	public double getClockWiseSpeed() {
		return clockWiseSpeed;
	}

	public void setClockWiseSpeed(double clockWiseSpeed) {
		this.clockWiseSpeed = clockWiseSpeed;
	}

	public double getCounterClockWiseSpeed() {
		return counterClockWiseSpeed;
	}

	public void setCounterClockWiseSpeed(double counterClockWiseSpeed) {
		this.counterClockWiseSpeed = counterClockWiseSpeed;
	}

	public double getUpSpeed() {
		return upSpeed;
	}

	public void setUpSpeed(double upSpeed) {
		this.upSpeed = upSpeed;
	}

	public double getDownSpeed() {
		return downSpeed;
	}

	public void setDownSpeed(double downSpeed) {
		this.downSpeed = downSpeed;
	}
	
	public float getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}

	public float getySpeed() {
		return ySpeed;
	}

	public void setySpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}

	public float getzSpeed() {
		return zSpeed;
	}

	public void setzSpeed(float zSpeed) {
		this.zSpeed = zSpeed;
	}

	public float getSpinSpeed() {
		return spinSpeed;
	}

	public void setSpinSpeed(float spinSpeed) {
		this.spinSpeed = spinSpeed;
	}

	public void setNoCommand() {
		if (takeOff || land || goUp || goDown || goForward || goBackward || goLeft || goRight || clockWise
				|| counterClockWise)
			this.noCommand = false;
		else
			this.noCommand = true;
	}

	private void createHands() {
		this.leftHand = new FreddysHand();
		this.rightHand = new FreddysHand();
	}

	public int getGesturesCount() {

		return gesturesCount;
	}

	public void setGesturesCount(int gesturesCount) {
		this.gesturesCount = gesturesCount;
	}

}
