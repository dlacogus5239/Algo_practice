package baekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 7562 나이트의 이동
public class Main7562 {
	static int[] nightMoveX = { -1, 1, -2, 2, -1, 1, -2, 2 };
	static int[] nightMoveY = { -2, -2, -1, -1, 2, 2, 1, 1 };
	static int[] nightFrom;
	static int[] nightTo;
	static boolean[][] isVisited;
	static int board;
	static int[][] chessB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		nightFrom = new int[2];
		nightTo = new int[2];
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			board = Integer.parseInt(st.nextToken());
			chessB = new int[board][board];
			isVisited = new boolean[board][board];
			st = new StringTokenizer(br.readLine());
			nightFrom[0] = Integer.parseInt(st.nextToken()); // 현재 위치 X
			nightFrom[1] = Integer.parseInt(st.nextToken()); // 현재 위치 Y

			st = new StringTokenizer(br.readLine());
			nightTo[0] = Integer.parseInt(st.nextToken()); // 이동할 좌표 X
			nightTo[1] = Integer.parseInt(st.nextToken()); // 이동할 좌표 Y
			bfs();
			System.out.println(chessB[nightTo[1]][nightTo[0]]);
			/*
			 * for (int i = 0; i < board; i++) { for (int j = 0; j < board; j++) {
			 * System.out.print(chessB[i][j] + " "); } System.out.println(); }
			 */
		}
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { nightFrom[0], nightFrom[1] });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (!isVisited[cur[1]][cur[0]]) {
				if (nightTo[0] == cur[0] && nightTo[1] == cur[1]) {
					return;
				}
				isVisited[cur[1]][cur[0]] = true;

				for (int i = 0; i < nightMoveX.length; i++) {
					int next_x = nightMoveX[i] + cur[0];
					int next_y = nightMoveY[i] + cur[1];
					if (!isIn(next_x, next_y, board)) { // 배열 범위 밖이면 검사 X
						continue;
					}
					if (!isVisited[next_y][next_x]) { // 다음 방문지가 방문하지 않은 곳이면
						q.offer(new int[] { next_x, next_y });
						chessB[next_y][next_x] = chessB[cur[1]][cur[0]] + 1;
					}
				}
			}
		}
	}

	public static boolean isIn(int x, int y, int board) { // 배열 밖인지 안인지 검사
		if (x < 0 || y < 0 || x >= board || y >= board) {
			return false;
		} else {
			return true;
		}
	}
}