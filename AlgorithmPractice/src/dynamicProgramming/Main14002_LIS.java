package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main14002_LIS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		int[] way = new int[N];
		Arrays.fill(dp, 1);
		Arrays.fill(way, -1);
		int maxLen = 1;
		int maxIdx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i]) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						way[i] = j;
					}
					if (maxLen < dp[i]) {
						maxLen = dp[i];
						maxIdx = i;
					}
				}
			}
		}
		System.out.println(maxLen);

		StringBuilder sb = new StringBuilder();
		int idx = maxIdx;
		Stack<Integer> s = new Stack<>();
		while (idx != -1) {
			s.add(input[idx]);
			idx = way[idx];
		}
		while (!s.isEmpty()) {
			sb.append(s.pop()).append(" ");
		}
		System.out.println(sb.toString());

	}

}
