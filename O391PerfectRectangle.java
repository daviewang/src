import java.util.*;
public class O391PerfectRectangle {
	private void processSet(Set<String> set, int x, int y) {
		String point = x + " " + y;
		if (set.contains(point)) {
			set.remove(point);
		}
		else {
			set.add(point);
		}
	}
	public boolean isRectangleCover(int[][] rectangles) {
		if (rectangles == null || rectangles.length == 0 || rectangles[0].length ==0) {
			return false;
		}
		Set<String> set = new HashSet<>();
		int totalArea = 0;
		int left = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;
		int bottom = Integer.MAX_VALUE;
		int top = Integer.MIN_VALUE;
		for (int i = 0; i < rectangles.length; i++) {
			left = Math.min(left, rectangles[i][0]);
			bottom = Math.min(bottom, rectangles[i][1]);
			right = Math.max(right, rectangles[i][2]);
			top = Math.max(top, rectangles[i][3]);
			totalArea += (rectangles[i][3]-rectangles[i][1])*(rectangles[i][2]-rectangles[i][0]);
			processSet(set, rectangles[i][0], rectangles[i][3]);
			processSet(set, rectangles[i][0], rectangles[i][1]);
			processSet(set, rectangles[i][2], rectangles[i][3]);
			processSet(set, rectangles[i][2], rectangles[i][1]);
		}
		return set.size() == 4 && (right - left) * (top - bottom) == totalArea &&
		set.contains(left + " " + bottom) && set.contains(left + " " + top)
		&& set.contains(right + " " + bottom) && set.contains(right + " " + top);
	}
	
	public static void main(String[] args) {
		 int[][] in = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
		 O391PerfectRectangle e = new O391PerfectRectangle();
		 e.isRectangleCover(in);
	}
}