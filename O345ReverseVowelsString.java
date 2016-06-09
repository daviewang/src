import java.util.HashSet;
import java.util.Set;

public class O345ReverseVowelsString {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) return s;
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		char[] sChar = s.toCharArray();
		int begin = 0;
		int end = sChar.length - 1;
		while(begin < end) {
			if (!set.contains(sChar[begin])) {
				begin++;
				continue;
			}
			if (!set.contains(sChar[end])) {
				end--;
				continue;
			}
			char temp = sChar[begin];
			sChar[begin] = sChar[end];
			sChar[end] = temp;
			begin++;
			end--;
		}
		return new String(sChar);
	}
	public static void main(String[] args) {
		O345ReverseVowelsString e = new O345ReverseVowelsString();
		System.out.println(e.reverseVowels("tst"));
	}
}