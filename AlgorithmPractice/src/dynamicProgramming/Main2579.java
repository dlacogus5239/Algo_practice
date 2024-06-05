package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2579 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] stairs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N + 1];
		if (N == 1) {
			System.out.println(stairs[1]);
			return;
		} else if (N == 2) {
			System.out.println(stairs[1] + stairs[2]);
			return;
		} else if (N == 3) {
			System.out.println(stairs[3] + Math.max(stairs[1], stairs[2]));
			return;
		}
		dp[1] = stairs[1];
		dp[2] = stairs[2] + stairs[1];
		dp[3] = stairs[3] + Math.max(stairs[1], stairs[2]);

		// 연속한 3 계단을 안 밟는 방법은,
		// 이전 2칸을 뛰고 1칸, 아니면 직전에 바로 2칸 뛰었을 경우...
		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
		}

		System.out.println(dp[N]);
	}

}
