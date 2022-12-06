package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1261 알고스팟
public class Main1261 {
	// 다익스트라
	static int[][] map;
	static int N, M;
	static int[][] cost;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		// input END
		cost = new int[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		bfs();
		System.out.println(cost[M - 1][N - 1]);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { 0, 0 });
		cost[0][0] = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int next_x = cur[0] + dx[d];
				int next_y = cur[1] + dy[d];
				if (isIn(next_x, next_y)) {
					if (map[next_y][next_x] == 1 && cost[next_y][next_x] > cost[cur[1]][cur[0]] + 1) {
						cost[next_y][next_x] = cost[cur[1]][cur[0]] + 1;
						q.offer(new int[] { next_x, next_y });
					} else if (map[next_y][next_x] == 0 && cost[next_y][next_x] > cost[cur[1]][cur[0]]) {
						cost[next_y][next_x] = cost[cur[1]][cur[0]];
						q.offer(new int[] { next_x, next_y });
					}
				}
			}
		}
	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= M) {
			return false;
		}
		return true;
	}

}