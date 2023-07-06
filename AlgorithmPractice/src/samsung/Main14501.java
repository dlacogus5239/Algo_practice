package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501 {
	// 백준 14501 퇴사
	static int N;
	// 상담 일수, 이득
	static int[] T, P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 2];
		dp[0] = 0;
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
