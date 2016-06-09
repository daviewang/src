public class O299BullsandCows {
	public String getHint(String s, String g) {
		if (s == null || g == null) {
			return null;
		}
		if (s.length() != g.length()) {
			return null;
		}
		
		int[] digitalCount = new int[10];
		int bulls = 0;
		int cows = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char gChar = g.charAt(i);
			if (sChar == gChar) {
				bulls++;
			}
			else {
				if (digitalCount[sChar - '0'] > 0) {
					cows++;
				}
				if (digitalCount[gChar - '0'] < 0) {
					cows++;
				}
			}
			digitalCount[sChar - '0']--;
			digitalCount[gChar - '0']++;
		}
		StringBuilder sb = new StringBuilder();
		return sb.append(bulls + "A" + cows + "B").toString();
	}
	
	public static void main(String[] args) {
		O299BullsandCows e = new O299BullsandCows();
		e.getHint("1807", "7810");
	}
}