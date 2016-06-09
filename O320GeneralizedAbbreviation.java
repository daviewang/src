import java.util.ArrayList;
import java.util.List;

public class O320GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		if (word == null || word.length() == 0) {
			return res;
		}
		helper(word, res, "", 0, 0);
		return res;
	}
	
	public void helper(String word, List<String> res, String singleRes, int pos, int count) {
		if (pos == word.length()) {
			if (count != 0) {
				singleRes += count;
			}
			res.add(singleRes);
			return;
		}
		helper(word, res, singleRes, pos + 1, count + 1);
		if (count == 0) {
			helper(word, res, singleRes + word.charAt(pos), pos + 1, 0);
		}
		else {
			helper(word, res, singleRes + count + word.charAt(pos), pos + 1, 0);
		}
	}
	public static void main(String[] args) {
		O320GeneralizedAbbreviation e = new O320GeneralizedAbbreviation();
		e.generateAbbreviations("word");
	}
}