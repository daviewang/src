import java.util.*;

public class O380InsertDeleteGetRandom {
	Map<Integer, Integer> map;
	List<Integer> nums;
	Random rand;
	public O380InsertDeleteGetRandom() {
		map = new HashMap<>();
		nums = new ArrayList<>();
		rand = new Random();
	}
	public boolean insert(int val) {
		if (map.containsKey(val)) return false;
		map.put(val, nums.size());
		nums.add(val);
		return true;
	}
	public boolean remove(int val) {
		if (!map.containsKey(val)) return false;
		int idx = map.get(val);
		if (idx < nums.size() - 1) {
			int lastVal = nums.get(nums.size() - 1);
			nums.set(idx, lastVal);
			map.put(lastVal, idx);
		}
		nums.remove(nums.size() - 1);
		map.remove(val);
		return true;
	}
	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}