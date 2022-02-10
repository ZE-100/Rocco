package com.rocco.backend.io;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OutputService {

	private Double totalPressure;
	private Double totalTemperature;
	private Double gasConstant;
	private Double heatRatio;
	private Double throatDiameter;

	private Double throatArea;
	private Double ae;
	private Double ad;
	private Double mDot;
	private Double areaRatio;

	private Double exitTempRatio;
	private Double exitPresRatio;
	private Double exitTemperature;
	private Double exitPressure;
	private Double exitVelocity;

	private Double thrust;
	private Double changeOfVelocity;


	public String prunt() {
		return String.format("""
							Total pressure Pt\t\t\t\t-\t%s bar
							 Total temperature Tt\t\t\t-\t%s
							 Gas constant R\t\t\t\t\t-\t%s
							 Specific Heat Ratio Gamma\t\t-\t%s
							 Throat Diameter D\t\t\t\t-\t%s mm
							 Exit Diameter Ae\t\t\t\t-\t%s mm
							 Throat Area A*\t\t\t\t\t-\t%s mm^2
							 Exit Area Ae\t\t\t\t\t-\t%s mm^2
							 ------------------
							 Mass Flow Rate mDot\t\t\t\t-\t%s
							 Area Ratio Ae/A*\t\t\t\t-\t%s
							 Exit Temp Ratio Te/Tt\t\t\t-\t%s
							 Exit Pressure Ratio pe/pt\t\t-\t%s
							 Exit Temperature C\t\t\t\t-\t%s C
							 Exit Pressure (bar)\t\t\t\t-\t%s bar
							 Exit velocity Ve\t\t\t\t-\t%s m/s
							 Change of velocity \t\t\t\t-\t%s m/s
							 Thrust F\t\t\t\t\t\t-\t%s N
							 """, totalPressure, totalTemperature, gasConstant, heatRatio, throatDiameter, ad,
				throatArea, ae, mDot, areaRatio, exitTempRatio, exitPresRatio, exitTemperature, exitPressure, exitVelocity, changeOfVelocity, thrust);
	}
}
