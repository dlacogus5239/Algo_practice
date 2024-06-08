package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11053_LIS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		dp[0] = 1;
		Arrays.fill(dp, 1);
		int maxLen = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					maxLen = Math.max(maxLen, dp[i]);
				}
			}
		}
		System.out.println(maxLen);
	}

}
