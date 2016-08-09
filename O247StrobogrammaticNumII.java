import java.util.ArrayList;
import java.util.List;

public class O247StrobogrammaticNumII {
	public List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}
	
	public List<String> helper(int n, int m) {
		if (n == 0) {
			List<String> res = new ArrayList<>();
			res.add("");
			return new ArrayList<>(res);
		}
		if (n == 1) {
			List<String> res = new ArrayList<>();
			res.add("0");
			res.add("1");
			res.add("8");
			return res;
		}
		List<String> list = helper(n - 2, m);
		List<String> res = new ArrayList<>();
		for (String str : list) {
			if (n != m) {
				res.add("0" + str + "0");
			}
			res.add("8" + str + "8");
			res.add("9" + str + "6");
			res.add("6" + str + "9");
			res.add("1" + str + "1");
		}
		return res;
	}
	
	public static void main(String[] args) {
		O247StrobogrammaticNumII e = new O247StrobogrammaticNumII();
		List<String> list = e.findStrobogrammatic(2);
		for (String str : list) {
			System.out.println(str);
		}
	}
} 