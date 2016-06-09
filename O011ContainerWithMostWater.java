public class O011ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) return 0;
		int head = 0;
		int tail = height.length - 1;
		int res = 0;
		
		while (head < tail) {
			int currHeight = 0;
			int currWidth = tail - head;
			if (height[head] > height[tail]) {
				currHeight = height[tail];
				tail--;
			}
			else {
				currHeight = height[head];
				head++;
			}
			res = Math.max(res, currHeight * currWidth);
		}
		return res;
	}
	
	public static void main(String[] args) {
		O011ContainerWithMostWater e = new O011ContainerWithMostWater();
		int[] in = {2, 1};
		e.maxArea(in);
	}
}