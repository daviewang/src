import java.util.Set;

public class O139WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
       	int len = s.length();
        boolean[] res = new boolean[len + 1];
        res[0] = true;
        
        for (int i = 1; i <= len; i++) {
        	for (int j = 0; j < i; j++ ) {
        		if (res[j] == true && wordDict.contains(s.substring(j,i))) {
        			res[i] = true;
        			break;
        		}
        	}
        }
        return res[len]; 
    }
}