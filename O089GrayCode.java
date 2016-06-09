import java.util.ArrayList;
import java.util.List;

public class O089GrayCode {
	public List<Integer> grayCode(int n) {
		if (n == 0) {
			List<Integer> res = new ArrayList<>();
			res.add(0);
			return res;
		}
		List<Integer> nextGray = grayCode(n - 1);
		int currSize = nextGray.size();
		for (int i = currSize - 1; i >= 0; i--) {
			int mask = 1 << (n - 1);
			nextGray.add(nextGray.get(i) | mask);
		}
		return nextGray;
	}
	
	public static void main(String[] args) {
		O089GrayCode e = new O089GrayCode();
		List<Integer> res = e.grayCode(3);
		System.out.println(res);
	}
}