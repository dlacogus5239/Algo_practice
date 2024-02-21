package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main21736 {
	static char[][] map;
	static int N, M;
	static int answer;
	static boolean[][] isVisited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		isVisited = new boolean[N][M];
		int[] Doyeon = new int[2];
		for (int i = 0; i < N; i++) {
			char[] cur = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				// 도윤이 처음 좌표
				if (cur[j] == 'I') {
					Doyeon[0] = i;
					Doyeon[1] = j;
				}
				map[i][j] = cur[j];
			}
		}

		// input END

		answer = 0;

		BFS(Doyeon[0], Doyeon[1]);

		System.out.println(answer == 0 ? "TT" : answer);
	}

	public static void BFS(int r, int c) {
		isVisited[r][c] = true;
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!isIn(nr, nc)) {
					continue;
				}
				if (!isVisited[nr][nc] && map[nr][nc] != 'X') {
					isVisited[nr][nc] = true;
					if (map[nr][nc] == 'P') {
						answer++;
					}
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= N || c >= M);
	}

}
