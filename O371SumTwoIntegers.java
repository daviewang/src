public class  O371SumTwoIntegers {
	public int getSum(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return getSum(sum, carry);
	}
	
	public int getSub(int a, int b) {
		b = ~b + 1;
		return getSum(a, b);
	}
	
	public static void main(String[] args) {
		O371SumTwoIntegers e = new O371SumTwoIntegers();
		System.out.println(e.getSum(3, 1));
		System.out.println(e.getSub(3, 1));
	}
}