public class O411MinUniqueWordAbbreviation {
    private String res = "";
	private int min = Integer.MAX_VALUE;
	private String[] dict;
    public String minAbbreviation(String target, String[] dictionary) {
        if (dictionary.length == 0) return "" + target.length();
        dict = dictionary;
    	generateAbbreviations(target, 0, "", 0, 0);
    	return res;
    }
    //check if it's a valid unique abbreviation after building an abbreviation
    private void check (String abbr, int length) {
		for (String word: dict) {
			// It is required to return unvalidate abbr. Therefore, if it is validate, just return it without saving
			if (validWordAbbreviation(word, abbr)) return;
		}
		min = length;
		res = abbr;
    }
    //basically backtracking implementation of Generalized Abbreviation, but adding a length
    private void generateAbbreviations(String s, int pos, String sb, int count, int length){
        //prune out those abbreviations longer than our current shortest unique abbreviation
        if (length >= min) {
            return;
        } 
        // Recursive return, need to check if the abbr is validate in dicts;
        else if (s.length() == pos) {
            if (count > 0) {
            	//Each number or letter in the abbreviation is considered length = 1
            	if (length + 1 < min) check(sb + count, length + 1);
            } else {
            	check(sb.toString(), length);
            }
        }
        else {
            // Ignore it.
            generateAbbreviations(s, pos + 1, sb, count + 1, length);
            
            // Keep it
            if (count != 0) {
            	// length + 2 => 1 is for count, one is for new car
            	generateAbbreviations(s, pos + 1, sb + count + s.charAt(pos), 0, length + 2);
    		}
    		else {
    			generateAbbreviations(s, pos + 1, sb + s.charAt(pos), 0, length + 1);
    		}
        }
    }
    //from 408 Valid Word Abbreviation
    private boolean validWordAbbreviation(String word, String abbr) {
    	int wIdx = 0;
    	int aIdx = 0;
    	
    	while (wIdx < word.length() && aIdx < abbr.length()) {
    		if (word.charAt(wIdx) == abbr.charAt(aIdx)) {
    			wIdx++;
    			aIdx++;
    			continue;
    		}
    		if (abbr.charAt(aIdx) <= '0' || abbr.charAt(aIdx) > '9') {
    			return false;
    		}
    		int start = aIdx;
    		while (aIdx < abbr.length() && abbr.charAt(aIdx) >= '0' && abbr.charAt(aIdx) <= '9') {
    			++aIdx;
    		}
    		int num = Integer.valueOf(abbr.substring(start, aIdx));
    		wIdx += num;
    	}
        return aIdx == abbr.length() && wIdx == word.length();
    }
    
    public static void main(String[] args) {
    	O411MinUniqueWordAbbreviation e = new O411MinUniqueWordAbbreviation();
    	String target = "apple"; 
        String[] dictionary = {"plain", "amber", "blade"};
        System.out.println(e.minAbbreviation(target, dictionary));
    }
}