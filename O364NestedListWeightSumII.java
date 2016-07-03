import java.util.ArrayList;
import java.util.List;
public class O364NestedListWeightSumII {
	interface NestedInteger {
		public boolean isInteger();
		public Integer getInteger();
		public List<NestedInteger> getList();
	}
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
		int singleInteger = 0;
		int res = 0;
		while (!nestedList.isEmpty()) {
			List<NestedInteger> nextLevel = new ArrayList<>();
			for (NestedInteger item : nestedList) {
				if (item.isInteger()) {
					// singleInteger is not zero, but cumulated
					singleInteger += item.getInteger();
				}
				else {
					nextLevel.addAll(item.getList());
				}
			}
			res += singleInteger;
			nestedList = nextLevel;
		}
		return res;
	}
}
