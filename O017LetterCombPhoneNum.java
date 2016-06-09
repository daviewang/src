import java.util.ArrayList;
import java.util.List;

public class O017LetterCombPhoneNum {
	private final String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", 
			"tuv", "wxyz"};
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) return res;
		dfs(digits, new StringBuilder(), 0, res);
		return res;
	}
	
	private void dfs(String digits, StringBuilder sb, int pos, List<String> res) {
		if (pos == digits.length()) {
			res.add(new String(sb.toString()));
			return;
		}
		int idx = digits.charAt(pos) - '0';
		String str = letters[idx];
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			dfs(digits, sb, pos + 1, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}