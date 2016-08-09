import java.util.ArrayList;
import java.util.List;

public class O271EncodeDecodeStrings {
	public String encode(List<String> strs) {
		if (strs == null || strs.size() == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (String str : strs) {
			int len = str.length();
			sb.append(len).append("/").append(str);
		}
		return sb.toString();
	}
	
	public List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		int i = 0;
		while (i < s.length()) {
			int slash = s.indexOf("/", i);
			int len = Integer.valueOf(s.substring(i, slash));
			//String singleRes = s.substring(slash + 1, slash + len + 1);
			i = slash + len + 1;
		}
		return res;
	}
}