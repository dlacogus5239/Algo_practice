package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14940 {
	static int N, M;
	static int[][] map;
	static int[][] distance;
	static boolean[][] isVisited;
	static int[] start;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		distance = new int[N][M];
		isVisited = new boolean[N][M];
		start = new int[2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start[0] = j;
					start[1] = i;
				}
			}
		}
		bfs();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					sb.append("0").append(" ");
					continue;
				}
				sb.append(isVisited[i][j] ? distance[i][j] : "-1").append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { start[0], start[1] });
		isVisited[start[1]][start[0]] = true;
		distance[start[1]][start[0]] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (!isIn(nx, ny) || isVisited[ny][nx]) {
					continue;
				}
				if (map[ny][nx] == 0) {
					continue;
				}
				distance[ny][nx] = distance[cur[1]][cur[0]] + 1;
				isVisited[ny][nx] = true;
				q.offer(new int[] { nx, ny });
			}
		}
	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= M || y >= N);
	}

}
