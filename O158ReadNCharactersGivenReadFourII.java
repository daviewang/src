public class O158ReadNCharactersGivenReadFourII extends Reader4{
	private int cacheIdx = 0;
	private char[] cache = new char[4];
	private int readCounts = 0;
	
	public int read(char[] buf, int n) {
		int curr = 0;
		
		while (curr < n) {
			//如果cacheIdx不为0，代表readCounts有剩余，也不为0
			if (cacheIdx == 0) {
				readCounts = read4(cache);
			}
			if (readCounts ==0) {
				break;
			}
			while (curr < n && cacheIdx < readCounts) {
				buf[curr++] = cache[cacheIdx++];
			} 
			
			if (cacheIdx == readCounts) {
				cacheIdx = 0;
			}
		}
		return curr;
	}
}