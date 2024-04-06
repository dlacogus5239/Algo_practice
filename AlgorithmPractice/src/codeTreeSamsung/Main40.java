package codeTreeSamsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main40 {
	static int[][] map;
	static int N;
	static int curCnt;
	static int bombed = 0;
	static int max;
	static boolean[][] isVisited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				curCnt = 0;
				if (isVisited[i][j]) {
					continue;
				}
				DFS(i, j);
				if (curCnt >= 4) {
					bombed++;
				}
				max = Math.max(curCnt, max);
			}
		}
		System.out.printf("%d %d", bombed, max);

	}

	public static void DFS(int r, int c) {
		curCnt++;
		isVisited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (!isIn(nr, nc)) {
				continue;
			}
			if (!isVisited[nr][nc] && map[r][c] == map[nr][nc]) {
				isVisited[nr][nc] = true;
				DFS(nr, nc);

			}

		}
	}

	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= N || c >= N);
	}

}
