import java.util.ArrayList;
import java.util.List;

public class O248StrobogrammaticNumIII {
	public int strobogrammaticInRange(String low, String high) {
		List<String> list = new ArrayList<>();
		for (int i = low.length(); i <= high.length(); i++) {
			list.addAll(helper(i, i));
		}
		int res = 0;
		for (String str : list) {
			if ((str.length() == low.length() && str.compareTo(low) < 0) ||
				 (str.length() == high.length() && str.compareTo(high) > 0)) {
				continue;
			}
			res++;
		}
		return res;
	}
	
	private List<String> helper(int n, int m) {
		if (n == 0) {
			List<String> res = new ArrayList<>();
			res.add("");
			return res;
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
			res.add("1" + str + "1");
			res.add("6" + str + "9");
			res.add("9" + str + "6");
			res.add("8" + str + "8");
		}
		return res;
	}
	
	public static void main(String[] args) {
		O248StrobogrammaticNumIII e = new O248StrobogrammaticNumIII();
		e.strobogrammaticInRange("50", "100");
	}
}