import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O244ShortestWordDistanceII {
	private Map<String, List<Integer>> map = new HashMap<>();
	
	public O244ShortestWordDistanceII(String[] words) {
		for (int i = 0; i < words.length; i++) {
			String key = words[i];
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			List<Integer> l = map.get(key);
			l.add(i);
			map.put(key, l);
		}
	}
	
	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		int res = Integer.MAX_VALUE;
		for (Integer i1 : list1) 
			for (Integer i2 : list2) {
			res = Math.min(res, Math.abs(i1 - i2));
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		O244ShortestWordDistanceII e = new O244ShortestWordDistanceII(words);
		System.out.println(e.shortest("makes", "coding"));
	}
}