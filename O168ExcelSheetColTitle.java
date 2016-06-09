public class O168ExcelSheetColTitle {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			char c = (char)((n - 1) % 26 + 'A');
			sb.append(c);
			n = (n - 1) / 26;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		O168ExcelSheetColTitle e = new O168ExcelSheetColTitle();
		e.convertToTitle(2);
	}
}