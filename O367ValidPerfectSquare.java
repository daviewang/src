public class O367ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num <= 0) return false;
		if (num == 1) return true;
		int start = 0;
		int end = num;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid < num / mid) {
				start = mid + 1;
			}
			else if (mid > num / mid) {
				end = mid - 1;
			}
			else {
				return mid * mid == num;
			}
		}
		return end * end == num;
	}
}