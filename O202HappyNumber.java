import java.util.HashSet;
import java.util.Set;

public class O202HappyNumber {
	public boolean isHappy(int num) {
		Set<Integer> set = new HashSet<>();
		while (true) {
			int numSum = 0;
			while (num > 0) {
				numSum += Math.pow((num % 10), 2);
				num = num / 10;
			}
			if (numSum == 1) {
				return true;
			}
			else if (set.contains(numSum)){
				return false;
			}
			num = numSum;
			set.add(numSum);
		}
	}
}