public class O004MedianTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		if ((len1 + len2) % 2 == 1) {
			return findKthSortedArrays(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1);
		}
		else {
			return (findKthSortedArrays(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1) + 
				    findKthSortedArrays(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2)) / 2.0;
		}
	}
	
	private double findKthSortedArrays(int[] nums1, int start1, int end1,
									   int[] nums2, int start2, int end2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;
		if (len1 < len2) {
			return findKthSortedArrays(nums2, start2, end2, nums1, start1, end1, k);
		}
		if (len2 == 0) {
			return nums1[start1 + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		int count2 = Math.min(len2, k / 2);
		int count1 = k - count2;
		if (nums1[start1 + count1 - 1] > nums2[start2 + count2 - 1]) {
			return findKthSortedArrays(nums1, start1, end1, nums2, start2 +  count2, end2, k - count2);
		}
		else if (nums1[start1 + count1 - 1] < nums2[start2 + count2 - 1]) {
			return findKthSortedArrays(nums1, start1 + count1, end1, nums2, start2, end2, k - count1);
		}
		else {
			return nums1[start1 + count1 - 1];
		}
	}
}