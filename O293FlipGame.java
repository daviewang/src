import java.util.ArrayList;
import java.util.List;

public class O293FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
				res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O293FlipGame e = new O293FlipGame();
		e.generatePossibleNextMoves("++++");
	}
}