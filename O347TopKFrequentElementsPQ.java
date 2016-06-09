import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class O347TopKFrequentElementsPQ {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
		}
		
		Comparator<Map.Entry<Integer, Integer>> cp = new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		};
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(cp);
		pq.addAll(map.entrySet());
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(pq.poll().getKey());
		}
		return res;
	}
}