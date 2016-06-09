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
			int offset = str.charAt(0) - 'a';
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char c = (char)(str.charAt(i) - offset);
				if (c < 'a') {
					c += 26;
				}
				sb.append(c);
			}
			String key = sb.toString();
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
			else {
				map.get(key).add(str);
			}
		}
		for (String key : map.keySet()) {
			List<String> list = map.get(key);
			Collections.sort(list);
			res.add(list);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		O249GroupShiftedStrings e = new O249GroupShiftedStrings();
		e.groupStrings(strings);
	}
}