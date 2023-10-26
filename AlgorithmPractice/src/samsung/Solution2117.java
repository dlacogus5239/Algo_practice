package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2117 {
	// SWEA 2117 홈 방범 서비스

	// 도시 크기, 하나의 집이 지불가능한 비용
	static int N, M;
	static int[][] map;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static boolean[][] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		// test case START
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// input end

			// 비용 산정 후 bfs각각 돌림

			int result = 0;
			int cost = 0;
			int house = 0;
			for (int k = 1; k <= N + 1; k++) {
				// 시작점 설정
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						isVisited = new boolean[N][N];
						// 지금 커버하는 집 수 구함
						house = BFS(j, i, k);
						cost = house * M - ((k * k) + ((k - 1) * (k - 1)));
						if (cost >= 0) {
							result = Math.max(result, house);
						}
					}
				}
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");

		}

		// test case END
		System.out.println(sb.toString());
	}

	// 시작 좌표, 현재 비용
	public static int BFS(int x, int y, int k) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { x, y, k });
		isVisited[y][x] = true;

		int house = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (map[cur[1]][cur[0]] == 1) {
				house++;
			}

			if (cur[2] == 1) {
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (!isIn(nx, ny)) {
					continue;
				}
				if (!isVisited[ny][nx] && cur[2] > 0) {
					q.offer(new int[] { nx, ny, cur[2] - 1 });
					isVisited[ny][nx] = true;

				}
			}

		}

		return house;
	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= N || y >= N);
	}

}
