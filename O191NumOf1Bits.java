public class O191NumOf1Bits {
	public int hammingWeight(int num) {
		int pos = 31;
		int res = 0;
		while (pos-- >= 0) {
			if (getBit(num, pos) == 1) {
				res++;
			}
		}
		return res;
	}
	
	private int getBit(int num, int pos) {
		if (((num >> pos) & 1) == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		O191NumOf1Bits e = new O191NumOf1Bits();
		System.out.println(e.hammingWeight(3));
	}
}