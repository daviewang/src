public class O396RotateFunction {
	public int maxRotateFunction(int[] A) {
		int res = 0;
		int sum = 0;
		int singleRes = 0;
		
		if (A == null || A.length == 0) {
			return res;
		}
		
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			singleRes += i * A[i];
		}
		res = singleRes;
		
		for (int i = A.length - 1; i >= 0; i--) {
			singleRes = singleRes + sum - A.length * A[i];
			res = Math.max(res, singleRes);
		}
        return res;
    }
}