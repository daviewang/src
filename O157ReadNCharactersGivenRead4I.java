public class O157ReadNCharactersGivenRead4I extends Reader4 {
	public int read(char[] buf, int n) {
		boolean isEnd = false;
		int readChars = 0;
		char[] currRead = new char[4];
		
		while (!isEnd && readChars < n) {
			int currIdx = read4(currRead);
			if (currIdx < 4) {
				isEnd = true;
			}
			int len = Math.min(currIdx, n - readChars);
			for (int i = 0; i < len; i++) {
				buf[readChars + i] = currRead[i];
			}
			readChars += len;
		}
		return readChars;
	}
}
