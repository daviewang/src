import java.util.Arrays;

public class O274HIndex {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		
		Arrays.sort(citations);
		
		int len = citations.length;
		
		for (int i = 0; i < len; i++) {
			if (citations[i] >= len - i) {
				return len - i;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		O274HIndex e = new O274HIndex();
		int[] in = {3, 0, 6, 1, 5};
		System.out.println(e.hIndex(in));
	}
}