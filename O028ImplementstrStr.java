public class O028ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) return 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() > haystack.length()) {
				return -1;
			}
			int head = i;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(head) != needle.charAt(j)) {
					break;
				}
				else {
					head++;
					if (j == needle.length() - 1) {
						return i;
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		O028ImplementstrStr e = new O028ImplementstrStr();
		e.strStr("", "");
	}
}