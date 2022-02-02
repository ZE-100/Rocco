public class ExitMach {

	private Float heatRatio;
	private Float standardPow;

	public ExitMach() {
		this.heatRatio = Constants.heatRatio;
		this.standardPow = Constants.standardPow;
	}

	public double getMach(double Me) {
		return Math.pow((heatRatio + 1) / 2, -standardPow) *
				Math.pow((1 + (heatRatio - 1) / 2 * Math.pow(Me, 2)) / Me, standardPow);
	}
}
