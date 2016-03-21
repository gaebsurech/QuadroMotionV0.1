package com.quadromotion.testing.leap;

import com.quadromotion.base.FreddyThePilot;

public class LeapSimulator {

	private FreddyThePilot pilot = null;
	private int randomNr = 0;

	/*
	 * cases: 0: Take off 1: up 2: forward 3: backward 4:down 5:right
	 * 6:clockwise 7:counterclockwise 8:left 9:hover 10:landing
	 */

	// do nothing
	private int orderZero[] = {};
	// take off - hover - landing
	private int orderOne[] = { 0, 9, 10 };
	// take off - hover - clockwise - hover - counterclockwise - hover - landing
	private int orderTwo[] = { 0, 9, 6, 9, 7, 9, 10 };

	private int orderNumber = 1;

	public LeapSimulator(FreddyThePilot pilot) {
		super();
		this.pilot = pilot;
	}
	
	public LeapSimulator(FreddyThePilot pilot, int orderNumber) {
		super();
		this.pilot = pilot;
		this.setOrderNumber(orderNumber);
	}

	public void playProgram() {
		
		int order[] = null;
		if (orderNumber == 1)
			order = orderOne;
		else if (orderNumber == 2)
			order = orderTwo;
		else
			order = orderZero;

		int caseOrder = order[randomNr];
		switch (caseOrder) {
		case 0:
			System.out.println("take off");
			pilot.setTakeOff(true);
			break;
		case 1:
			System.out.println("up");
			pilot.setGoUp(true);
			break;
		case 2:
			System.out.println("forward");
			pilot.setGoForward(true);
			break;
		case 3:
			System.out.println("backward");
			pilot.setGoBackward(true);
			break;
		case 4:
			System.out.println("down");
			pilot.setGoDown(true);
			break;
		case 5:
			System.out.println("right");
			pilot.setGoRight(true);
			break;
		case 6:
			System.out.println("clockwise");
			pilot.setClockWise(true);
			break;
		case 7:
			System.out.println("counterclockwise");
			pilot.setCounterClockWise(true);
			break;
		case 8:
			System.out.println("left");
			
			pilot.setGoLeft(true);
			break;
		case 9:
			System.out.println("hover");
			pilot.setGoLeft(false);
			pilot.setGoRight(false);
			pilot.setClockWise(false);
			pilot.setCounterClockWise(false);
			pilot.setGoBackward(false);
			pilot.setGoForward(false);
			pilot.setGoDown(false);
			pilot.setGoUp(false);
			pilot.setLand(false);
			pilot.setTakeOff(false);
			break;
		case 10:
			System.out.println("landing");
			pilot.setLand(true);
			break;
		default:
			break;
		}
		
		randomNr++;
		if (randomNr == order.length)
			randomNr = 0;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public FreddyThePilot getPilot() {
		return pilot;
	}

	public void setPilot(FreddyThePilot pilot) {
		this.pilot = pilot;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}
