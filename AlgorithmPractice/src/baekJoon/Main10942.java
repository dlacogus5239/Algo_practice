package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10942 {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N + 1][N + 1];
		// 길이 1 일때 --> 전부 팰린드롬
		for (int i = 1; i <= N; i++) {
			dp[i][i] = 1;
		}
		// 길이 2 일때 --> 두개가 똑같으면 팰린드롬
		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i + 1]) {
				dp[i][i + 1] = 1;
			} else {
				dp[i][i + 1] = 0;
			}
		}
		// 길이 3 이상일때
		// 길이 3부터 dp구함

		// 안쪽(s + 1, e - 1)이 팰린드롬 && 양 끝이 같을때
		for (int len = 2; len < N; len++) {
			for (int s = 1; s <= N - len; s++) {
				int e = s + len;
//				System.out.println("[" + s + ", " + e + "]");
//				System.out.println(dp[s + 1][e - 1]);
				if (dp[s + 1][e - 1] == 1 && arr[s] == arr[e]) {
					dp[s][e] = 1;
				} else {
					dp[s][e] = 0;
				}
			}
		}

		// 출력용
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(dp[S][E]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
