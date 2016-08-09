import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O249GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();
		if (strings == null || strings.length == 0) {
			return res;
		}
		Map<String, List<String>> map = new HashMap<>();
		
		for (String str : strings) {
			String key = generateKey(str);
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}
		for (String key : map.keySet()) {
			List<String> list = map.get(key);
			Collections.sort(list);
			res.add(list);
		}
		return res;
	}
	
	private String generateKey(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			char a = str.charAt(i);
			char b = str.charAt(i - 1);
			int c = a > b ? a - b : a + 26 - b;
			sb.append(c % 26);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		O249GroupShiftedStrings e = new O249GroupShiftedStrings();
		e.groupStrings(strings);
	}
}