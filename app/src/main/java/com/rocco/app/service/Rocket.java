package com.rocco.app.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Rocket {

	private Double dryWeight;
	private Double wetWeight;
	private Double timeToBurnFuel;
	private Double totalPressure;
	private Double totalTemperature;

	private Double gasConstant;
	private Double heatRatio;
	private Double throatDiameter;
	private Double throatArea;
	private Double areaRatio;

	private Double exitDiameter;
	private Double exitArea;
	private Double mDot;
	private Double temperatureRatio;
	private Double exitTemperature;

	private Double pressureRatio;
	private Double exitPressure;
	private Double velocity;
	private Double changeOfVelocity;
	private Double thrust;

	@Override
	public String toString() {
		return String.format("""
							Dry weight kg\t\t\t\t-\t%s kg
							 Wet weight kg\t\t\t\t-\t%s kg
							 Time to burn fuel seconds\t\t\t\t-\t%s s
							 Total pressure Pt\t\t\t\t-\t%s bar
							 Total temperature Tt\t\t\t-\t%s C
							 ------------------
							 Gas constant R\t\t\t\t\t-\t%s
							 Specific Heat Ratio Gamma\t\t-\t%s
							 Throat Diameter D\t\t\t\t-\t%s mm
							 Throat Area A*\t\t\t\t\t-\t%s mm^2
							 Area ratio A*/Ae\t\t\t\t\t-\t%s
							 ------------------
							 Exit Diameter Ad\t\t\t\t-\t%s mm
							 Exit area Ae\t\t\t\t-\t%s mm
							 Mass Flow Rate mDot\t\t\t\t-\t%s
							 Temperature ratio Te/Tt\t-\t%s
							 Exit Temperature C\t\t\t-\t%s C
							 ------------------
							 Pressure ratio pe/pt\t\t\t\t-\t%s
							 Exit Pressure bar\t\t\t\t-\t%s bar
							 Velocity Ve\t\t\t\t-\t%s m/s
							 Change of velocity \t\t\t\t-\t%s m/s
							 Thrust F\t\t\t\t\t\t-\t%s N
							""", dryWeight, wetWeight, timeToBurnFuel, totalPressure, totalTemperature, gasConstant,
									heatRatio, throatDiameter, throatArea, areaRatio, exitDiameter, exitArea,
									mDot, temperatureRatio, exitTemperature, pressureRatio, exitPressure, velocity,
									changeOfVelocity, thrust);
	}
}
