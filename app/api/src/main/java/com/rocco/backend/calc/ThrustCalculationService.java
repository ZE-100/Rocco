package com.rocco.backend.calc;

import lombok.AllArgsConstructor;

/**
 * @author z-100
 * Used to calculate needed data
 */
@AllArgsConstructor
public class ThrustCalculationService {

	private final Double totalPressure;
	private final Double totalTemperature;
	private Double gasConstant;
	private Double heatRatio;
	private Double standardPow;
	private Double exitMach;
	private final Double freeStreamPressure;

	/**
	 * Mass Flow Rate mDot
	 *
	 * @param throatArea Area of the tightest point
	 * @return mDot
	 */
	public Double getMDot(Double throatArea) {
		return (throatArea * totalPressure / Math.sqrt(totalTemperature))
				* (Math.sqrt(heatRatio / gasConstant))
				* (Math.pow((heatRatio + 1) / 2, -standardPow));
	}

	/**
	 * Exit Mach
	 *
	 * @return Ae / A*
	 */
	public Double getExitAreaRatio() {
		return Math.pow((heatRatio + 1) / 2, -standardPow)
				* Math.pow((1 + ((heatRatio - 1) / 2)
				* Math.pow(exitMach, 2)) / exitMach, standardPow);
	}

	/**
	 * Exit temperature
	 *
	 * @return Te / Tt
	 */
	public double getExitTemperatureRatio() {
		return Math.pow(1 + (heatRatio - 1) / 2
				* Math.pow(exitMach, 2), -1);
	}

	/**
	 * Exit Pressure
	 *
	 * @return Pe / Pt
	 */
	public double getExitPressureRatio() {
		return Math.pow(1 + (heatRatio - 1) / 2
				* Math.pow(exitMach, 2), -heatRatio / (heatRatio - 1));
	}

	/**
	 * Exit velocity
	 *
	 * @param exitTemperature Tt * temperatureRatio
	 * @return velocity m/s
	 */
	public double getVelocity(Double exitTemperature) {
		return exitMach * Math.sqrt(heatRatio * gasConstant * exitTemperature);
	}

	/**
	 *
	 * @param mDot Mass Flow Rate
	 * @param velocity m/s
	 * @param exitPressure Pt *
	 * @param exitArea areaRatio * A*
	 * @return Newton
	 */
	public double getThrust(Double mDot, Double velocity, Double exitPressure, Double exitArea) {
		return mDot * velocity + (exitPressure - freeStreamPressure ) * exitArea;
	}

	/**
	 * Change of start & end velocity
	 *
	 * @param velocity m/s
	 * @return m/s
	 */
	public double getChangeOfVelocity(Double velocity) {

		Double initialMass = 50.0; // kg
		Double finalMass = 40.0; // kg

		double changeOfVelocity = velocity * (Math.log(initialMass / finalMass));
		double timeToBurnFuel = 5.0; //s

		return changeOfVelocity;
	}
}
