public class O088MergeSortedArray {
	public void merge(int[] num1, int m, int[] num2, int n) {
		int idx1 = m - 1;
		int idx2 = n - 1;
		int idxNew = m + n - 1;
		
		while(idx1 >= 0 && idx2 >= 0) {
			if (num1[idx1] <= num2[idx2]) {
				num1[idxNew] = num2[idx2];
				idx2--;
			}
			else {
				num1[idxNew] = num1[idx1];
				idx1--;
			}
			idxNew--;
		}
		while (idx2 >= 0) {
			num1[idxNew--] = num2[idx2--];
		}
	}
}