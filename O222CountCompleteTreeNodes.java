public class O222CountCompleteTreeNodes {
	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x){val = x;}
	}
	public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int l = leftHeight(root) + 1;
        int r = rightHeight(root) + 1;
        
        if (l == r) {
        	return (1<<l) - 1;
        }
        else {
        	return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
	
	private int leftHeight(TreeNode root) {
		int res = 0;
		while (root.left != null) {
			res++;
			root = root.left;
		}	
		return res;
	}
	
	private int rightHeight(TreeNode root) {
		int res = 0;
		while (root.right != null) {
			res++;
			root = root.right;
		}	
		return res;
	}
}