package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206 {
	// 백준 2206 벽 부수고 이동하기
	static int N, M;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][][] isVisited;
	static int[][] map;

	static class Point {
		int x, y;
		int distance;
		int destroy;

		public Point(int x, int y, int distance, int destroy) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.destroy = destroy;
		}

	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		int answer = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		isVisited = new boolean[N + 1][M + 1][2];

		for (int i = 1; i <= N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(tmp[j - 1]);
			}
		}

		answer = bfs();

		System.out.println(answer);
	}

	public static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(1, 1, 1, 0));
		isVisited[1][1][0] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.x == M && cur.y == N) {
				return cur.distance;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (!isIn(nx, ny)) {
					continue;
				}

				// 벽이 아닐때
				if (map[ny][nx] == 0) {
					if (!isVisited[ny][nx][cur.destroy]) {
						q.offer(new Point(nx, ny, cur.distance + 1, cur.destroy));
						isVisited[ny][nx][cur.destroy] = true;
					}
				}

				// 벽일때
				if (map[ny][nx] == 1) {
					if (cur.destroy == 0) {
						q.offer(new Point(nx, ny, cur.distance + 1, 1));
						isVisited[ny][nx][1] = true;
					} else if (!isVisited[ny][nx][cur.destroy]) {
						continue;
					}
				}
			}
		}
		return -1;

	}

	public static boolean isIn(int x, int y) {
		if (x <= 0 || y <= 0 || x > M || y > N) {
			return false;
		}
		return true;
	}

}
