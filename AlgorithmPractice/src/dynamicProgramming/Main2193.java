package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main2193 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[] one = new long[N + 1];
		long[] zero = new long[N + 1];
		long[] dp = new long[N + 1];
		one[1] = 1;
		zero[1] = 0;
		dp[1] = 1;
//		one[2] = 0;
//		zero[2] = 1;

		for (int i = 2; i <= N; i++) {
			one[i] = zero[i - 1];
			zero[i] = one[i - 1] + zero[i - 1];
			dp[i] = one[i] + zero[i];
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}

}
