package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1261 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N, M;
	static int[][] map;

	static int[][] weights;
	static final int INF = 999_999_999;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M + 1][N + 1];
		weights = new int[M + 1][N + 1];
		for (int i = 1; i < M + 1; i++) {
			Arrays.fill(weights[i], INF);
		}
		for (int i = 1; i <= M; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				map[i][j] = (int) tmp[j - 1] - '0';
			}
		}

		BFS();
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(weights[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(weights[M][N]);

	}

	public static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 1, 1 });
		weights[1][1] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curWeight = 0;

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				curWeight = weights[cur[0]][cur[1]];
				if (!isIn(nr, nc)) {
					continue;
				}
//				System.out.println("nr : " + nr);
//				System.out.println("nc : " + nc);

				if (map[nr][nc] == 1) {
					curWeight += 1;
				}

				if (weights[nr][nc] > curWeight) {
					weights[nr][nc] = curWeight;
					q.offer(new int[] { nr, nc });
				}
			}
		}

	}

	public static boolean isIn(int r, int c) {
		return !(r <= 0 || c <= 0 || r > M || c > N);
	}

}
