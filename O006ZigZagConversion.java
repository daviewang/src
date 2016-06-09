import java.util.ArrayList;
import java.util.List;

public class O006ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows <= 1) return s;
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < numRows; i++)
			list.add(new StringBuilder());
		for (int i = 0; i < s.length();) {
			int count = 0;
			for (int j = count; j < numRows && i < s.length(); j++, i++) {
				list.get(j).append(s.charAt(i));
			}
			for (int j = numRows - 2; j >= 1 && i < s.length(); j--, i++) {
				list.get(j).append(s.charAt(i));
			}
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder sb : list) {
			res.append(sb.toString());
		}
		return res.toString();
	}
}