package swea;

import java.util.Scanner;

public class Solution5607 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			long result = 0L;
			result = nCr(N, R, 1234567891);
			System.out.println("#" + test_case + " " + result);
		}
	}

	static long nCr(int n, int r, int p) {
		if (r == 0) {
			return 1L;
		}
		long[] fac = new long[n + 1];
		fac[0] = 1;
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i - 1] * i % p;
		}

		return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
	}

	static long power(long x, long y, long p) {
		long result = 1L;
		x = x % p;
		while (y > 0) {
			if (y % 2 == 1) {
				result = (result * x) % p;
			}
			y = y >> 1; // y = y/2
			x = (x * x) % p;
		}
		return result;
	}

}
