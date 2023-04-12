package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9252 {
	// 백준 9252 LCS 2
	static char[] s1;
	static char[] s2;
	static String[][] dp;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine().toCharArray();
		s2 = br.readLine().toCharArray();

		dp = new String[s1.length][s2.length];

		String cur;
		cur = LCS(s1.length - 1, s2.length - 1);
		System.out.println(cur.length());
		if (cur.length() == 0) {
			return;
		} else {
			System.out.println(cur);
		}
	}

	public static String LCS(int x, int y) {
		if (x == -1 || y == -1) {
			return "";

		}
		if (dp[x][y] == null) {
			dp[x][y] = "";

			if (s1[x] == s2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + s1[x];

			} else {
				String tmp1 = LCS(x - 1, y);
				String tmp2 = LCS(x, y - 1);

				if (tmp1.length() > tmp2.length()) {
					dp[x][y] = tmp1;
				} else {
					dp[x][y] = tmp2;
				}
			}
		}

		return dp[x][y];

	}

}
