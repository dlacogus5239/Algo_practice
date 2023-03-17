package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7569 {
	// 백준 7569 토마토
	static int M, N, H;
	static int[][][] map;
	static boolean[][][] isVisited;
	static Queue<int[]> q = new LinkedList<>();

	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		isVisited = new boolean[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < M; j2++) {
					map[i][j][j2] = Integer.parseInt(st.nextToken());
					if (map[i][j][j2] == 1) {
						q.offer(new int[] { j2, j, i });
					}

				}
			}
		}
		br.close();
		// input END

		bfs();
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (map[i][j][j2] == 0) {
						System.out.println("-1");
						return;
					}
					result = Math.max(result, map[i][j][j2]);
				}
			}
		}

		if (result == 1) {
			System.out.println("0");
			return;
		}
		System.out.println(result - 1);

	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 6; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				int nz = cur[2] + dz[d];

				if (!isIn(nx, ny, nz)) {
					continue;
				}
				if (map[nz][ny][nx] == 0) {
					q.offer(new int[] { nx, ny, nz });
					map[nz][ny][nx] = map[cur[2]][cur[1]][cur[0]] + 1;
				}

			}
		}
	}

	public static boolean isIn(int x, int y, int z) {
		return !(x < 0 || y < 0 || z < 0 || x >= M || y >= N || z >= H);
	}

}
