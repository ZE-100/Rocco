package com.rocco.backend;

import com.rocco.backend.blueprint.Rocket;
import com.rocco.backend.calc.ThrustCalculationService;
import com.rocco.backend.other.Constants;

public class Launcher {

	private Double totalPressure = 20.0; // Bar
	private Double totalTemperature = 3200.0; // Celsius
	private Double gasConstant = Constants.R;
	private Double heatRatio = Constants.heatRatio;
	private Double standardPow = Constants.standardPow;

	// ? Throat: Mach = 1.0 => speed of sound
	private Double throatDiameter = 50.0; // millimeter
	private final Double exitMach = 1.0;
	private final Double freeStreamPressure = Constants.freeStreamPressure;


	private ThrustCalculationService tcs;


	public void launch() {
		double throatArea = Constants.PI * Constants.PI * (throatDiameter / 2);

		Rocket rocket = new Rocket();
		rocket.setThroatDiameter(50.0);
		rocket.setThroatArea(throatArea);

		tcs = new ThrustCalculationService(
				totalPressure, totalTemperature, gasConstant, heatRatio,
				standardPow, exitMach, freeStreamPressure);

		double mDot = tcs.getMDot(throatArea);

		double areaRatio = tcs.getExitAreaRatio();

		Double exitArea = throatArea * areaRatio;
		Double exitDiameter = Math.sqrt(exitArea) / Constants.PI;

		Double exitTemperatureRatio = tcs.getExitTemperatureRatio();
		double exitTemperature = exitTemperatureRatio * totalTemperature;

		Double exitPressureRatio = tcs.getExitPressureRatio();
		double exitPressure = exitPressureRatio * totalPressure;

		Double velocity = tcs.getVelocity(exitTemperature);

		Double thrust = tcs.getThrust(mDot, velocity, exitPressure, exitArea);

		double changeOfVelocity = tcs.getChangeOfVelocity(velocity);

		System.out.println(rocket.toString());
	}
}
