import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O049GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0) return res;
		Map<String, List<String>> map = new HashMap<>();
		
		for(String str : strs) {
			String key = sortChars(str);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			}
			else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}
		for (List<String> list : map.values()) {
			res.add(list);
		}
		return res;
	}
	
	String sortChars(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public static void main(String[] args) {
		O049GroupAnagrams e = new O049GroupAnagrams();
		System.out.println(e.sortChars("ab"));
	}
}