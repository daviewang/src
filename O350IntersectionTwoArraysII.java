import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O350IntersectionTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int num1 : nums1) {
			if (map.containsKey(num1)) {
				map.put(num1, map.get(num1) + 1);
			}
			else {
				map.put(num1, 1);
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int num2 : nums2) {
			if (map.containsKey(num2) && map.get(num2) > 0) {
				list.add(num2);
				map.put(num2, map.get(num2) - 1);
			}
		}
		int len = list.size();
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}