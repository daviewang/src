import java.util.Iterator;

public class O284PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> it;
	boolean isPeek;
	Integer peekElement;
	
	public O284PeekingIterator(Iterator<Integer> iterator) {
		it = iterator;
		isPeek = false;
		peekElement = null;
	}
	public boolean hasNext() {
		return isPeek || it.hasNext();
	}
	
	public Integer next() {
		if (isPeek) {
			isPeek = false;
			return peekElement;
		}
		else {
			return it.next();
		}
	}
	
	public Integer peek() {
		if (isPeek) {
			return peekElement;
		}
		else if (it.hasNext()) {
			peekElement = it.next();
			isPeek = true;
			return peekElement;
		}
		else {
			return null;
		}
	}
}