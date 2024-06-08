package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			T[i] = t;
			P[i] = p;
		}

		for (int i = 0; i < N; i++) {
			int day = T[i];
			int cost = P[i];
			if (i + day <= N) {
				dp[i + day] = Math.max(dp[i + day], dp[i] + cost);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
