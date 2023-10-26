package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1953 {
	// SWEA 1953 탈주범 검거
	// 세로, 가로, 맨홀뚜껑 세로, 가로, 탈출 후 소요된 시간
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] isVisited;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			isVisited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			BFS();

			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (isVisited[i][j]) {
						result++;
					}
//					System.out.print(isVisited[i][j] ? 1 : 0);
//					System.out.print(" ");
				}
			}

			sb.append("#").append(t + " ").append(result).append("\n");
		}

		System.out.println(sb.toString());
	}

	// 파이프 연결 안될때 추가하기 !
	public static void BFS() {
		q = new LinkedList<>();
		q.offer(new int[] { C, R, L });
		isVisited[R][C] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			isVisited[cur[1]][cur[0]] = true;

			switch (map[cur[1]][cur[0]]) {
			// 1번 움직임
			case 1:
				MoveUp(cur[0], cur[1], cur[2]);
				MoveDown(cur[0], cur[1], cur[2]);
				MoveRight(cur[0], cur[1], cur[2]);
				MoveLeft(cur[0], cur[1], cur[2]);
				break;
			// 2번 움직임
			case 2:
				MoveUp(cur[0], cur[1], cur[2]);
				MoveDown(cur[0], cur[1], cur[2]);
				break;
			// 3번 움직임
			case 3:
				MoveRight(cur[0], cur[1], cur[2]);
				MoveLeft(cur[0], cur[1], cur[2]);
				break;
			// 4번 움직임
			case 4:
				MoveUp(cur[0], cur[1], cur[2]);
				MoveRight(cur[0], cur[1], cur[2]);
				break;
			// 5번 움직임
			case 5:
				MoveDown(cur[0], cur[1], cur[2]);
				MoveRight(cur[0], cur[1], cur[2]);
				break;
			// 6번 움직임
			case 6:
				MoveDown(cur[0], cur[1], cur[2]);
				MoveLeft(cur[0], cur[1], cur[2]);
				break;
			case 7:
				MoveUp(cur[0], cur[1], cur[2]);
				MoveLeft(cur[0], cur[1], cur[2]);
				break;
			}
		}
	}

	public static void MoveUp(int x, int y, int move) {
		int nx = x;
		int ny = y - 1;
		if (isIn(nx, ny) && move > 1) {
			if (map[ny][nx] != 3 && map[ny][nx] != 4 && map[ny][nx] != 7) {
				if (map[ny][nx] != 0 && !isVisited[ny][nx]) {
					isVisited[ny][nx] = true;
					q.offer(new int[] { nx, ny, move - 1 });
				}
			}
		}

	}

	public static void MoveDown(int x, int y, int move) {
		int nx = x;
		int ny = y + 1;
		if (isIn(nx, ny) && move > 1) {
			if (map[ny][nx] != 3 && map[ny][nx] != 5 && map[ny][nx] != 6) {
				if (map[ny][nx] != 0 && !isVisited[ny][nx]) {
					isVisited[ny][nx] = true;
					q.offer(new int[] { nx, ny, move - 1 });
				}
			}
		}

	}

	public static void MoveLeft(int x, int y, int move) {
		int nx = x - 1;
		int ny = y;
		if (isIn(nx, ny) && move > 1) {
			if (map[ny][nx] != 2 && map[ny][nx] != 6 && map[ny][nx] != 7) {
				if (map[ny][nx] != 0 && !isVisited[ny][nx]) {
					isVisited[ny][nx] = true;
					q.offer(new int[] { nx, ny, move - 1 });
				}
			}
		}

	}

	public static void MoveRight(int x, int y, int move) {
		int nx = x + 1;
		int ny = y;
		if (isIn(nx, ny) && move > 1) {
			if (map[ny][nx] != 2 && map[ny][nx] != 4 && map[ny][nx] != 5) {
				if (map[ny][nx] != 0 && !isVisited[ny][nx]) {
					isVisited[ny][nx] = true;
					q.offer(new int[] { nx, ny, move - 1 });
				}
			}
		}

	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= M || y >= N);
	}

}
