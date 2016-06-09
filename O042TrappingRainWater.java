public class O042TrappingRainWater {
	public int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int left = 0, right = height.length - 1, secHeight = 0;
		int res = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				secHeight = Math.max(secHeight, height[left]);
				res += secHeight - height[left];
				left++;
			}
			else {
				secHeight = Math.max(secHeight, height[right]);
				res += secHeight - height[right];
				right--;
			}
		}
		return res;
	}
}