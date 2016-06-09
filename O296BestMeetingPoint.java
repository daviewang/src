import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class O296BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		List<Integer> xList = new ArrayList<>();
		List<Integer> yList = new ArrayList<>();
		
		for (int i = 0; i < grid.length; i++) 
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					xList.add(i);
					yList.add(j);
				}
		}
		Collections.sort(xList);
		Collections.sort(yList);
		return getMedianDistance(xList) + getMedianDistance(yList);
	}
	
	private int getMedianDistance(List<Integer> list) {
		if (list == null || list.size() <= 1) return 0;
		int begin = 0, end = list.size() - 1;
		int res = 0;
		while (begin < end) {
			res += list.get(end--) - list.get(begin++);
		}
		return res;
	}
	
	public static void main(String[] args) {
		O296BestMeetingPoint e = new O296BestMeetingPoint();
		int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(e.minTotalDistance(grid));
	}
}