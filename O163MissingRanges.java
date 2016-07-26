import java.util.ArrayList;
import java.util.List;

public class O163MissingRanges {
	public List<String> findMissingRange(int[] a, int lo, int hi) {
		List<String> res = new ArrayList<>();
		int head = lo;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < head) {
				continue;
			}
			if (a[i] == head) {
				head++;
				continue;
			}
			StringBuilder sb = new StringBuilder();
			int end = a[i] - 1;
			if (end > hi) break;
			if (head != end) {
				sb.append(head + "->" + end);
			}
			else {
				sb.append(head);
			}
			res.add(sb.toString());
			head = a[i] + 1;
		}
		if (head < hi) {
			StringBuilder sb = new StringBuilder();
			sb.append(head + "->" + hi);
			res.add(sb.toString());
		}
		return res;
	}
	
	public static void main(String[] args) {
		O163MissingRanges e = new O163MissingRanges();
		int[] a = {0, 1, 3, 50, 75, 90, 99, 100, 102, 103, 189, 210};
		e.findMissingRange(a, 0, 99);
	}
}