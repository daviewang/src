import java.util.ArrayList;
import java.util.List;

public class O068TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		for (int i = 0, wCount; i < words.length; i = wCount) {
			int len = -1;
			StringBuilder sb = new StringBuilder(words[i]);
			for (wCount = i; wCount < words.length && len + words[wCount].length() + 1 <= maxWidth; wCount++) {
				len += words[wCount].length() + 1;
			}
		
			int space = 1, extraspace = 0;
			if (wCount != i + 1 && wCount != words.length) {
				space = (maxWidth - len) / (wCount - i - 1) + 1;
				extraspace = (maxWidth - len) % (wCount - i - 1);
			}
			for (int j = i + 1; j < wCount; j++) {
				for (int s = space; s > 0; s--) 
					sb.append(' ');
				if (extraspace-- > 0)
					sb.append(' ');
				sb.append(words[j]);
			}
			
			int leftLen = maxWidth - sb.length();
			while (leftLen-- > 0) sb.append(' ');
			res.add(sb.toString());
		}
		return res;
	}
}