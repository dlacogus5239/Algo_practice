package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 7579 앱
public class Main7579 {
	static int N, M;
	static int[] memory; // 앱의 메모리 크기
	static int[] cost; // 비활성화 비용

	static int[][] dp; // dp[앱의 개수][비용] = 확보되는 메모리?

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N 앱 개수
		M = Integer.parseInt(st.nextToken()); // M (바이트)의 메모리 확보를 앱 비활성화 최소의 비용

		memory = new int[N];
		cost = new int[N];
		// cost 하나의 최대의 값은 100, 앱의 개수는 총 100 ==> 100 * 100 --> 최댓값 10000
		dp = new int[N + 1][10001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		// input END
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {

			int curMemory = memory[i];
			int curCost = cost[i];

			for (int j = 0; j <= 10000; j++) {
				if (i == 0) {
					if (j >= curCost) {
						dp[i][j] = curMemory;
					}
				} else {
					if (j >= curCost) {
						dp[i][j] = Math.max(dp[i - 1][j - curCost] + curMemory, dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}

				if (dp[i][j] >= M) {
					result = Math.min(result, j);
				}
			}

		}

		System.out.println(result);

	}

}