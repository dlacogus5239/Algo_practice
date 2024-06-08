package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11055_LIS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = input[i];
		}
		// input END
		int ret = input[0];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < i; ++j) {
				if (input[j] < input[i]) {
					dp[i] = Math.max(dp[i], dp[j] + input[i]);
					ret = Math.max(dp[i], ret);
				}
			}
		}

//		System.out.println(Arrays.toString(dp));
		System.out.println(ret);

	}

}
