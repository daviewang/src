import java.util.*;

public class O347TopKFrequentElements {
	/*
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || k == 0) return res;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
			else {
				map.put(nums[i], 1);
			}
		}
		List<Map.Entry<Integer, Integer>> infoIds = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(infoIds, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		
		Iterator<Map.Entry<Integer, Integer>> it = infoIds.iterator();
		while(it.hasNext() && k-- > 0) {
			res.add(it.next().getKey());
		}
		return res;
	}
	*/
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer>[] bucket = new List[nums.length + 1];
		for (Integer i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}
			else {
				map.put(i, 1);
			}
		}
		
		for (int key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		
		for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
			if (bucket[i] != null) {
				res.addAll(bucket[i]);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O347TopKFrequentElements e = new O347TopKFrequentElements();
		int[] in = {1,1,1,2,2,3};
		e.topKFrequent(in, 2);
	}
}