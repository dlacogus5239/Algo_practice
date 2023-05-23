package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution2819 {
	// SWEA 격자판의 숫자 이어 붙이기
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static HashSet<Integer> set;
	static String[][] map;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			set = new HashSet<>();
			map = new String[4][4];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = st.nextToken();
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(0, new int[] { j, i }, "");
				}
			}

			sb.append("#" + t).append(" ").append(set.size()).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void dfs(int cnt, int[] cur, String num) {
		if (cnt == 7) {
			set.add(Integer.parseInt(num));
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = cur[0] + dx[d];
			int ny = cur[1] + dy[d];
			if (!isIn(nx, ny)) {
				continue;
			}

			dfs(cnt + 1, new int[] { nx, ny }, num + map[ny][nx]);

		}

	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= 4 || y >= 4);
	}

}
