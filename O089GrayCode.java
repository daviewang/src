import java.util.ArrayList;
import java.util.List;

public class O089GrayCode {
	public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
		res.add(0);
		if (n == 0) return res;
		for (int i = 0; i < n; i++)  {
			for (int k = res.size() - 1; k >= 0; k--) {
				res.add(res.get(k) | (1 << i));
			}
		}
		return res;
		/*
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
		*/
	}
	
	public static void main(String[] args) {
		O089GrayCode e = new O089GrayCode();
		List<Integer> res = e.grayCode(3);
		System.out.println(res);
	}
}