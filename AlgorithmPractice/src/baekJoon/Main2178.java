package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
	// 백준 21778 미로 탐색
	static int N, M;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] distance;
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		distance = new int[N + 1][M + 1];
		isVisited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String[] cur = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(cur[j - 1]);
			}
		}
		br.close();
		// input END
		for (int i = 1; i <= N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		distance[1][1] = 0;
		bfs(1, 1);

		System.out.println(distance[N][M] + 1);

	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == M && cur[1] == N) {
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (!isIn(nx, ny)) {
					continue;
				}
				if (map[ny][nx] == 0 || isVisited[ny][nx]) {
					continue;
				}
				distance[ny][nx] = Math.min(distance[ny][nx], distance[cur[1]][cur[0]] + 1);
				q.offer(new int[] { nx, ny });
				isVisited[ny][nx] = true;
			}
		}
	}

	// 배열 안인지 판단
	public static boolean isIn(int x, int y) {
		return !(x <= 0 || y <= 0 || x > M || y > N);
	}

}
