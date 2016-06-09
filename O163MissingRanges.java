import java.util.ArrayList;
import java.util.List;

public class O163MissingRanges {
	public List<String> findMissingRange(int[] a, int lo, int hi) {
		List<String> res = new ArrayList<>();
		int next = lo;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < next) {
				continue;
			}
			if (a[i] == next) {
				next++;
				continue;
			}
			StringBuilder sb = new StringBuilder();
			int end = a[i] - 1;
			if (next != end) {
				sb.append(next + "->" + end);
			}
			else {
				sb.append(next);
			}
			res.add(sb.toString());
			next = a[i] + 1;
		}
		if (next < hi) {
			StringBuilder sb = new StringBuilder();
			sb.append(next + "->" + hi);
			res.add(sb.toString());
		}
		return res;
	}
	
	public static void main(String[] args) {
		O163MissingRanges e = new O163MissingRanges();
		int[] a = {0, 1, 3, 50, 75};
		e.findMissingRange(a, 0, 99);
	}
}