public class O255VerifyPreorderBST {
	public boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0 || preorder.length == 1) {
			return true;
		}
		return helper(preorder, 0, preorder.length - 1);
	}
	
	
	private boolean helper(int[] preorder, int start, int end) {
		if (start >= end) {
			return true;
		}
		int currIdx = -1;
		int rootElement = preorder[start];
		for (int i = start + 1; i <= end; i++) {
			if (rootElement < preorder[i]) {
				break;
			}
			currIdx++;
		}
		
		if (currIdx == - 1) {
			return helper(preorder, start + 1, end);
		}
		else {
			for (int i = currIdx; i <= end; i++) {
				if (preorder[i] < rootElement) {
					return false;
				}
			}
			return helper(preorder, start + 1, currIdx - 1) && 
					helper(preorder, currIdx, end);
		}
	}
}