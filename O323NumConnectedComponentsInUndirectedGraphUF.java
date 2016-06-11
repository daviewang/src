public class O323NumConnectedComponentsInUndirectedGraphUF {
	public int countComponents(int n, int[][] edges) {
		int[] roots = new int[n];
		for (int i = 0; i < n; i++) roots[i] = i;
		
		for (int[] edge : edges) {
			int root1 = find(roots, edge[0]);
			int root2 = find(roots, edge[1]);
			if (root1 != root2) {
				roots[root1] = root2;
				n--;
			}
		}
		return n;
	}
	
	private int find(int[] roots, int id) {
		while (roots[id] != id) {
			roots[id] = roots[roots[id]];
			id = roots[id];
		}
		return id;
	}
	
	public static void main(String[] args) {
		O323NumConnectedComponentsInUndirectedGraphUF e = new O323NumConnectedComponentsInUndirectedGraphUF();
		int[][] edges = {{0,1},{1,2},{3,4}};
		System.out.println(e.countComponents(5, edges));
	}
}