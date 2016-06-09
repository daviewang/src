public class O343IntegerBreak {
	public int integerBreak(int n) {
		if (n == 2) return 1;
		if (n == 3) return 2;
		if (n == 4) return 4;
		
		int countTree = 0;
		while (n > 4) {
			countTree++;
			n -= 3;
		}
		return (int)Math.pow(3, countTree) * n;
	}
	public static void main(String[] args) {
		O343IntegerBreak e = new O343IntegerBreak();
		System.out.println(e.integerBreak(8));
	}
}