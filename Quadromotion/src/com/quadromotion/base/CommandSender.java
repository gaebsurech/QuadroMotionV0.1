package com.quadromotion.base;

import com.quadromotion.time.Chrono;

import de.yadrone.base.command.CommandManager;

public class CommandSender {

	private FreddyThePilot pilot = null;
	private CommandManager cmd = null;
	// private Chrono takeOffChrono = null;

	private boolean isFlying;
	private boolean end;
	private int delay;
	private boolean simulation;

	public CommandSender(FreddyThePilot pilot, CommandManager cmd) {
		this.setFreddy(pilot);
		this.setCmd(cmd);
		this.setSimulation(false);
		this.setDelay(1000);

	}

	public CommandSender(FreddyThePilot pilot, CommandManager cmd, boolean simulation) {
		this.setFreddy(pilot);
		this.setCmd(cmd);
		this.setSimulation(simulation);
		this.setDelay(1000);
	}

	public CommandSender(FreddyThePilot pilot, CommandManager cmd, int delay) {
		this.setFreddy(pilot);
		this.setCmd(cmd);
		this.setSimulation(false);
		this.setDelay(delay);
	}

	public CommandSender(FreddyThePilot pilot, CommandManager cmd, boolean simulation, int delay) {
		this.setFreddy(pilot);
		this.setCmd(cmd);
		this.setSimulation(simulation);
		this.setDelay(delay);
	}

	public void sendCommand(int speed) {

		if (isFlying) {
			if (pilot.isLand()) {
				cmd.landing();
				// takeOffChrono.setEndTime(System.nanoTime());
				isFlying = false;
				if (simulation)
					end = true;
			} else {
				if (pilot.getGesturesCount() == 1) {

					if (pilot.isGoForward())
						cmd.forward(speed);
					else if (pilot.isGoBackward())
						cmd.backward(speed);

					if (pilot.isGoLeft())
						cmd.goLeft(speed);
					else if (pilot.isGoRight())
						cmd.goRight(speed);

					if (pilot.isClockWise())
						cmd.spinRight(speed);
					else if (pilot.isCounterClockWise())
						cmd.spinLeft(speed);

					if (pilot.isGoUp())
						cmd.up(speed);
					else if (pilot.isGoDown())
						cmd.down(speed);
				}

				else
					cmd.move(pilot.getxSpeed(), pilot.getySpeed(), pilot.getzSpeed(), pilot.getSpinSpeed());

				if (pilot.isNoCommand())
					cmd.hover();
			}
		} else {
			if (pilot.isTakeOff()) {
				cmd.takeOff();
				isFlying = true;
			}
		}

	}

	public FreddyThePilot getFreddy() {
		return pilot;
	}

	public void setFreddy(FreddyThePilot pilot) {
		this.pilot = pilot;
	}

	public CommandManager getCmd() {
		return cmd;
	}

	public void setCmd(CommandManager cmd) {
		this.cmd = cmd;
	}

	public boolean isFlying() {
		return isFlying;
	}

	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public boolean isSimulation() {
		return simulation;
	}

	public void setSimulation(boolean simulation) {
		this.simulation = simulation;
	}

}
