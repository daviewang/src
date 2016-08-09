import java.util.*;

public class O379DesignPhoneDirectory {
	BitSet bitset;
	int max;
	int smallestFreeIdx;
	
	public O379DesignPhoneDirectory(int maxNumbers) {
		this.max = maxNumbers;
		smallestFreeIdx = 0;
		bitset = new BitSet(maxNumbers);
	}
	
	public int get() {
		if (smallestFreeIdx == max) {
			return -1;
		}
		int res = smallestFreeIdx;
		bitset.set(smallestFreeIdx);
		smallestFreeIdx = bitset.nextClearBit(smallestFreeIdx);
		return res;
	}
	
	public boolean check(int number) {
		return bitset.get(number) == false;
	}
	
	public void release(int number) {
		if (bitset.get(number) == false) {
			return;
		}
		bitset.clear(number);
		if (number < smallestFreeIdx) {
			smallestFreeIdx = number;
		}
	}
}