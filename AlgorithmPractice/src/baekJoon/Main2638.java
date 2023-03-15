package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2638 {
	// 백준 2638 치즈
	static int N, M;
	// 바깥은 2
	// 안은 0
	// 치즈 1
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int totalCheese = 0;
	static int result = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					totalCheese++;
				}
			}
		}
		br.close();
		// input END
		bfs_outSide();

		while (totalCheese != 0) {
			isVisited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						del_Cheese(j, i);
					}
				}
			}
			bfs_outSide();
			result++;
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(result);
	}

	public static void bfs_outSide() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		map[0][0] = 2;
		isVisited[0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (!isIn(nx, ny)) {
					continue;
				}
				if (map[ny][nx] != 1 && !isVisited[ny][nx]) {
					map[ny][nx] = 2;
					q.add(new int[] { nx, ny });
					isVisited[ny][nx] = true;
				}

			}
		}
	}

	public static void del_Cheese(int x, int y) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (!isIn(nx, ny)) {
				continue;
			}
			if (map[ny][nx] == 2) {
				cnt++;
			}
		}

		if (cnt >= 2) {
			map[y][x] = 0;
			totalCheese--;
		}
	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= M || y >= N);
	}

}
