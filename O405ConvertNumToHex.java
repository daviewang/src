public class O405ConvertNumToHex {
	public String toHex(int num) {
		char[] hexes = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
        	sb.append(hexes[num & 0xf]);
        	num >>>= 4;
        }
        return sb.reverse().toString();
    }
}