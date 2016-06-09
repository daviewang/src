import java.util.ArrayList;
import java.util.List;

public class O282ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		dfs(res, num, "", 0, 0, 0, target);
		return res;
	}
	
	private void dfs(List<String> res, String num, String singleRes, int pos, long currSum, long lastNum, int target) {
		if (pos >= num.length()) {
			if (target == currSum) {
				res.add(singleRes);
			}
			return;
		} 
		
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0') {
				break;
			}
			String currNumStr = num.substring(pos, i + 1);
			long currNum = Long.parseLong(currNumStr);
			if (pos == 0) {
				dfs(res, num, currNumStr, i + 1, currNum, currNum, target);
			}
			else {
				dfs(res, num, singleRes + "+" + currNumStr, i + 1, currSum + currNum, currNum, target);
				dfs(res, num, singleRes + "-" + currNumStr, i + 1, currSum - currNum, -currNum, target);
				dfs(res, num, singleRes + "*" + currNumStr, i + 1, currSum - lastNum + lastNum * currNum, lastNum * currNum, target);
			}
		}
	}
	
	public static void main(String[] args) {
		O282ExpressionAddOperators e = new O282ExpressionAddOperators();
		e.addOperators("105", 5);
	}
}