import java.util.ArrayList;
import java.util.List;

public class O054SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int left = 0; 
		int right = matrix[0].length - 1;
		int top = 0;
		int buttom = matrix.length - 1;
		while (true) {
			for (int i = left; i <= right; i++) {
				res.add(matrix[top][i]);
			}
			top++;
			if (isEnd(left, right, top, buttom)) break;
			
			for (int i = top; i <= buttom; i++) {
				res.add(matrix[i][right]);
			}
			right--;
			if (isEnd(left, right, top, buttom)) break;
			
			for (int i = right; i >= left; i--) {
				res.add(matrix[buttom][i]);
			}
			buttom--;
			if (isEnd(left, right, top, buttom)) break;
			
			for (int i = buttom; i >= top; i--) {
				res.add(matrix[i][left]);
			}
			left++;
			if (isEnd(left, right, top, buttom)) break;
		}
		return res;
	}
	private boolean isEnd(int left, int right, int top, int buttom) {
		if (left > right || top > buttom) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix ={
				 {2,5},{8,4},{0,-1}
						};
		O054SpiralMatrix e = new O054SpiralMatrix();
		e.spiralOrder(matrix);
	}
}