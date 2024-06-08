package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15486 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] T = new long[N + 1];
		long[] P = new long[N + 1];
		long[] dp = new long[N + 1];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long t = Long.parseLong(st.nextToken());
			long p = Long.parseLong(st.nextToken());
			T[i] = t;
			P[i] = p;
		}
		for (int i = 0; i < N; i++) {
			int day = (int) T[i];
			long cost = P[i];
			if (i + day <= N) {
				dp[i + day] = Math.max(dp[i + day], dp[i] + cost);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		long max = Long.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
