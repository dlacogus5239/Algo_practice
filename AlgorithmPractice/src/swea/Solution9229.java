package swea;


import java.util.Arrays;
import java.util.Scanner;

// SWEA 9229
public class Solution9229 {
	static int[] snack;
	static int n;
	static int m;

	static int max;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();

		for (int T = 1; T <= test_case; T++) {
			n = sc.nextInt();
			m = sc.nextInt();
			snack = new int[n];

			max = -1;
			for (int i = 0; i < n; i++) {
				snack[i] = sc.nextInt();
			}
			Arrays.sort(snack);
			if (snack[0] + snack[1] > m) {
				System.out.println("#" + T + " " + max);
				continue;
			}
			for (int i = n - 1; i > 0; i--) {
				if (m - snack[i] <= 0) {
					continue;
				}
				for (int j = 0; j < i; j++) {
					if (snack[j] + snack[i] > m) {
						continue;
					} else {
						if (max < snack[j] + snack[i]) {
							max = snack[j] + snack[i];
						}
					}
				}
			}

			System.out.println("#" + T + " " + max);
		}
	}

}
