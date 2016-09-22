import java.util.*;
public class O398RandomPickIndex {
	Map<Integer, List<Integer>> map;
	Random random;
	
	public O398RandomPickIndex(int[] nums) {
		map = new HashMap<>();
		random = new Random();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				List<Integer> list = new ArrayList<>();
				map.put(nums[i], list);
			}
			map.get(nums[i]).add(i);
		}
	}
	
	public int pick(int target) {
		List<Integer> list = map.get(target);
		if (list.size() <= 1) {
			return list.get(0);
		}
		return list.get(random.nextInt(list.size()));
	}
}