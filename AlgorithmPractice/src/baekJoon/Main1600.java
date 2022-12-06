package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600 {
	static int[] hDx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hDy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int K; // 말처럼 움직일 수 있는 횟수
	static int W;
	static int H; // 높이, 너비

	static int[][] map;
	static boolean[][][] isVisited;

	static class Move {
		int x;
		int y;
		int move; // 총 이동 횟수
		int moveK; // 말처럼 움직인 횟수

		Move(int x, int y, int move, int moveK) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.moveK = moveK;
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];

		// x, y, 좌표와 말처럼 이동한 횟수 저장. --> 다른 경로 저장하기 위함
		isVisited = new boolean[H][W][31];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// move 초기화
			}
		}
		// input END

		// (0, 0) ~> (W-1, H-1)
		int result = bfs(0, 0);

		// 끝 지점까지 이동 할 수 없으면 -1 출력
		System.out.println(result);
	}

	public static int bfs(int x, int y) {
		Queue<Move> q = new LinkedList<Move>();
		q.offer(new Move(0, 0, 0, 0));
		while (!q.isEmpty()) {
			Move cur = q.poll();

			if (cur.x == W - 1 && cur.y == H - 1) {
				return cur.move;
			}

			for (int d = 0; d < 4; d++) {
				int next_x = cur.x + dx[d];
				int next_y = cur.y + dy[d];
				if (isIn(next_x, next_y) && map[next_y][next_x] == 0 && !isVisited[next_y][next_x][cur.moveK]) {
					q.offer(new Move(next_x, next_y, cur.move + 1, cur.moveK));
					isVisited[next_y][next_x][cur.moveK] = true;
				}
			}

			if (cur.moveK >= K) {
				continue;
			}
			for (int d = 0; d < 8; d++) {
				int next_x = cur.x + hDx[d];
				int next_y = cur.y + hDy[d];
				if (isIn(next_x, next_y) && map[next_y][next_x] == 0 && !isVisited[next_y][next_x][cur.moveK + 1]) {
					q.offer(new Move(next_x, next_y, cur.move + 1, cur.moveK + 1));
					isVisited[next_y][next_x][cur.moveK + 1] = true;
				}
			}
		}
		return -1;

	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= W || y >= H) {
			return false;
		}
		return true;
	}

}