import java.util.*;

public class O386LexicographicalNums {
	public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) return res;
        int curr = 1;
        for (int i = 1; i <= n; i++) {
        	res.add(curr);
        	if (curr * 10 <= n) {
        		curr *= 10;
        	}
        	else if (curr % 10 != 9 && curr + 1 <= n) {
        		curr += 1;
        	}
        	else {
        		while ((curr / 10) % 10 == 9) { //n = 34 如果是19，下一个就是20.所以只要判断到19.
        			//199 next one is 2
        			curr /= 10;
        		}
        		curr = curr / 10 + 1;
        	}
        }
        return res;
	}
	public static void main(String[] args) {
		O386LexicographicalNums e = new O386LexicographicalNums();
		e.lexicalOrder(13);
	}
}