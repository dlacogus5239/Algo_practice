package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9095 {
	// 백준 9095 1, 2, 3 더하기
	static int[] dp = new int[12];

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dfs(0);
		// test case START
		for (int t = 0; t < T; t++) {
			// 1, 2, 3으로 나타낼 정수
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		// test case END

		// result
		System.out.println(sb.toString());
	}

	public static void dfs(int n) {
		if (n > 11) {
			return;
		}
		dp[n]++;
		dfs(n + 1);
		dfs(n + 2);
		dfs(n + 3);
	}

}
