public class BinarySearch {
	public static void main (String[] args) {
		int x = Integer.parseInt(args[0]);
		int len = args.length;
		int[] a = new int[len - 1];
		for (int i = 1; i < len; i++) {
			a[i - 1] = Integer.parseInt(args[i]);
		}
		if (len == 1 || a[len - 2] > x) {
			System.out.println(len - 1);
		} else {
			int ans1 = notRecursionBinarySearch(x, a, len - 1);
			int ans2 = recursionBinarySearch(x, a, -1, len - 2);
			if (ans1 == ans2) {
				System.out.println(ans1);
			} else {
				System.out.println("Opss");
			}
		}
	}

	//*sort - для любого (0 < i < len - 1) выполняется a[i - 1] >= a[i]

	//pre: len >= 1 && a[len - 1] <= x && sort
	//post: a[R] <= x && для любого 0 <= i < R, a[i] > x $$ sort
	private static int notRecursionBinarySearch (int x, int[] a, int len){
		//pre: len >= 1 && a[len - 1] <= x && sort
		int l = -1, r = len - 1; 
		//post: r > l && a[r] <= x && sort

		//pre: r > l && a[r] <= x && sort && l == -1
		//I: r > l && l >= -1 && a[r] <= x && (l < 0 || a[l] > x)
		while (r - l > 1) {
			//pre: l - r >= 1 && a[len - 1] <= x && sort
			int m = (l + r) / 2;
			//post: l < m < r && a[len - 1] <= x && sort

			//pre: l < m < r && a[len - 1] <= x && sort
			if (a[m] <= x) {
				r = m; 
			} else {
				l = m;
			}
			// a[r] <= x && a[r] > l && (a[l] > x || l == -1) && sort
		} 
		//post: (r - l <= 1, r < l => r = l + 1) &&  
		// a[r] <= x, (l ==-1 || a[l] > x), sort => для любого 0 <= i < r, a[i] > x &&
		// sort

		return r;
	}

	//pre: l == -1 && r >= 0 && a[r] <= x
	//post: a[R] <= x && для любого 0 <= i < R, a[i] > x $$ sort
	private static int recursionBinarySearch (int x, int[] a, int l, int r){
		//pre: r > l && 
		if (r - l == 1) {
			return r;
		} else {
			int m = (l + r) / 2;
			if (a[m] <= x) {
				r = m;
			} else {
				l = m;
			}
			return recursionBinarySearch (x, a, l, r);
		}
	}
} 