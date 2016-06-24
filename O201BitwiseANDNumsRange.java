public class O201BitwiseANDNumsRange {
	public int rangeBitwiseAnd(int m, int n) {
		int pos = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			pos++;
		}	
		return m << pos;
	}
	
	public static void main(String[] args) {
		O201BitwiseANDNumsRange e = new O201BitwiseANDNumsRange();
		System.out.println(e.rangeBitwiseAnd(5, 7));
	}
}