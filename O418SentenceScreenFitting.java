public class O418SentenceScreenFitting {
	public int wordsTyping(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            System.out.println(start % l);
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        
        return start / s.length();

		/*
		int rowIdx = 0;
		int colIdx = 0;
		int sentenceIdx = 0;
		int res = 0;
		
		while (rowIdx < rows && colIdx < cols) {
			int remain = cols - colIdx;
			String s = sentence[sentenceIdx];
			
			if (s.length() > cols) return -1;
			
			if (s.length() + 1 == remain || s.length() == remain) {
				sentenceIdx++;
				rowIdx ++;
				colIdx = 0;
			}
			else if (s.length() + 1 < remain) {
				sentenceIdx++;
				colIdx = colIdx + s.length() + 1;
			}
			else {
				rowIdx++;
				colIdx = 0;
			}
			if (sentenceIdx == sentence.length) {
				res++;
				sentenceIdx = 0;
			}
		}
		return res;
		*/
	}
	
	public static void main(String[] args) {
		String[] sentence = {"abc", "de", "f"};
		O418SentenceScreenFitting e = new O418SentenceScreenFitting();
		System.out.println(e.wordsTyping(sentence, 4, 6));
	}
}