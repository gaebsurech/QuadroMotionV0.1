package com.quadromotion.testing.main;

import com.quadromotion.base.CockPit;
import com.quadromotion.testing.leap.LeapSimulator;

public class MainSimulator {

	private static CockPit cockPit = null;
	private static LeapSimulator leap = null;
	private static int delay = 3000;
	private static int speed = 10;
	private static boolean simulation = true;
	private static final int ORDER_NUMBER = 1;

	public static void main(String[] args) {

		try {
			System.out.println("press Enter to start the simulation...");
			System.in.read();
			
			cockPit = new CockPit(simulation);
			leap = new LeapSimulator(cockPit.getAuslesen().getPilot(), ORDER_NUMBER);
			cockPit.getSender().setDelay(delay);
			cockPit.getSender().setSimulation(simulation);
			
			runSimulation();

		} catch (Exception e) {
			System.out.println("error: " + e);
		}

		finally {

			System.out.println("Ende...");
			System.exit(-1);
		}
	}
	
	private static void runSimulation(){
		while (!cockPit.getSender().isEnd()) {
			System.out.println("in simulation");
			leap.playProgram();
			cockPit.getSender().sendCommand(speed);
		}
	}

}
