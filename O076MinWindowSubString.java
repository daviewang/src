import java.util.HashMap;
import java.util.Map;

public class O076MinWindowSubString {
	public String minWindow(String S, String T) {
		Map<Character, Integer> hasFound = new HashMap<>();
		Map<Character, Integer> needFound = new HashMap<>();
		
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (needFound.containsKey(c)) {
				needFound.put(c, needFound.get(c) + 1);
			}
			else {
				needFound.put(c, 1);
				hasFound.put(c, 0);
			}
		}
		
		String res = "";
		int point = 0;
		int count = 0;
		int maxStrLength = Integer.MAX_VALUE;
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (needFound.containsKey(c)) {
				hasFound.put(c, hasFound.get(c) + 1);
				if (hasFound.get(c) <= needFound.get(c)) {
					count++;
				}
				if (count == T.length()) {
					while(!needFound.containsKey(S.charAt(point)) || 
							hasFound.get(S.charAt(point)) > needFound.get(S.charAt(point))) {
						if (needFound.containsKey(S.charAt(point))) {
							hasFound.put(S.charAt(point), hasFound.get(S.charAt(point)) - 1);
						}
						point++;
					}
					if (i - point + 1 < maxStrLength) {
						maxStrLength = i - point + 1;
						res = S.substring(point, i + 1);
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		O076MinWindowSubString e = new O076MinWindowSubString();
		e.minWindow("acbbaca", "aba");
	}
}