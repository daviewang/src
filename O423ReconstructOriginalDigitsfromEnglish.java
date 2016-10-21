public class O423ReconstructOriginalDigitsfromEnglish {
    public String originalDigits(String s) {
        int[] nums = new int[10];
		int[] charsNum = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			charsNum[s.charAt(i) - 'a']++;
		}
		
		nums[0] = charsNum['z' - 'a'];
		nums[2] = charsNum['w' - 'a'];
		nums[4] = charsNum['u' - 'a'];
		nums[6] = charsNum['x' - 'a'];
		nums[8] = charsNum['g' - 'a'];
		
		nums[7] = charsNum['s' - 'a'] - nums[6];
		nums[3] = charsNum['h' - 'a'] - nums[8];
		nums[5] = charsNum['f' - 'a'] - nums[4];
		
		nums[1] = charsNum['o' - 'a'] - nums[0] - nums[2] - nums[4];
		nums[9] = charsNum['i' - 'a'] - nums[5] - nums[6] - nums[8];
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i <= 9; i++) {
			if (nums[i] != 0) {
				while (nums[i]-- > 0) {
					sb.append(i);
				}
			}
		}
		return sb.toString();
    }
    
    public static void main(String[] args) {
    	O423ReconstructOriginalDigitsfromEnglish e = new O423ReconstructOriginalDigitsfromEnglish();
    	e.originalDigits("nnei");    	
    }
}