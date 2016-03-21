package com.quadromotion.main;

import com.quadromotion.base.CockPit;

class Main {
	private static CockPit cockPit = null;

	public static void main(String[] args) {
		printMessage("press Enter to start the Cockpit...");
		try {

			System.in.read();
			cockPit = new CockPit();
			cockPit.runCockPit();
		} catch (Exception e) {
			printMessage("error...");
		}

		finally {

			printMessage("Ende...");
			System.exit(-1);
		}
	}

	
	private static void printMessage(String input) {
		System.out.println(input);
	}
}
