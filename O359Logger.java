import java.util.Map;
import java.util.HashMap;

public class O359Logger {
	Map<String, Integer> map = new HashMap<>();
    public boolean shouldPrintMessage(int timestamp, String message) {
		if (map.containsKey(message)) {
			if (timestamp - map.get(message) < 10) {
				return false;
			}
			else {
				map.put(message, timestamp);
				return true;
			}
		}
		else {
			map.put(message, timestamp);
			return true;
		}
	}
    
    public static void main(String[] args) {
    	O359Logger e = new O359Logger();
    	System.out.println(e.shouldPrintMessage(1, "foo"));
    	System.out.println(e.shouldPrintMessage(3, "foo"));
    	System.out.println(e.shouldPrintMessage(10, "foo"));
    	System.out.println(e.shouldPrintMessage(11, "foo"));
    	System.out.println(e.shouldPrintMessage(12, "foo"));
    }
}
