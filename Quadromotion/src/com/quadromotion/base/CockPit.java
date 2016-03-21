package com.quadromotion.base;

import com.leapmotion.leap.Controller;
import com.quadromotion.leap.LeapListener;

import de.yadrone.base.ARDrone;
import de.yadrone.base.command.CommandManager;

public class CockPit {
	private int delay = 1000;
	private boolean simulation = false;

	// the pilot 
	private FreddyThePilot freddy = null;
	// leap objects
	private LeapListener leapListener = null;
	private Controller controller = null;
	// command sender
	private CommandSender sender = null;

	// the drone
	public ARDrone ardrone = null;

	// drone command manager
	private CommandManager cmd = null;

	// set the speed
	private int speed = 15;

	/** constructor I */
	public CockPit() {
		initialize();
	}

	/** constructor II */
	public CockPit(boolean simulation) {
		this.setSimulation(simulation);
		initialize();
	}

	private void initialize() {

		// create a pilot
		freddy = new FreddyThePilot();
		
		// Create a listener and controller
		leapListener = new LeapListener(freddy);
		controller = new Controller();

		// Have the listener receive events from the controller
		controller.addListener(leapListener);

		try {
			// create a drone
			if (ardrone == null)
				ardrone = new ARDrone();
			System.out.println("Connect drone controller");
			
			// set the speed of the drone
			ardrone.setSpeed(speed);
			
			ardrone.start();
			
			// create the command manager
			if (cmd == null)
				cmd = ardrone.getCommandManager();
			
		} catch (Exception exc) {
			exc.printStackTrace();

			if (ardrone != null)
				ardrone.stop();
			// Remove the sample listener when done
			controller.removeListener(leapListener);
			System.exit(-1);
		}
		sender = new CommandSender(freddy, cmd);
	}

	// runs the Cockpit
	public void runCockPit() {
		while (!sender.isEnd()) {
			sender.sendCommand(ardrone.getSpeed());
		}
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public LeapListener getAuslesen() {
		return leapListener;
	}

	public void setAuslesen(LeapListener auslesen) {
		this.leapListener = auslesen;
	}

	public boolean isSimulation() {
		return simulation;
	}

	public void setSimulation(boolean simulation) {
		this.simulation = simulation;
	}

	public CommandSender getSender() {
		return sender;
	}

	public void setSender(CommandSender sender) {
		this.sender = sender;
	}

}
