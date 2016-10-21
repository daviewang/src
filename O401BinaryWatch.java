import java.util.*;

public class O401BinaryWatch {
	int[] time = new int[] {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
		boolean[] hit = new boolean[10];
		helper(hit, 0, num, res);
		return res;
	}
	
	private void helper(boolean[] hit, int pos, int count, List<String> res) {
		if (count == 0) {
			int hh = 0;
			int mm = 0;
			for (int i = 0; i < 4; i++) {
				if (hit[i]) {
					hh += time[i];
				}
			}
			for (int i = 4; i < 10; i++) {
				if (hit[i]) {
					mm += time[i];
				}
			}
			//hours (0-11), minutes (0-59).
			if (hh> 11 || mm > 59) {
				return;
			}
			String mmStr = mm < 10 ? "0" + mm : String.valueOf(mm);
			res.add(String.valueOf(hh) + ":" + mmStr);
			return;
		}
		for (int i = pos; i < hit.length; i++) {
			hit[i] = true;
			helper(hit, i + 1, count - 1, res);
			hit[i] = false;
		}
	}
	/*
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
		for (int i = 0; i < 12; i++)
			for (int j = 0; j < 60; j++) {
				if (Integer.bitCount((i << 6) | j) == num) {
					StringBuilder sb = new StringBuilder();
					if (j < 10) {
					    sb.append(i + ":0" + j);
					}
					else {
					    sb.append(i + ":" + j);
					}
					res.add(sb.toString());
				}
		}
		return res;	
    }
    */
    public static void main(String[] args) {
    	O401BinaryWatch e = new O401BinaryWatch();
    	e.readBinaryWatch(2);
    }
}