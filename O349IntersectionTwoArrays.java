import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class O349IntersectionTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : nums1) {
			set.add(i);
		}
		
		Set<Integer> res = new HashSet<>();
		for (Integer i : nums2) {
			if (set.contains(i)) {
				res.add(i);
			}
		}
		
		int[] intArrays = new int[res.size()];
		Iterator<Integer> it = res.iterator();
		int idx = 0;
		while (it.hasNext()) {
			intArrays[idx++] = it.next();
		}
		
		return intArrays;
	}
}