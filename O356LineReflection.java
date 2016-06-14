import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class O356LineReflection {
	public boolean isReflected(int[][] points) {
		if (points == null || points.length == 0 || points[0].length == 0)
			return false;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<>();
		for(int[] point : points) {
			max = Math.max(max, point[0]);
			min = Math.min(min, point[0]);
			set.add(Arrays.hashCode(point));
		}
		
		int lenOfX = max + min;
		for (int[] point : points) {
			if (!set.contains(Arrays.hashCode(new int[]{lenOfX - point[0], point[1]}))) {
				return false;
			}
		}
		return true;
	}
}