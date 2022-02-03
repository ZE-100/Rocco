// ? Used three times 	(constant)	=		(heatRatio + 1) / 2 (heatRatio - 1)
// ? Mass Flow Rate 	(mdot)		= 		throatArea * (total pressure / sqrt(total temperature)) * sqrt(heatRatio / gas constant) * pow((heatRatio + 1) / 2, - constant)
// ? Exit mach 			(Ae / A*)	=		pow((heatratio + 1) / 2, -constant) * pow(((1 + (heatRatio - 1) / 2 * pow(Me, 2)) / Me), +constant)
// ? Exit temperature 	(Te / Tt)	=		pow((1 + (heatRatio - 1) / 2 * pow(Me, 2), -1)
// ? Exit pressure 		(pe / pt)	=		pow(1  + (heatRatio - 1) / 2 * pow(Me, 2), -heatRatio / (heatRatio - 1))
// ? Exit velocity 		(Ve)	mps	=		pow(Me, 2) * sqrt(heatRatio * gasConstant * totalTemperature)
// ? Thrust 			(F) 		= 		mdot * Ve + (pe - freeStreamPressure) * Ae

/**
 * @author z-100
 */
public class Main {

	private static Double totalPressure = 20.0; // Bar
	private static Double totalTemperature = 3200.0; // Celsius
	private static Double gasConstant = Constants.R;
	private static Double heatRatio = Constants.heatRatio;
	private static Double standardPow = Constants.standardPow;

	// ? Throat: Mach = 1.0 => speed of sound
	private static Double throatDiameter; // millimeter
	private static Double throatArea; // millimeter^2
	private static final Double Me = 1.0;

	public static void main() {


		throatDiameter = 50.0;
		throatArea = Constants.PI * Constants.PI * (throatDiameter / 2);

		double mDot = getMDot(throatArea);

		double areaRatio = getMach();

		Double exitArea = throatArea * areaRatio;
		Double exitDiameter = Math.sqrt(exitArea) / Constants.PI;

		double exitTemp = getExitTemp();

		double exitPres = getExitPres();

		double exitVelo = getExitVelo();

		double thrust = getThrust(mDot, exitVelo, exitPres, exitArea);

		double changeOfVelocity = tsiolkovsky(exitVelo);

		System.out.println(prunt(exitArea, exitDiameter, mDot, areaRatio, exitTemp, exitPres, exitVelo, changeOfVelocity, thrust));
	}

	public static double getMDot(Double throatArea) {
		return throatArea * (totalPressure / Math.sqrt(totalTemperature)) * Math.sqrt(heatRatio / gasConstant)
				* Math.pow((heatRatio + 1) / 2, -standardPow);
	}

	public static double getMach() {
		return Math.pow((heatRatio + 1) / 2, -standardPow) * Math.pow((1 + (heatRatio - 1) / 2 * Math.pow(Me, 2)) / Me,
				standardPow);
	}

	public static double getExitTemp() {
		return Math.pow(1 + (heatRatio - 1) / 2 * Math.pow(Me, 2), -1);
	}

	public static double getExitPres() {
		return Math.pow(1 + (heatRatio - 1) / 2 * Math.pow(Me, 2), -heatRatio / (heatRatio - 1));
	}

	public static double getExitVelo() {
		return Math.pow(Me, 2) * Math.sqrt(heatRatio * gasConstant * totalTemperature);
	}

	public static double getThrust(Double mDot, Double velo, Double exitPressure, Double Ae) {
		return mDot * velo + (exitPressure - Constants.freeStreamPressure) * Ae;
	}

	public static String prunt(Double ae, Double ad, Double mDot, Double areaRatio, Double exitTemperature,
			Double exitPressure, Double exitVelocity, Double thrust, Double changeOfVelocity) {

		return String.format("""
							 Total pressure Pt\t\t\t\t-\t%s bar
							 Total temperature Tt\t\t\t-\t%s C
							 Gas constant R\t\t\t\t\t-\t%s
							 Specific Heat Ratio Gamma\t\t-\t%s
							 Throat Diameter D\t\t\t\t-\t%s mm
							 Exit Diameter Ae\t\t\t\t-\t%s mm
							 Throat Area A*\t\t\t\t\t-\t%s mm^2
							 Exit Area Ae\t\t\t\t\t-\t%s mm^2
							 ------------------
							 Mass Flow Rate mDot\t\t\t\t-\t%s 
							 Area Ratio Ae/A*\t\t\t\t-\t%s
							 Exit Temperature Te/Tt\t\t\t-\t%s C
							 Exit Pressure pe/pt\t\t\t\t-\t%s bar
							 Exit velocity Ve\t\t\t\t-\t%s m/s
							 Change of velocity \t\t\t\t-\t%s m/s
							 Thrust F\t\t\t\t\t\t-\t%s N
							 """, totalPressure, totalTemperature, gasConstant, heatRatio, throatDiameter, ad,
				throatArea, ae, mDot, areaRatio, exitTemperature, exitPressure, exitVelocity, changeOfVelocity, thrust);
	}

	public static double tsiolkovsky(Double velocity) {

		Double initialMass = 50.0; // kg
		Double finalMass = 40.0; // kg

		double changeOfVelocity = velocity * (Math.log(initialMass / finalMass));
		double timeToBurnFuel = 5.0; //s

		return changeOfVelocity;
	}
}
