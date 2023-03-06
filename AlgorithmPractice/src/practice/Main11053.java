package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11053 {
	// 백준 11053 가장 긴 증가하는 부분 수열
	static int N;
	static int[] num;
	static Integer[] dp;

	// 탐색하려는 위치에서의 최장 수열은 ...
	// 이전 위치들을 찾아나가면서 해당 값보다 작을 경우 재귀호출을 통해 탐색

	// N위치에서 이전에 탐색한 결과물이 있는지(null 이 아니면 탐색한 것)
	// 없으면 N위치를 1로 초기화.
	// 부분수열의 길이는 최소한 1 이상이기 때문. (자기 자신 포함)

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		num = new int[N];
		dp = new Integer[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		// input END

		for (int i = 0; i < N; i++) {
			LIS(i);
		}
		Arrays.sort(dp);
		System.out.println(dp[N - 1]);

	}

	public static int LIS(int idx) {
		// 탐색하지 않은 위치?
		if (dp[idx] == null) {
			dp[idx] = 1;

			for (int i = idx - 1; i >= 0; i--) {
				if (num[i] < num[idx]) {
					dp[idx] = Math.max(dp[idx], LIS(i) + 1);
				}
			}
		}

		return dp[idx];
	}

}
