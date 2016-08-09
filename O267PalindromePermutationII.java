import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O267PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		
		Map<Character, Integer> map = new HashMap<>();
		boolean isOdd = false;
		List<Character> list = new ArrayList<>();
		String mid = "";
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
		}
		
		for (Character c : map.keySet()) {
			if (map.get(c) % 2 == 1) {
				if (!isOdd) {
					isOdd = true;
				}
				else {
					return res;
				}
			}
		}
		
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count % 2 == 1) {
				mid = c.toString();
			}
			for (int i = 0; i < count / 2; i++) {
				list.add(c);
			}
		}
		//List在这里已经是有序的了
		getPermutation(res, list, new boolean[list.size()], new StringBuilder(), mid);
		return res;
	}
	
	private void getPermutation(List<String> res, List<Character> list, boolean[] visited, StringBuilder sb, String mid) {
		if (sb.length() == list.size()) {
			res.add(sb.toString() + mid + sb.reverse().toString());
			sb.reverse();
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i) == list.get(i - 1) && visited[i - 1]) continue;
			if (!visited[i]) {
				sb.append(list.get(i));
				visited[i] = true;
				getPermutation(res, list, visited, sb, mid);
				visited[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		O267PalindromePermutationII e = new O267PalindromePermutationII();
		e.generatePalindromes("aaaaccb");
	}
}