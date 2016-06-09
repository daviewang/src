public class O009PalindromeNum {
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		
		int length = 1;
		while (x / length >= 10) {
			length *= 10;
		}
		
		while (x > 0) {
			int head = x / length;
			int tail = x % 10;
			if (head != tail) return false;
			
			x = (x % length) / 10;
			length /= 100;
		}
		return true;
	}
	
	public static void main(String[] args) {
		O009PalindromeNum e = new O009PalindromeNum();
		e.isPalindrome(1000000001);
	}
}