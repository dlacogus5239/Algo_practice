package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main9461 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for (int i = 6; i < 101; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
//		System.out.println(Arrays.toString(dp));
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}

		System.out.println(sb.toString());
	}

}
