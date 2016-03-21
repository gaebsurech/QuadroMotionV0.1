package com.quadromotion.leap;

import com.quadromotion.base.FreddyThePilot;
import com.quadromotion.base.FreddysHand;
import com.quadromotion.convertion.AngleToSpeedConverter;
import com.quadromotion.time.Chrono;

public class Auswertung {

	// Grenzwerte Setzung f�r die h�nden positionen

	private int LimYawPos = 35;
	private int LimYawNeg = -35;
	private int LimPitchPos = 16;
	private int LimPitchNeg = -16;
	private int LimRollPos = 16;
	private int LimRollNeg = -16;
	private int LimSphereRadiusMin = 55;
	private boolean rHandForward, rHandBackward, rHandRight, rHandLeft, lHandForward, lHandBackward, lHandRight, lHandLeft, rHandYaw45,
			lHandYaw45, rightleft45;
	
	private double rHandForwardDouble;
	// restliche gesten erstellen...

	
	private FreddyThePilot pilot = null;
	private AngleToSpeedConverter converter = null;
	private Chrono takeOffChrono = null; 
	private Chrono landingChrono = null;
	
	// private static double Zaehler = 0;
	// private static boolean StartVar = true;

	// Grenzwerten m�ssen noch Gepr�ft und festgelegt werden
	
//	/** constructor I */
//	public Auswertung() {
//		initialize();
//	}

	/** constructor II */
	public Auswertung(FreddyThePilot pilot) {
		this.setPilot(pilot);
		initialize();
	}

	private void initialize() {
		rHandForward = false;
		rHandBackward = false;
		rHandRight = false;
		rHandLeft = false;
		lHandForward = false;
		lHandBackward = false;
		lHandRight = false;
		lHandLeft = false;
		rHandYaw45 = false;
		lHandYaw45 = false;
		rightleft45 = false;
		
		rHandForwardDouble = 0;
	}

	public void RechteAuswertung(FreddysHand rHand) {
		// Pitch Auswertung
		if (rHand.getPitch() < LimPitchNeg) {

			// System.out.println("RechtPitch : " + RechteHand.getRechtPitch() +
			// " LimPitchNeg = " + LimPitchNeg);
			System.out.println("FORWARD !!" + "RechtPitch : " + rHand.getPitch() + " LimPitchNeg = " + LimPitchNeg);
			rHandForward = true;
			rHandForwardDouble = converter.expConverter(rHand.getPitch());
		}

		if (rHand.getPitch() > LimPitchPos) {

			// System.out.println("RechtPitch : " + RechteHand.getRechtPitch() +
			// " LimPitchPos = " + LimPitchPos);
			System.out.println("BACKWARD !!" + "RechtPitch : " + rHand.getPitch() + " LimPitchPos = " + LimPitchPos);
			rHandBackward = true;
		}

		// Roll Auswertung
		if (rHand.getRoll() > LimRollPos) {

			// System.out.println("RechtRoll : " + RechteHand.getRechtRoll() + "
			// LimRollPos = " + LimRollPos);
			System.out.println("GO LEFT !!" + "RechtRoll : " + rHand.getRoll() + " LimRollPos = " + LimRollPos);
			rHandLeft = true;

		}

		if (rHand.getRoll() < LimRollNeg) {

			// System.out.println("RechtRoll : " + RechteHand.getRechtRoll() + "
			// LimRollNeg = " + LimRollNeg);
			System.out.println("GO RIGHT !!" + "RechtRoll : " + rHand.getRoll() + " LimRollNeg = " + LimRollNeg);
			rHandRight = true;

		}

		// Yaw Auswertung
		if (rHand.getYaw() > LimYawPos) {

			// System.out.println("RechtYaw : " + rHand.getYaw() + " LimYawPos =
			// " + LimYawPos);

		}

		if (rHand.getYaw() < LimYawNeg) {

			System.out.println("TAKE OFF !!! " + "RechtYaw : " + rHand.getYaw() + " LimYawNeg = " + LimYawNeg);
			rHandYaw45 = true;
			takeOffChrono = new Chrono();

		}

		// SphereRadius Auswertung
		if (rHand.getSphereRadius() < LimSphereRadiusMin) {

			// System.out.println("RechtSphereRadius : " +
			// rHand.getSphereRadius() + " LimSphereRadiusMin = " +
			// LimSphereRadiusMin);
		}
		storeGestures();
	}

	public void LinkeAuswertung(FreddysHand lHand) {

		// Pitch Auswertung
		if (lHand.getPitch() > LimPitchPos) {

			System.out.println("UP !!! " + "LinkPitch : " + lHand.getPitch() + " LimPitchPos = " + LimPitchPos);
			lHandForward = true;
		}

		if (lHand.getPitch() < LimPitchNeg) {

			// System.out.println("LinkPitch : " + LinkeHand.getLinkPitch() + "
			// LimPitchNeg = " + LimPitchNeg);
			System.out.println("DOWN !!! " + "LinkPitch : " + lHand.getPitch() + " LimPitchNeg = " + LimPitchNeg);
			lHandBackward = true;

		}

		// Roll Auswertung
		if (lHand.getRoll() > LimRollPos) {

			// System.out.println("LinkRoll : " + LinkeHand.getLinkRoll() + "
			// LimRollPos = " + LimRollPos);
			System.out.println("TURN COUNTERCLOCKWISE !!" + "LinkRoll : " + lHand.getRoll() + " LimRollPos = " + LimRollPos);
			lHandLeft = true;

		}

		if (lHand.getRoll() < LimRollNeg) {

			// System.out.println("LinkRoll : " + LinkeHand.getLinkRoll() + "
			// LimRollNeg = " + LimRollNeg);
			System.out.println("TURN CLOCKWISE !!" + "LinkRoll : " + lHand.getRoll() + " LimRollNeg = " + LimRollNeg);
			lHandRight = true;

		}

		// Yaw Auswertung
		if (lHand.getYaw() > LimYawPos) {

			System.out.println("LANDING !!! " + "LinkYaw : " + lHand.getYaw() + " LimYawPos = " + LimYawPos);
			lHandYaw45 = true;
			landingChrono = new Chrono();
		}

		if (lHand.getYaw() < LimYawNeg) {

			System.out.println("LinkYaw : " + lHand.getYaw() + " LimYawNeg = " + LimYawNeg);

		}

		// SphereRadius Auswertung
		if (lHand.getSphereRadius() < LimSphereRadiusMin) {

			// System.out.println("LinkeSphereRadius : " +
			// lHand.getSphereRadius() + " LimSphereRadiusMin = " +
			// LimSphereRadiusMin);

		}
		storeGestures();
	}

	// ********************************** In Bearbeitung !!!!!!!!!!!!!!!!
	// **********************************/

	public void ZweiHaendenAuswertung(FreddysHand rHand, FreddysHand lHand) {

		// If beide Faust
		if ((lHand.getSphereRadius() < LimSphereRadiusMin) && (rHand.getSphereRadius() < LimSphereRadiusMin)) {

			System.out.println("START !!! " + "LinkeRadius : " + lHand.getSphereRadius() + "RechteRadius : "
					+ rHand.getSphereRadius());

		}

		if ((lHand.getYaw() > LimYawPos) && (rHand.getYaw() < LimYawNeg)) {

			System.out.println("LANDUNG !!! " + "LinkeRadius : " + lHand.getSphereRadius() + "RechteRadius : "
					+ rHand.getSphereRadius());

		}
		/*
		 * if((LinkeHand.getLinkSphereRadius() < LimSphereRadiusMin) &&
		 * (RechteHand.getRechtSphereRadius() > LimSphereRadiusMin) ||
		 * (LinkeHand.getLinkSphereRadius() > LimSphereRadiusMin) &&
		 * (RechteHand.getRechtSphereRadius() < LimSphereRadiusMin) ||
		 * (LinkeHand.getLinkSphereRadius() > LimSphereRadiusMin) &&
		 * (RechteHand.getRechtSphereRadius() > LimSphereRadiusMin)){
		 * 
		 * StartVar = !StartVar;
		 * 
		 * }
		 */
		storeGestures();
	}
	
	public void keineHand(){
		storeGestures();
	}

	private void storeGestures() {
		pilot.setGoForward(rHandForward);
		pilot.setGoBackward(rHandBackward);
		pilot.setGoRight(rHandRight);
		pilot.setGoLeft(rHandLeft);

		pilot.setGoUp(lHandForward);
		pilot.setGoDown(lHandBackward);
		pilot.setClockWise(lHandRight);
		pilot.setCounterClockWise(lHandLeft);

		pilot.setTakeOff(rHandYaw45);
		pilot.setLand(lHandYaw45);
		pilot.setEmergency(rightleft45);
		
		pilot.setForwardSpeed(rHandForwardDouble);
	}

	public FreddyThePilot getPilot() {
		return pilot;
	}

	public void setPilot(FreddyThePilot pilot) {
		this.pilot = pilot;
	}

	public Chrono getTakeOffChrono() {
		return takeOffChrono;
	}

	public void setTakeOffChrono(Chrono takeOffChrono) {
		this.takeOffChrono = takeOffChrono;
	}

	public Chrono getLandingChrono() {
		return landingChrono;
	}

	public void setLandingChrono(Chrono landingChrono) {
		this.landingChrono = landingChrono;
	}
	
}
