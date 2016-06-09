import java.util.Arrays;

public class O135Candy {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int len = ratings.length;
		int candy[] = new int[len];
		
		Arrays.fill(candy, 1);
		
		for (int i = 1; i < len; i++) {
			if (ratings[i - 1] < ratings[i]) {
				candy[i] = candy[i - 1] + 1;
			}
		}
		
		for (int i = len - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i] && candy[i - 1] <= candy[i]) {
				candy[i - 1] = candy[i] + 1;
			}
		}
		
		int res = 0;
		for (int i = 0; i < candy.length; i++) {
			res += candy[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		O135Candy e = new O135Candy();
		int[] in = {2, 2};
		e.candy(in);
	}
}