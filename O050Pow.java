public class O050Pow {
		public double myPow(double x, int n) {
			if (n < 0) {
				return 1.0 / helper(x, -n);
			}
			else {
				return helper(x, n);
			}
		}
		private double helper(double x, int n) {
			if (n == 0) return 1.0;
			
			if (n % 2 == 0) {
				double v = helper(x, n / 2);
				return v * v;
			}
			else {
				double v = helper(x, n / 2);
				return x * v * v;
			}
		}

	public static void main(String[] args) {
		O050Pow e = new O050Pow();
		System.out.println(e.myPow(1.0, Integer.MIN_VALUE));
	}
}