import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O288UniqueWordAbbreviation {
	Map<String, List<String>> map;
	public O288UniqueWordAbbreviation(String[] words) {
		map = new HashMap<>();
		for (String word : words) {
			String key = getAbbreviation(word);
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<>();
				map.put(key, list);
			}
			map.get(key).add(word);
		}
	}
	
	public boolean isUnique(String word) {
		String key = getAbbreviation(word);
		if (map.containsKey(key)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private String getAbbreviation(String word) {
		if (word.length() < 3) return word;
		StringBuilder sb = new StringBuilder();
		sb.append(word.charAt(0));
		sb.append(word.length() - 2);
		sb.append(word.charAt(word.length() - 1));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] words = {"deer", "door", "cake", "card" };
		O288UniqueWordAbbreviation e = new O288UniqueWordAbbreviation(words);
		System.out.println(e.isUnique("dear"));
		System.out.println(e.isUnique("cart"));
		System.out.println(e.isUnique("cane"));
		System.out.println(e.isUnique("make"));
	}
}