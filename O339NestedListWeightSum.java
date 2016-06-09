import java.util.List;

public class O339NestedListWeightSum {
	interface NestedInteger {
		public boolean isInteger();
		public Integer getInteger();
		public List<NestedInteger> getList();
	}

	public int depthSum(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) return 0;
		return helper(nestedList, 1);
	}
	
	private int helper(List<NestedInteger> nestedList, int level) {
		int singleRes = 0;
		for (NestedInteger singleItem : nestedList) {
			if (singleItem.isInteger()) {
				singleRes += singleItem.getInteger();
			}
			else {
				singleRes += helper(singleItem.getList(), level + 1);
			}
		}
		return singleRes * level;
	}
}