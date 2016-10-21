import java.util.*;

public class O422ValidWordSquare {
	 public boolean validWordSquare(List<String> words) {
		if (words == null || words.size() == 0) {
			return true;
		}
		
		int len = words.size();
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				// both are not null
				if (j < words.get(i).length() && i < words.get(j).length()) {
					if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
						return false;
					}
				}
				// both are null
				else if (words.get(i).length() <= j && words.get(j).length() <= i) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		O422ValidWordSquare e = new O422ValidWordSquare();
		List<String> words = new ArrayList<>();
		words.add("barl");
		words.add("area");
		words.add("read");
		words.add("lady");

		System.out.println(e.validWordSquare(words));
	}
}