import java.util.ArrayList;
import java.util.List;

public class O320GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		if (word == null || word.length() == 0) return res;
		dfs(word, res, "", 0, 0);
		return res;
	}
	
	private void dfs(String word, List<String> res, String singleRes, int count, int pos) {
		if (pos == word.length()) {
			if (count != 0) {
				singleRes += count;
			}
			res.add(singleRes);
			return;
		}
		dfs(word, res, singleRes, count + 1, pos + 1); // ignore it
		
		//keep it
		if (count != 0) {
			dfs(word, res, singleRes + count + word.charAt(pos), 0, pos + 1);
		}
		else {
			dfs(word, res, singleRes + word.charAt(pos), 0, pos + 1);
		}
	}
	public static void main(String[] args) {
		O320GeneralizedAbbreviation e = new O320GeneralizedAbbreviation();
		e.generateAbbreviations("word");
	}
}