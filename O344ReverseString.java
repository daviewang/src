public class O344ReverseString {
	public String reverseString(String s) {
		if (s == null || s.length() == 0) return s;
		char[] sChar = s.toCharArray();
		int begin = 0;
		int end = sChar.length - 1;
		while (begin < end) {
			char temp = sChar[begin];
			sChar[begin] = sChar[end];
			sChar[end] = temp;
			begin++;
			end--;
		}
		return new String(sChar);
	}
	public static void main(String[] args) {
		O344ReverseString e = new O344ReverseString();
		System.out.println(e.reverseString("hello"));
	}
}