import java.util.HashMap;
import java.util.Map;

public class O294FlipGameII {
	public boolean canWin(String s) {
		if (s == null || s.length() < 2) return false;
		Map<String, Boolean> map = new HashMap<>();
		return canWin(s, map);
	}
	
	private boolean canWin(String s, Map<String, Boolean> map) {
		if (map.containsKey(s)) return map.get(s);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
				String opponent = s.substring(0, i - 1) + "--" + s.substring(i + 1);
				if (!canWin(opponent, map)) {
					map.put(s, true);
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}
	
	public static void main(String[] args) {
		O294FlipGameII e = new O294FlipGameII();
		System.out.println(e.canWin("--++"));
	}
}