import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class O218TheSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<>();
		if (buildings == null || buildings.length == 0 || buildings[0].length == 0)
			return res;
			
		List<int[]> walls = new ArrayList<>();
		for (int[] building : buildings) {
			walls.add(new int[]{building[0], -building[2]});
			walls.add(new int[]{building[1], building[2]});
		}
		
		Comparator<int[]> cp = new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				}
				else {
					return a[1] - b[1];
				}
			}
		};
		
		Collections.sort(walls, cp);
		
		Comparator<Integer> pqComp = new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		};
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(11, pqComp);
		pq.offer(0);
		
		int pre = 0;
		
		for (int[] wall : walls) {
			if (wall[1] < 0) {
				pq.offer(-wall[1]);
			}
			else {
				pq.remove(wall[1]);
			}
			
			int curr = pq.peek();
			if (pre != curr) {
				res.add(new int[]{wall[0], curr});
				pre = curr;
			}
		}
		return res;
	}
}