import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O030SubstringConcatenationAllWords {
	public List<Integer> findSubString(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return res;
		}
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				map.put(words[i], map.get(words[i]) + 1);
			}
			else {
				map.put(words[i], 1);
			}
		}
		
		int len = words[0].length();
		
		for (int j = 0; j < len; j++) {
			Map<String, Integer> currMap = new HashMap<>();
			int singleRes = j;
			int count = 0;
			for (int i = j; i <= s.length() - len; i+= len) {
				String sub = s.substring(i, i + len);
				if (map.containsKey(sub)) {
					if (currMap.containsKey(sub)) {
						currMap.put(sub, currMap.get(sub) + 1);
					}
					else {
						currMap.put(sub, 1);
					}
					count++;
					while(currMap.get(sub) > map.get(sub)) {
						String leftRemove = s.substring(singleRes, singleRes + len);
						currMap.put(leftRemove, currMap.get(leftRemove) - 1);
						count--;
						singleRes += len;
					}
					if (count == words.length) {
						res.add(singleRes);
						String leftRemove = s.substring(singleRes, singleRes + len);
						currMap.put(leftRemove, currMap.get(leftRemove) - 1);
						count--;
						singleRes += len;
					}
				}
				else {
					currMap.clear();
					singleRes = i + len;
					count = 0;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O030SubstringConcatenationAllWords e = new O030SubstringConcatenationAllWords();
		String[] words = {"aaa", "aaa"};
		e.findSubString("aaaaaa", words);
	}
}