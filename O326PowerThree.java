public class O326PowerThree {
	public boolean isPowerOfThree(int n) {
		if (n <= 0) return false;
		double a = Math.log(n) / Math.log(3);
		
		if (Math.pow(3, Math.round(a)) == n) 
			return true;
		else 
			return false;
	}
}