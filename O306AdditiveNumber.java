public class O306AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		if (num == null || num.length() == 0) {
			return false;
		}
		for (int i = 0; i < num.length() / 2; i++) 
			for (int j = i + 1; i + j < num.length() - 1; j++) {
				String first = num.substring(0, i + 1);
				String second = num.substring(i + 1, j + 1);
				if (isValid(num, j + 1, first, second)) {
					return true;
				}
		}
		return false;
	}
	
	public boolean isValid(String num, int start, String first, String second) {
		if (start == num.length()) {
			return true;
		}
		
		long f = Long.parseLong(first);
		long s = Long.parseLong(second);
		long t = f + s;
		String strSum = Long.toString(t);
		
		if (!Long.toString(f).equals(first) || !Long.toString(s).equals(second)) {
			return false;
		}
		if (start + strSum.length()> num.length()) {
			return false;
		}
		
		String third = num.substring(start, start + strSum.length());
		if (!third.equals(strSum) || Long.parseLong(third) != t) {
			return false;
		}
		return isValid(num, start + third.length(), second, third);
	}
	
	public static void main(String[] args) {
		O306AdditiveNumber e = new O306AdditiveNumber();
		System.out.println(e.isAdditiveNumber("112359"));
	}
}