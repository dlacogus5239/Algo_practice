package algoPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1261 {
	// 백준 1261 알고스팟
	static int N, M;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[][] cost;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[M + 1][N + 1];
		cost = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			String[] cur = br.readLine().split("");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(cur[j - 1]);
			}
		}

		for (int i = 0; i < M; i++) {
			Arrays.fill(cost[i + 1], Integer.MAX_VALUE);
		}

		bfs();

		System.out.println(cost[M][N]);

	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { 1, 1 });
		cost[1][1] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (!isIn(nx, ny)) {
					continue;
				}

				if (map[ny][nx] == 0 && cost[ny][nx] > cost[cur[1]][cur[0]]) {
					cost[ny][nx] = cost[cur[1]][cur[0]];
					q.offer(new int[] { nx, ny });
				} else if (map[ny][nx] == 1 && cost[ny][nx] > cost[cur[1]][cur[0]] + 1) {
					cost[ny][nx] = cost[cur[1]][cur[0]] + 1;
					q.offer(new int[] { nx, ny });
				}

			}
		}

	}

	// Is next x, y in map?
	public static boolean isIn(int x, int y) {
		return !(x <= 0 || y <= 0 || x > N || y > M);
	}

}
