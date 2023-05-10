package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11444 {
	// 백준 11444 피보나치 수 6
	// https://st-lab.tistory.com/252
	// 이분 정리 진짜 펄풱...

	static long N;
	static final long MOD = 1000000007L;
	public static long[][] origin = { { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		long[][] A = { { 1, 1 }, { 1, 0 } };

		System.out.println(pow(A, N - 1)[0][0]);
	}

	// 행렬 제곱 분할정복
	public static long[][] pow(long[][] A, long exp) {
		if (exp == 1 || exp == 0) {
			return A;
		}

		long[][] result = pow(A, exp / 2);

		result = multiply(result, result);

		if (exp % 2 == 1L) {
			result = multiply(result, origin);
		}

		return result;
	}

	// 행렬 곱셈
	public static long[][] multiply(long[][] o1, long[][] o2) {
		long[][] result = new long[2][2];

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					result[i][j] += o1[i][k] * o2[k][j];
					result[i][j] %= MOD;
				}
			}
		}

		return result;
	}

}
