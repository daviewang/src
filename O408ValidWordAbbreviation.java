public class O408ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
    
    public static void main(String[] args) {
    	O408ValidWordAbbreviation e = new O408ValidWordAbbreviation();
    	System.out.println(e.validWordAbbreviation("word", "1word"));
    	System.out.println(e.validWordAbbreviation("word", "w1d"));
    	System.out.println(e.validWordAbbreviation("word", "2rd"));
    	System.out.println(e.validWordAbbreviation("word", "w2d"));
    	System.out.println(e.validWordAbbreviation("word", "11d"));
    	System.out.println(e.validWordAbbreviation("word", "1or1"));
    	System.out.println(e.validWordAbbreviation("word", "2r1"));
    	System.out.println(e.validWordAbbreviation("word", "3d"));
    	System.out.println(e.validWordAbbreviation("word", "w3"));
    	System.out.println(e.validWordAbbreviation("word", "3"));
    }
}