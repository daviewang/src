import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O339NestedListWeightSum {
	interface NestedInteger {
		public boolean isInteger();
		public Integer getInteger();
		public List<NestedInteger> getList();
	}

	public int depthSum(List<NestedInteger> nestedList) {
		int res = 0;
		int level = 1;
		Queue<NestedInteger> queue = new LinkedList<>();
		queue.addAll(nestedList);
				
		while (!queue.isEmpty()) {
			int size = queue.size();
			int singleRes = 0;
			for (int i = 0; i < size; i++) {
				NestedInteger item = queue.poll();
				if (item.isInteger()) {
					singleRes += item.getInteger();
				}
				else {
					queue.addAll(item.getList());
				}
			}
			res += singleRes * level;
			level++;
		}
		return res;
	}
	
	/*
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
	*/
}