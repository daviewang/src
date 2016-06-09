import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class O187RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() < 10) return res;
		Map<Integer, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		int key = 0;
		for (int i = 0; i < s.length(); i++) {
			key = ((key << 3) | (s.charAt(i) & 0x7)) & 0x3fffffff;
			if (i < 9) continue;
			if (map.containsKey(key)) {
				set.add(map.get(key));
			}
			else {
				String val = s.substring(i - 9, i + 1);
				map.put(key, val);
			}
		}
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			res.add(iterator.next());
		}
		return res;
	}
}