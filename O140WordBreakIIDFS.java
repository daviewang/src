import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class O140WordBreakIIDFS {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		return helper(s, wordDict, new HashMap<String, List<String>>());
	}
	
	private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> list = helper(s.substring(word.length()), wordDict, map);
				for (String sub : list) {
					res.add(word + (sub.isEmpty() ? "" : " ") + sub);
				}
			}
		}
		map.put(s, res);
		return res;
	}
	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		O140WordBreakIIDFS e = new O140WordBreakIIDFS();
		e.wordBreak(s, wordDict);
	}
}