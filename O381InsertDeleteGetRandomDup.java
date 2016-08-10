import java.util.*;

public class O381InsertDeleteGetRandomDup {
	Map<Integer, Set<Integer>> map;
	List<Integer> nums;
	Random rand;
	
	public O381InsertDeleteGetRandomDup() {
		map = new HashMap<>();
		nums = new ArrayList<>();
		rand = new Random();
	}
	
	public boolean insert(int val) {
		boolean res;
		if (!map.containsKey(val)) {
			res = true;
			map.put(val, new HashSet<>());
		}
		else {
			res = false;
		}
		map.get(val).add(nums.size());
		nums.add(val);
		return res;
	}
	
	public boolean remove(int val) {
		if (!map.containsKey(val)) return false;
		int idx = map.get(val).iterator().next();
		map.get(val).remove(idx);
		if (idx < nums.size() - 1) {
			int lastIdx = nums.get(nums.size() - 1);
			nums.set(idx, lastIdx);
			map.get(lastIdx).remove(nums.size() -1);
			map.get(lastIdx).add(idx);
		}
		nums.remove(nums.size() - 1);
		if (map.get(val).isEmpty()) {
			map.remove(val);
		}
		return true;
	}
	
	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}