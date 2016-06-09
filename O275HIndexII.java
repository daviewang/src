public class O275HIndexII {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		int len = citations.length;
		int start = 0;
		int end = len - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (citations[mid] == len - mid) {
				return citations[mid];
			}
			else if (citations[mid] > len - mid){
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return len - (end + 1);
	}
}