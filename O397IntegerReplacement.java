public class O397IntegerReplacement {
    public int integerReplacement(int n) {
        int res = 0;
        while (n != 1) { // Think Integer.MAX_VALUE
        	if ((n & 1) == 0) {
        		n >>>= 1;
        	}
        	else if (n == 3 || (((n >>> 1) & 1) == 0)) { // ending with 01
        		n--;
        	}
        	else {
        		n++;
        	}
        	res++;
        }
        return res;
    }
    
    public static void main(String[] args) {
    	O397IntegerReplacement e = new O397IntegerReplacement();
    	e.integerReplacement(Integer.MAX_VALUE);
    }
}