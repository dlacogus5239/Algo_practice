package codeTreeSamsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main41 {
	static int N, K, U, D;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int[] pos;
	static int max = Integer.MIN_VALUE;
	static boolean[][][] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 격자 크기
		K = Integer.parseInt(st.nextToken()); // 고를 도시의 수
		U = Integer.parseInt(st.nextToken()); // U이상
		D = Integer.parseInt(st.nextToken()); // D 이하 (도시간의 높이 차)
		map = new int[N][N];
		pos = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Comb(0, 0);
		System.out.println(max);
	}

	public static void Comb(int start, int cnt) {
		if (cnt == K) {
			isVisited = new boolean[K][N][N];
			for (int i = 0; i < K; i++) {
				BFS(pos[i] / N, pos[i] % N, i);
			}
			boolean[][] total = new boolean[N][N];
			for (int k = 0; k < K; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (isVisited[k][i][j]) {
							total[i][j] = true;
						}
					}
				}
			}

			int cur = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (total[i][j]) {
						cur++;
					}
//					System.out.print(total[i][j] ? 1 + " " : 0 + " ");
				}
//				System.out.println();
			}
//			System.out.println();
			max = Math.max(max, cur);
			return;
		}

		for (int i = start; i < N * N; i++) {
			pos[cnt] = i;
			Comb(i + 1, cnt + 1);
		}
	}

	public static void BFS(int r, int c, int k) {
		Queue<int[]> q = new LinkedList<>();
		isVisited[k][r][c] = true;
		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (!isIn(nr, nc)) {
					continue;
				}
				if (isVisited[k][nr][nc]) {
					continue;
				}
				int tmp = Math.abs(map[cur[0]][cur[1]] - map[nr][nc]);

				if (U <= tmp && tmp <= D) {
					isVisited[k][nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}

			}
		}

		return;
	}

	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= N || c >= N);
	}
}
