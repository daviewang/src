import java.util.*;
public class O406QueueReconstructionHeight {
	public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return people;
		Comparator<int[]> cp = new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return b[0] - a[0];
				}
				else {
					return a[1] - b[1];
				}
			}
		};
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(10, cp);
		
		for (int[] p : people) {
			pq.offer(p);
		}
		
		List<int[]> res = new LinkedList<>();
		while (!pq.isEmpty()) {
			int[] item = pq.poll();
			res.add(item[1], item);
		}
		int[][] ret = new int[people.length][];
		for (int i=0; i<res.size(); i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
	
	public static void main(String[] args) {
		O406QueueReconstructionHeight e = new O406QueueReconstructionHeight();
		int[][] in = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		e.reconstructQueue(in);
	}
}