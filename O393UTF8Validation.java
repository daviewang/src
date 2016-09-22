public class O393UTF8Validation {
	public boolean validUtf8(int[] data) {
		if (data == null || data.length == 0) {
			return true;
		}
		int count = 0;
		int mask = 0b10000000;
		for (int i = 0; i < data.length; i++) {
			if (count > 0) {
				if ((data[i] & mask) == mask) {
					count--;
				}
				else {
					return false;
				}
			}
			else {
				count = getOneBitCountFromHead(data[i]);
				if (count == -1) return false;
			}
		}
		return count == 0;
	}
	
	private int getOneBitCountFromHead(int num) {
		if ((num & 0b11110000) == 0b11110000) return 3;
		if ((num & 0b11100000) == 0b11100000) return 2;
		if ((num & 0b11000000) == 0b11000000) return 1;
		if ((num & 0b10000000) == 0b10000000) return -1;
		return 0;
	}
}