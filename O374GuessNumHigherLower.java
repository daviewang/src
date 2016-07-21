public class O374GuessNumHigherLower extends GuessGame{
	public int guessNumber(int n) {
		int start = 0;
		int end = n;
		int mid = start + (end - start) / 2;
		while (guess(mid) != 0) {
			if (guess(mid) == 1) {
				start = mid + 1;
			}
			else if (guess(mid) == -1) {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}
		return mid;
	}
}