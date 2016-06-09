public class O171ExcelSheetColumnNum {
	public int titleToNumber(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - 1 - i);
		}
		return res;
	}
}