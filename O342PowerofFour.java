public class O342PowerofFour {
	 public boolean isPowerOfFour(int num) {
			int oneCount = 0;
			int pos = 0;
	        for (int i = 0; i < 32; i++) {
				if (getBit(num, i) == 1) {
					oneCount++;
					pos = i;
				}
			}
			if (oneCount > 1) return false;
			if (pos % 2 == 1) return false;
			return true;
	    }
		
		private int getBit(int num, int i) {
			if ((1 & (num >> 1)) == 1) {
				return 1;
			}
			else {
				return 0;
			}
		}
		public static void main(String[] args) {
			O342PowerofFour e = new O342PowerofFour();
			e.isPowerOfFour(0);
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