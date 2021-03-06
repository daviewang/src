public class O365WaterandJugProblem {
	public boolean canMeasureWater(int x, int y, int z) {
		//limit brought by the statement that water is finallly in one or both buckets
		if (x + y < z) return false;
		if (x == z || y == z || x + y == z) return true;
		return z % GCD(x, y) == 0;
	}
	public int GCD(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public static void main(String[] args) {
		O365WaterandJugProblem e = new O365WaterandJugProblem();
		e.GCD(12, 8);
	}
}