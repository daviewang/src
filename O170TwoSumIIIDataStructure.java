import java.util.HashMap;
import java.util.Map;

public class O170TwoSumIIIDataStructure {
	Map<Integer, Integer> map = new HashMap<>();
	public O170TwoSumIIIDataStructure() {}
	
	public void add(int i) {
		if (map.containsKey(i)) {
			map.put(i, map.get(i) + 1);
		}
		else {
			map.put(i, 1);
		}
	}
	
	public boolean find(int i) {
		for (int j : map.keySet()) {
			int left = i - j;
			if (j != left && map.containsKey(left)) {
				return true;
			}
			else if (j == left && map.get(left) > 1) {
				return true;
			}
		}
		return false;
	}
}