public class MassFlowRate {

	private Float totalPressure;
	private Float totalTemperature;
	private Float gasConstant;
	private Float heatRatio;
	private Float standardPow;

	public MassFlowRate(Float totalPressure, Float totalTemperature) {
		this.totalPressure = totalPressure; // bar
		this.totalTemperature = totalTemperature; // celsius

		this.gasConstant = Constants.R;
		this.heatRatio = Constants.heatRatio;
		this.standardPow = Constants.standardPow;
	}


	public double getMDot(Float throatArea) {
		try {
			return throatArea * (totalPressure / Math.sqrt(totalTemperature)) * Math.sqrt(heatRatio / gasConstant) * Math.pow((heatRatio + 1) / 2, -standardPow);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
