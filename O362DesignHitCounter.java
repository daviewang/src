public class O362DesignHitCounter {
	int[] times;
	int[] hits;
	public O362DesignHitCounter() {
		times = new int[300];
		hits = new int[300];
	}
	
	public void hit(int timestamp) {
		int idx = timestamp % 300;
		if (times[idx] != timestamp ) {
			times[idx] = timestamp;
			hits[idx] = 1;
		}
		else {
			hits[idx]++;
		}
	}
	
	public int getHits(int timestamp) {
		int res = 0;
		for (int i = 0; i < 300; i++) {
			if (timestamp - times[i] < 300) {
				res += hits[i];
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		O362DesignHitCounter e = new O362DesignHitCounter();
		e.hit(1);
		e.hit(2);
		e.hit(3);
		e.hit(3);
		System.out.println(e.getHits(4));
		e.hit(300);
		System.out.println(e.getHits(300));
		System.out.println(e.getHits(301));
	}
}