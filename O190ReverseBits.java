public class O190ReverseBits {
	public int reverseBits(int num) {
		int head = 31;
		int tail = 0;
		
		while (head >= tail) {
			int bitHeadVal = getBit(num, head);
			int bitTailVal = getBit(num, tail);
			if (bitHeadVal == 1) {
				num = setBit(num, tail);
			}
			else {
				num = clearBit(num, tail);
			}
			if (bitTailVal == 1) {
				num = setBit(num, head);
			}
			else {
				num = clearBit(num, head);
			}
			head--;
			tail++;
		}
		return num;
	}
	
	private int getBit(int num, int a) {
		if (((num >> a) & 1) == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	private int setBit(int num, int a) {
		num |= 1 << a;
		return num;
	}
	
	private int clearBit(int num, int a) {
		int mask = ~(1 << a);
		return num & mask;
	}
	
	public static void main(String[] args) {
		O190ReverseBits e = new O190ReverseBits();
		System.out.println(e.setBit(4, 0));
	}
}