import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O305NumberIslandsII {
	public List<Integer> numIsland2(int m, int n, int[][] positions){
		List<Integer> res = new ArrayList<>();
		if (m == 0 || n == 0 || positions == null || positions.length == 0 || positions[0].length == 0) return res;
		int[] roots = new int[m * n];
		Arrays.fill(roots, -1);
		int singleRes = 0;
		
		for (int[] position : positions) {
			int pos = position[0] * n + position[1];
			roots[pos] = pos;
			singleRes++;
			int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
			for (int[] dir : dirs) {
				int nextPosX = position[0] + dir[0];
				int nextPosY = position[1] + dir[1];
				int nextPos = nextPosX * n + nextPosY;
				if (nextPosX < 0 || nextPosY < 0 || nextPosX >= m || nextPosY >= n || roots[nextPos] == -1) continue;
				int nextRoot = findRoot(roots, nextPos);
				if (pos != nextRoot) {
					roots[pos] = nextRoot;
					pos = nextRoot;
					singleRes--;
				}
			}
			res.add(singleRes);
		}
		return res;
	}
	private int findRoot(int[] roots, int pos) {
		while (roots[pos] != pos) {
			roots[pos] = roots[roots[pos]];
			pos = roots[pos];
		}
		return pos;
	}
	
	public static void main(String[] args) {
		O305NumberIslandsII e = new O305NumberIslandsII();
		int[][] positions = {{0, 0}, {1, 1}, {0, 1}, {1, 0}};
		e.numIsland2(2, 2, positions);
	}
}