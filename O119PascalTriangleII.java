import java.util.ArrayList;
import java.util.List;

public class O119PascalTriangleII {
	public List<Integer> getRow(int rowIdx) {
		List<Integer> res = new ArrayList<>();
		res.add(1);
		if (rowIdx == 0) return res;
		res.add(1);
		if (rowIdx == 1) return res;
		int i = 2;
		while(i <= rowIdx) {
			res.add(0, 1);
			for (int j = 1; j < i; j++) {
				res.set(j, res.get(j) + res.get(j + 1));
			}
			i++;
		}
		return res;
	}
}