import java.util.ArrayList;
import java.util.List;

public class O118PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if (numRows == 0) return res;
		
		List<Integer> singleRes = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			singleRes.add(0, 1);
			for (int j = 1; j < i; j++) {
				singleRes.set(j, singleRes.get(j) + singleRes.get(j + 1));
			}
			res.add(new ArrayList<>(singleRes));
		}
		return res;
	}
}