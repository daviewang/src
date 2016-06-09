import java.util.Arrays;

public class O164MaxGap {
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++) {
			min = Math.min(min, num[i]);
			max = Math.max(max, num[i]);
		}
		int capacity = (int)Math.ceil((double)(max - min) / (num.length - 1));
		int[] bucketMin = new int[num.length - 1];
		int[] bucketMax = new int[num.length - 1];
		
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);
		
		for (int i = 0; i < num.length; i++) {
			if (num[i] == min || num[i] == max) {
				continue;
			}
			int bucketId = (num[i] - min) / capacity;
			bucketMin[bucketId] = Math.min(bucketMin[bucketId], num[i]);
			bucketMax[bucketId] = Math.max(bucketMax[bucketId], num[i]);
		}
		
		int pre = min, last = max;
		int res = Integer.MIN_VALUE;
		
		for (int i = 0; i < num.length - 1; i++) {
			if (bucketMin[i] == Integer.MAX_VALUE && 
				bucketMax[i] == Integer.MIN_VALUE) {
					continue;
			}
			res = Math.max(res, bucketMin[i] - pre);
			pre = bucketMax[i];
		}
		res = Math.max(res, last - pre);
		return res;
	}
}