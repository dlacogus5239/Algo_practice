package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1249 {
	// SWEA 1249 보급로

	static int[][] map;
	static int N;
	static int[][] cost;
	static boolean[][][] isVisited;

	static final int INF = 999_999_999;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			cost = new int[N][N];
			map = new int[N][N];
			isVisited = new boolean[N][N][4];

			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
				Arrays.fill(cost[i], INF);
			}
			bfs(0, 0);

			sb.append("#" + test_case + " ").append(cost[N - 1][N - 1]).append("\n");

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(cost[i][j] + " ");
//				}
//				System.out.println();
//			}

		}
		System.out.println(sb.toString());
	}

	public static void bfs(int x, int y) {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			};
		});

		q.offer(new int[] { x, y, 0 });
		cost[y][x] = 0;
		isVisited[y][x][0] = isVisited[y][x][1] = isVisited[y][x][2] = isVisited[y][x][3] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (!isIn(nx, ny)) {
					continue;
				}

				if (!isVisited[ny][nx][d]) {
					isVisited[ny][nx][d] = true;
					int minCost = Math.min(cost[ny][nx], cost[cur[1]][cur[0]] + map[ny][nx]);
					cost[ny][nx] = minCost;
					q.offer(new int[] { nx, ny, minCost });
//					for (int i = 0; i < N; i++) {
//						for (int j = 0; j < N; j++) {
//							System.out.print(cost[i][j] + " ");
//						}
//						System.out.println();
//					}
//					System.out.println("====================");
				}
			}
		}

	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= N || y >= N);
	}

}
