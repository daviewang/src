import java.util.HashMap;
import java.util.Map;

public class O149MaxPointsLine {
	class Point {
		int x;
		int y;
		Point() {x = 0; y = 0;}
		Point(int a, int b) {x = a; y = b;}
	}
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) return 0;
		Map<Double, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			int dup = 1;
			int singleRes = 0;
			for (int j = 0; j < points.length; j++) {
				double slope = 0.0;
				if (i == j) continue;
			
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					dup++;
					continue;
				}
				else if (points[i].x == points[j].x && points[i].y != points[j].y) {
					slope = Double.MAX_VALUE;
				}
				else {
					slope = (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
				}
				
				if (map.containsKey(slope)) {
					map.put(slope, map.get(slope) + 1);
				}
				else {
					map.put(slope, 1);
				}
			}
			if (map.size() == 0) {
				singleRes = dup;
			}
			else {
				for (Double d : map.keySet()) {
					singleRes = Math.max(singleRes, map.get(d) + dup);
				}
			}
			res = Math.max(res, singleRes);
		}
		return res;
	}
	public static void main(String[] args) {
		O149MaxPointsLine e = new O149MaxPointsLine();
		Point p1 = e.new Point(0,0);
		Point p2 = e.new Point(1,1);
		Point p3 = e.new Point(1,-1);
		Point[] in = {p1, p2, p3};
		e.maxPoints(in);
	}
}