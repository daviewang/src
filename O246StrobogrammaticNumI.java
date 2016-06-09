import java.util.HashMap;
import java.util.Map;

public class  O246StrobogrammaticNumI {
	public boolean isStrobogrammatic(String num) {
		if (num == null || num.length() == 0) return false;
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');
		map.put('1', '1');
		
		int begin = 0;
		int end = num.length() - 1;
		while (begin <= end) {
			if (!map.containsKey(num.charAt(begin))) {
				return false;
			}
			if (map.get(num.charAt(begin)) != num.charAt(end)) {
				return false;
			}
			begin++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		O246StrobogrammaticNumI e = new O246StrobogrammaticNumI();
		System.out.println(e.isStrobogrammatic("801"));
	}
}