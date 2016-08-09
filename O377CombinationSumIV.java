<<<<<<< HEAD
=======
import java.util.*;

>>>>>>> origin/master
public class O377CombinationSumIV {
	 public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i <= target; i++) {
        	for (int j = 0; j < nums.length; j++) {
        		if (nums[j] <= i) {
        			res[i] += res[i - nums[j]];
        		}
        	}
        }
        return res[target];
    }
}