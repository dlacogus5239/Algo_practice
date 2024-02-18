package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987 {
	static int R, C;
	static char[][] map;

	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 4방향에 대한 방문체크
	static boolean[] isVisited;
	static int result = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// input END
		isVisited = new boolean[26];

		boolean[] Alpha = new boolean[26];
		DFS(0, 0, 0);
		System.out.println(result);

	}

	public static void DFS(int r, int c, int cnt) {
		if (isVisited[parseInteger(map[r][c])]) {
			result = Math.max(cnt, result);
			return;
		} else {
			isVisited[parseInteger(map[r][c])] = true;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (isIn(nr, nc)) {
					DFS(nr, nc, cnt + 1);
				}
			}
			isVisited[parseInteger(map[r][c])] = false;
		}
	}

	public static int parseInteger(char c) {
		return (int) (c - 'A');
	}

	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= R || c >= C);
	}

}
