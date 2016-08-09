import java.util.*;

public class O378KthSmallestElementMatrix {
	private class DataElement {
		int row, col, val;
		public DataElement(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
			return 0;
		Comparator<DataElement> cp = new Comparator<DataElement>() {
			public int compare(DataElement a, DataElement b) {
				return a.val - b.val;
			}
		};
		PriorityQueue<DataElement> pq = new PriorityQueue<>(matrix.length, cp);
		pq.offer(new DataElement(0, 0, matrix[0][0]));
		while (!pq.isEmpty() && k-- > 0) {
			DataElement nextElement = pq.poll();
			if (nextElement.col < matrix[0].length - 1) {
				pq.offer(new DataElement(nextElement.row, nextElement.col + 1, 
					matrix[nextElement.row][nextElement.col + 1]));
			}
			if (nextElement.col == 0 && nextElement.row < matrix.length - 1) {
				pq.offer(new DataElement(nextElement.row + 1, nextElement.col,
					matrix[nextElement.row + 1][nextElement.col]));
			}
			if (k == 0) return nextElement.val;
		}
		return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}