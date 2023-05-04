package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9096_2 {
	// 백준 9095 1, 2, 3 더하기
	// 다이나믹 프로그래밍으로 풀이
	static int[] dp = new int[12];

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 12; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}

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

}
