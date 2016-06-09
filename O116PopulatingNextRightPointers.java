import java.util.LinkedList;
import java.util.Queue;

public class O116PopulatingNextRightPointers {
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {val = x;}
	}
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		Queue<TreeLinkNode> queue = new LinkedList<>();
		int len = 0;
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			len = queue.size();
			while (len-- > 0) {
				TreeLinkNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
					queue.add(node.right);
					node.left.next = node.right;
					
					if (node.next != null) {
						node.right.next = node.next.left;
					}
					else {
						node.right.next = null;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		O116PopulatingNextRightPointers e = new O116PopulatingNextRightPointers();
		TreeLinkNode n1 = e.new TreeLinkNode(1);
		TreeLinkNode n2 = e.new TreeLinkNode(2);
		TreeLinkNode n3 = e.new TreeLinkNode(3);
		n1.left = n2;
		n1.right = n3;
		e.connect(n1);
	}
}