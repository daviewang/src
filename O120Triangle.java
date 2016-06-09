import java.util.List;

public class O120Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) return 0;
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		int rowIdx = triangle.size() - 2;
		while (rowIdx >= 0) {
			List<Integer> currRowItem = triangle.get(rowIdx);
			List<Integer> belowRowItem = triangle.get(rowIdx + 1);
			for (int i = 0; i <= rowIdx; i++) {
				currRowItem.set(i, currRowItem.get(i) + 
					Math.min(belowRowItem.get(i), belowRowItem.get(i + 1)));
			}
			rowIdx--;
		}
		return triangle.get(0).get(0);
	}
}