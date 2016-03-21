package com.quadromotion.leap;

import com.leapmotion.leap.*;
//import com.leapmotion.leap.Bone;
//import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Controller;
//import com.leapmotion.leap.Finger;
//import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.GestureList;
import com.leapmotion.leap.Hand;
//import com.leapmotion.leap.KeyTapGesture;
import com.leapmotion.leap.Listener;
//import com.leapmotion.leap.ScreenTapGesture;
//import com.leapmotion.leap.SwipeGesture;
//import com.leapmotion.leap.Tool;
import com.leapmotion.leap.Vector;
//import com.leapmotion.leap.Gesture.State;
import com.quadromotion.base.FreddyThePilot;
import com.quadromotion.time.Chrono;

public class LeapListener extends Listener {

	private int AnzahlHaenden = 0;
	private double RechtPitch, RechtYaw, RechtRoll, LinkPitch, LinkYaw, LinkRoll = 0;
	private double RechtSphereRadius, LinkSphereRadius = 0;
	//public static boolean isFlying = false;

	private FreddyThePilot pilot = null;
	private Auswertung auswertung = null;
	private Chrono chrono = null;

	/** Constructor I */
	public LeapListener() {
		pilot = new FreddyThePilot();
		// auswertung = new Auswertung(pilot);
	}

	/** Constructor II */
	public LeapListener(FreddyThePilot pilot) {
		this.pilot = pilot;
		// auswertung = new Auswertung(pilot);
	}

	public void onInit(Controller controller) {
		System.out.println("Leap initialized");
	}

	public void onConnect(Controller controller) {
		System.out.println("Connected");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	}

	public void onDisconnect(Controller controller) {
		// Note: not dispatched when running in a debugger.
		System.out.println("Disconnected");
	}

	public void onExit(Controller controller) {
		System.out.println("Exited");
	}

	/**
	 * @param on
	 *            frame
	 */
	public void onFrame(Controller controller) {
		chrono = new Chrono();
		// Hier wird eine Frame erzeugt

		Frame frame = controller.frame();
		auswertung = new Auswertung(pilot);

		System.out.println("Frame id: " + frame.id() + ", timestamp: " + frame.timestamp() + ", hands: "
				+ frame.hands().count() + ", fingers: " + frame.fingers().count() + ", tools: " + frame.tools().count()
				+ ", gestures " + frame.gestures().count());

		// Die h�nden im Feld werden aufgez�hlt

		AnzahlHaenden = frame.hands().count();

		GestureList gestures = frame.gestures();

		if (AnzahlHaenden > 1) {

			// Get hands
			for (Hand hand : frame.hands()) {
				String handType = hand.isLeft() ? "Left hand" : "Right hand";

				// Get the hand's normal vector and direction

				Vector normal = hand.palmNormal();
				Vector direction = hand.direction();

				if (handType == "Right hand") {

					RechtPitch = Math.toDegrees(direction.pitch());
					RechtYaw = Math.toDegrees(direction.yaw());
					RechtRoll = Math.toDegrees(normal.roll());

					// RechtSphereRadius = hand.sphereRadius();

					// Objekt RechteHand wird erzeugt mit den folgenden
					// eigenschaften die Sp�ter
					// f�r die Auswertung wichtig werden

					pilot.setRightHand(RechtPitch, RechtYaw, RechtRoll, RechtSphereRadius);

					auswertung.RechteAuswertung(pilot.getRightHand());

				}
				if (handType == "Left hand") {

					LinkPitch = Math.toDegrees(direction.pitch());
					LinkRoll = Math.toDegrees(normal.roll());
					LinkYaw = Math.toDegrees(direction.yaw());

					// LinkSphereRadius = hand.sphereRadius();

					pilot.setLeftHand(LinkPitch, LinkYaw, LinkRoll, LinkSphereRadius);

					auswertung.LinkeAuswertung(pilot.getLeftHand());

				}

				if (!frame.hands().isEmpty() || !gestures.isEmpty()) {
					System.out.println();
				}
			}

		} else
			auswertung.keineHand();
		auswertung = null;
		chrono.setEndTime(System.nanoTime());
		double timeDiff = (double) ((chrono.getEndTime() - chrono.getStartTime()) * Math.pow(10, -3));
		System.out.println("elapsed time in function onFrame: " + timeDiff);
	}

	public FreddyThePilot getPilot() {
		return pilot;
	}

	public void setPilot(FreddyThePilot pilot) {
		this.pilot = pilot;
	}

	public Auswertung getAuswertung() {
		return auswertung;
	}

}
