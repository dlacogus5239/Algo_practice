package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13172 {
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;

		long N = 1, S = 0;

		// 기댓값 합 구하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			// 각 분모와 분자를 통분하여 계산
			S = s * N + S * n;
			N *= n;
			// 모듈러 산술로 인하여 나머지 계산
			S %= MOD;
			N %= MOD;
		}
		StringBuilder sb = new StringBuilder();
		// 기약분수 일 때
		if (S % N != 0) {
			sb.append(Search(N, MOD - 2) * S % MOD);
		} else {
			sb.append(S / N);
		}
		System.out.println(sb.toString());
	}

	public static long Search(long N, int idx) {
		if (idx == 1) {
			return N;
		}
		long tmp = Search(N, idx / 2);
		if (idx % 2 == 1) {
			return tmp * tmp % MOD * N % MOD;
		} else {
			return tmp * tmp % MOD;
		}
	}

}
