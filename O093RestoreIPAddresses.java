import java.util.ArrayList;
import java.util.List;

public class O093RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) return res;
		int len = s.length();
		
		for (int i = 0; i < 4 && i < len - 2; i++)
			for (int j = i + 1; j < i + 4 && j < len - 1; j++)
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i);
					String s2 = s.substring(i, j);
					String s3 = s.substring(j, k);
					String s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
		}
		return res;
	}
	private boolean isValid(String s) {
		if (s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1) || Integer.valueOf(s) > 255) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		O093RestoreIPAddresses e = new O093RestoreIPAddresses();
		e.restoreIpAddresses("0000");
	}
}