public class O038CountAndSay {
	public String countAndSay(int n) {
		String res = "1";
		for (int i = 2; i <= n; i++) {
			res = say(res);
		}
		return res;
	}
	
	private String say(String num) {
		StringBuilder sb = new StringBuilder();
		char a = num.charAt(0);
		int count = 1;
		for (int i = 1; i < num.length(); i++) {
			if (a == num.charAt(i)) {
				count++;
			}
			else {
				sb.append(count);
				sb.append(a);
				a = num.charAt(i);
				count = 1;
			}
		}
		sb.append(count);
		sb.append(a);
		return sb.toString();
	}
}