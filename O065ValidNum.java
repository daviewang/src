public class O065ValidNum {
	public boolean isNumber(String s) {
		s = s.trim();
		boolean pointSeen = false;
		boolean eSeen = false;
		boolean numSeen = false;
		boolean numAfterE = true;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('0' <= c && c <= '9') {
				numSeen = true;
				numAfterE = true;
			}
			else if (c == '.') {
				if (eSeen || pointSeen) {
					return false;
				}
				pointSeen = true;
			}
			else if (c == 'e') {
				if (eSeen || !numSeen) {
					return false;
				}
				numAfterE = false;
				eSeen = true;
			}
			else if (c == '-' || c == '+') {
				if (i != 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
			} 
			else {
				return false;
			}
		}
		return numSeen && numAfterE;
	}
	public static void main(String[] args) {
		O065ValidNum e = new O065ValidNum();
		e.isNumber("1 ");
	}
}