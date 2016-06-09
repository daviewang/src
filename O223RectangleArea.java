public class O223RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int width = 0, height = 0;
		if (E < C && G > A && B < H && F < D) {
			width = Math.min(C - A, G - E);
			height = Math.min(D - B, H - F);
		
			height = Math.min(Math.min(H - B, D - F), height);
			width = Math.min(Math.min(C - E, G - A), width);
		}
		
		int v1 = (D - B) * (C - A);
		int v2 = (H - F) * (G - E);
		return v1 + v2 - height * width;
	}
	public static void main(String[] args) {
		O223RectangleArea e = new O223RectangleArea();
		e.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
	}
}