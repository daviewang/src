import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O241DifferentWaysAddParentheses {
	Map<String, List<Integer>> map = new HashMap<>();
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				String sub1 = input.substring(0, i);
				String sub2 = input.substring(i + 1);
				List<Integer> l1 = map.getOrDefault(sub1, diffWaysToCompute(sub1));
				List<Integer> l2 = map.getOrDefault(sub2, diffWaysToCompute(sub2));
				for (Integer i1 : l1) {
					for (Integer i2 : l2) {
						if (c == '+') {
							res.add(i1 + i2);
						}
						else if (c == '-') {
							res.add(i1 - i2);
						}
						else if (c == '*') {
							res.add(i1 * i2);
						}
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.valueOf(input));
		}
		map.put(input, res);
		return res;
	}
}