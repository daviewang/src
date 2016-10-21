public class O390EliminationGame {
    public int lastRemaining(int n) {
    	if (n == 0) {
    		return 0;
    	}
        boolean left = true;
        int step = 1;
        int head = 1;
        int remaining = n;
        
        while (remaining > 1) {
        	if (left || remaining % 2 == 1) {
        		head += step;
        	}
        	remaining /= 2;
        	step *= 2;
        	left = !left;
        }
        return head;
    }
}