public class Main {

	public static void main(String[] args) {


		// ? Used three times 	(constant)	=		(heatRatio + 1) / 2 (heatRatio - 1)
		// ? Mass Flow Rate 	(mdot)		= 		throatArea * (total pressure / sqrt(total temperature)) * sqrt(heatRatio / gas constant) * pow((heatRatio + 1) / 2, - constant)
		// ? Exit mach 			(Ae / A*)	=		pow((heatratio + 1) / 2, -constant) * pow(((1 + (heatRatio - 1) / 2 * pow(Me, 2)) / Me), +constant)
		// ? Exit temperature 	(Te)		=
		// ? Exit pressure 		(pe)		=
		// ? Exit velocity 		(Ve)		=
		// ? Thrust 			(F) 		= 		mdot * Ve + (pe - ) * A

		// ? Throat: Mach = 1.0, aka speed of sound
		Float throatDiameter = 50.0F; // milimeter
		Float areaOfThroat = Constants.PI * Constants.PI * (throatDiameter / 2); //mm^2

		MassFlowRate mfr = new MassFlowRate(20F, 3200F);
		double mDot = mfr.getMDot(areaOfThroat);

		ExitMach em = new ExitMach();
		double areaRatio = em.getMach(mDot);

		System.out.println(areaRatio);
	}

	// Exit Mach Number
	static double getAreaRatio() {
		return 0;
	}

	void tsiolovsky() {

		Float initialMass = 50F; // kg
		Float finalMass = 40F; // kg
		Float velocity = 20F; // m/s
		Float exhaustThroat = 50F; // mm

		double changeOfVelocity = velocity * (Math.log(initialMass / finalMass));
		double timeToBurnFuel = 5.0; //s
	}
}
