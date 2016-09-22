import java.util.*;
public class O384ShuffleArray {
	Random random;
	int[] nums;
	public O384ShuffleArray(int[] nums) {
        random = new Random();
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = nums.clone();
        for (int i = 0; i < res.length; i++) {
        	int r = random.nextInt(i + 1);
        	swap(res, i, r);
        }
        return res;
    }
    
    public void swap(int[] a, int i, int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
}