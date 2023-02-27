package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9251 {
	// 백준 9251 LCS
	// https://st-lab.tistory.com/139
	static char[] s1;
	static char[] s2;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine().toCharArray();
		s2 = br.readLine().toCharArray();

		dp = new Integer[s1.length][s2.length];

		System.out.println(LCS(s1.length - 1, s2.length - 1));
	}

	public static int LCS(int x, int y) {
		// 인덱스 밖이면 0반환
		if (x == -1 || y == -1) {
			return 0;
		}
		// 탐색하지 않았으면
		if (dp[x][y] == null) {
			// 탐색처리
			dp[x][y] = 0;

			// 첫번째 문자열의 x번째와
			// 두번째 문자열의 y번째가 같으면
			if (s1[x] == s2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			} else {
				// 다르면 dp[x-1][y]와 dp[x][y-1]중 큰 값으로 초기화 시켜준다
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}

		return dp[x][y];
	}
}
