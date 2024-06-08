package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1912 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		int ret = 0;
		dp[0] = ret = input[0];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + input[i], input[i]);
			ret = Math.max(dp[i], ret);
		}
		System.out.println(ret);
//		System.out.println(Arrays.toString(dp));
	}

}
