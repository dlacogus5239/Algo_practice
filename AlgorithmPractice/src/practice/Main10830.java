package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10830 {
	// 백준 10830 행렬 제곱
	static int N;
	static long B;
	static int[][] cur;
	static final int MOD = 1000;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		cur = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				cur[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}
		br.close();
		// input END

		int[][] result = pow(cur, B);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	// 행렬 곱셈
	public static int[][] multiply(int[][] o1, int[][] o2) {
		int[][] next = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					next[i][j] += o1[i][j2] * o2[j2][j];
					next[i][j] %= MOD;
				}
			}
		}

		return next;
	}

	// 분할정복
	public static int[][] pow(int[][] A, long exp) {
		if (exp == 1L) {
			return A;
		}

		int next[][] = pow(A, exp / 2);

		next = multiply(next, next);

		if (exp % 2 == 1L) {
			next = multiply(next, cur);
		}

		return next;
	}

}
