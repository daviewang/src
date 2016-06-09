public class O165CompareVersionNums {
	public int compareVersion(String version1, String version2) {
		if (version1 == null || version2 == null) {
			return 0;
		}
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		int n1 = v1.length;
		int n2 = v2.length;
		int idx = 0;
		
		while (idx < n1 || idx < n2) {
			int a = idx < n1 ? Integer.parseInt(v1[idx]) : 0;
			int b = idx < n2 ? Integer.parseInt(v2[idx]) : 0;
			if (a < b) {
				return -1;
			}
			else if (a > b) {
				return 1;
			}
			idx++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		O165CompareVersionNums e = new O165CompareVersionNums();
		e.compareVersion("01", "1");
	}
}