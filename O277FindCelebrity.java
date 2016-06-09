public abstract class O277FindCelebrity implements HelperIF {
	public int findCelebrity(int n) {
		int celebrity = 0;
		for (int i = 1; i < n; i++) {
			if (knows(celebrity, i)) {
				celebrity = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (celebrity != i && (knows(celebrity, i) || !knows(i, celebrity))) {
				return -1;
			}
		}
		return celebrity;
	}
}