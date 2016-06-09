public class O069Sqrt {
	public int mySqrt(int x) {
		if (x <= 1) return x;
		int begin = 0;
		int end = x;
		int mid = 0;
		
		while (begin <= end) {
			mid = begin + (end - begin) / 2;
			if (mid == x / mid) {
				return mid;
			}
			else if (mid > x / mid) {
				end = mid - 1;
			}
			else {
				begin = mid + 1;
			}
		}
		return end;
	}
	
	public static void main(String[] args) {
		O069Sqrt e = new O069Sqrt();
		e.mySqrt(2);
	}
}