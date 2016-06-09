public class O342PowerofFour {
	public boolean isPowerOfFour(int num) {
		return (num > 0) && ((num & (num - 1)) == 0 && (num & 0x55555555) == num);
	}
	/*
	public boolean isPowerOfFour(int num) {
		int onePos = 0;
		int oneCount = 0;
		for (int i = 0; i < 32; i++) {
			if (getBits(num, i) == 1) {
				oneCount++;
				onePos = i;
			}
		}
		if (oneCount != 1) return false;
		else if (onePos % 2 != 0) return false;
		else return true;
	}

	private int getBits(int num, int i) {
		return (num >> i) & 1;
	}
	*/
}