import java.util.*;

public class O373FindKPairsSmallestSums {
	private class Data {
		int i, j;
		int val;
		public Data(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}
	}
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();
		if (nums1 == null || nums1.length == 0 ||
			nums2 == null || nums2.length == 0 || k == 0) {
				return res;
		}
		Comparator<Data> cp = new Comparator<Data>() {
			public int compare(Data a, Data b) {
				return a.val - b.val;
			}
		};
		PriorityQueue<Data> pq = new PriorityQueue<Data>(10, cp);
		
		Data item = new Data(0, 0, nums1[0] + nums2[0]);
		pq.offer(item);
		
		while (!pq.isEmpty() && res.size() < k) {
			Data nextItem = pq.poll();
			res.add(new int[] {nums1[nextItem.i], nums2[nextItem.j]});
			if (nextItem.j < nums2.length - 1) {
				pq.offer(new Data(nextItem.i, nextItem.j + 1, nums1[nextItem.i] + nums2[nextItem.j + 1]));
			}
			if (nextItem.j == 0 && nextItem.i < nums1.length - 1) {
				pq.offer(new Data(nextItem.i + 1, nextItem.j, nums1[nextItem.i + 1] + nums2[nextItem.j]));
			}
		}
		return res;
	}
}
			