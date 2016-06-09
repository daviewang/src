import java.util.HashMap;
import java.util.Map;

public class O166FractionRecurringDecimal {
	public String factionToDecimal(int numerator, int denominator) {
		if (denominator == 0) return "";
		if (numerator == 0) return "0";
		StringBuilder res = new StringBuilder();
		if (numerator > 0 ^ denominator > 0) {
			res.append("-");
		}
		
		long num = (long)numerator;
		num = Math.abs(num);
		long den = (long)denominator;
		den = Math.abs(den);
		
		res.append(num / den);
		
		long rem = (num % den) * 10;
		if (rem == 0) {
			return res.toString();
		}
		res.append(".");
		Map<Long, Integer> map = new HashMap<>();
		while (rem != 0) {
			if (map.containsKey(rem)) {
				int pos = map.get(rem);
				String part1 = res.substring(0, pos);
				String part2 = res.substring(pos);
				return part1 + "(" + part2 + ")";
			}
			map.put(rem, res.length());
			res.append(rem / den);
			rem = (rem % den) * 10;
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		O166FractionRecurringDecimal e = new O166FractionRecurringDecimal();
		e.factionToDecimal(-1, -2147483648);
	}
}