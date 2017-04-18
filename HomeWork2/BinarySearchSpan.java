public class BinarySearchSpan {
	public static void main (String[] args) {
		int x = Integer.parseInt(args[0]);
		int len = args.length;
		int[] a = new int[len - 1];
		for (int i = 1; i < len; i++) {
			a[i - 1] = Integer.parseInt(args[i]);
		}
		int left = notRecursionBinarySearch(x, a, len - 1);
		int right = recursionBinarySearch(x, a, -1, len - 1);
		if (left == len - 1 || a[left] != x){
			System.out.println(left + " " + 0);
		} else {
			System.out.println(left + " " + (right - left + 1));
		}
	}

	//*sort - for i = 0..len - 1 a[i] >= a[i + 1]

	//pre: sort && a[-1] = +inf && a[len] = -inf 
	//post: R && a[R] <= x && a[R - 1] > x && sort
	private static int notRecursionBinarySearch(int x, int[] a, int len){
		int l = -1, r = len; 

		//pre: r > l && sort && a[-1] = +inf && a[len] = -inf && a[l] > x && a[r] <= x

		// I: r > l && a[l] > x && a[r] <= x  
		while (r - l > 1) { 
			int m = (l + r) / 2;
			//pre: l < m < r && sort && a[l] > x && a[r] <= x
			if (a[m] <= x) {
				r = m; 
			} else {
				l = m;
			}
			//post: (r' < r || l' > l) && sort && a[l] > x && a[r] <= x
		} 
		//post: r - l <= 1 && r > l => r - l == 1
		//r - l == 1 => a[r - 1 = l] > x && a[r] <= x

		return r;
	}

	//* Let a[-1] = +inf && a[len] = -inf 
	//pre: r > l && sort && a[l] >= x && a[r] < x
	//post: R && a[R] >= x && a[R - 1] < x 
	private static int recursionBinarySearch (int x, int[] a, int l, int r) { 
		if (r - l == 1) {
			//pre: r - l = 1 -> a[l + 1 = r] > x
			//a[l] >= x
			return l;
		} else {
			int m = (l + r) / 2;
			//pre: l < m < r && sort
			if (a[m] >= x) {
				l = m;
			} else {
				r = m;
			}
			//post: r > l && sort && a[-1] = +inf && a[len] = -inf && a[l] >= x && a[r] < x
			return recursionBinarySearch (x, a, l, r);
		}
	}
}  