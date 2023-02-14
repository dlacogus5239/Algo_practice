package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206_NOTSOLVED0214 {
	// 백준 2206 벽 부수고 이동하기
	static int N, M;
	static int[][] map;
	static int[][][] moveCnt;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][][] isVisited;

	public static void main(String[] args) throws IOException, NumberFormatException {
		int answer = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		moveCnt = new int[N + 1][M + 1][2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				Arrays.fill(moveCnt[i][j], 999_999_999);
			}
		}
		moveCnt[1][1][0] = 1;
		moveCnt[1][1][1] = 1;
		isVisited = new boolean[N + 1][M + 1][2];

		for (int i = 1; i <= N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(tmp[j - 1]);
			}
		}
		bfs();

		answer = Math.min(moveCnt[N][M][0], moveCnt[N][M][1]);
		answer = answer == 999_999_999 ? -1 : answer;
		System.out.println(answer);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(moveCnt[i][j][0] + " ");
			}
			System.out.println();
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(moveCnt[i][j][1] + " ");
			}
			System.out.println();
		}
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();

		// 마지막은 벽을 부쉈는지 (0 이면 안부숨, 1 이면 부숨)
		q.offer(new int[] { 1, 1, 0 });
		isVisited[1][1][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				int destroyFlag = cur[2];
				if (!isIn(nx, ny)) {
					continue;
				}
				if (map[ny][nx] == 1) {
					if (destroyFlag == 0 && !isVisited[ny][nx][1]) {
						isVisited[ny][nx][destroyFlag] = true;
						moveCnt[ny][nx][destroyFlag] = Math.min(moveCnt[ny][nx][destroyFlag],
								moveCnt[cur[1]][cur[0]][destroyFlag] + 1);
//						moveCnt[ny][nx][destroyFlag] = moveCnt[cur[1]][cur[0]][destroyFlag] + 1;
						q.offer(new int[] { nx, ny, 1 });
					}
				} else {
					if (!isVisited[ny][nx][destroyFlag]) {
						isVisited[ny][nx][destroyFlag] = true;
						moveCnt[ny][nx][destroyFlag] = Math.min(moveCnt[ny][nx][destroyFlag],
								moveCnt[cur[1]][cur[0]][destroyFlag] + 1);
//						moveCnt[ny][nx][destroyFlag] = moveCnt[cur[1]][cur[0]][destroyFlag] + 1;
						q.offer(new int[] { nx, ny, destroyFlag });
					}
				}

			}
		}

	}

	public static boolean isIn(int x, int y) {
		if (x <= 0 || y <= 0 || x > M || y > N) {
			return false;
		}
		return true;
	}

}
