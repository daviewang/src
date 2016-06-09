import java.util.HashSet;
import java.util.Set;

public class O217ContainsDup {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : nums) {
			if (!set.add(i)) return true;
		}
		return false;
	}
}