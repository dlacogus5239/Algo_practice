package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1018 {
	// 백준 1018 체스판 다시 칠하기
	static int N, M;
	static boolean[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp[j] == 'B' ? true : false;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int tmp = changeCount(j, i);
				min = Math.min(tmp, min);
			}
		}

		System.out.println(min);

	}

	public static int changeCount(int x, int y) {
		int cnt = 0;

		int endX = x + 8;
		int endY = y + 8;

		boolean BW = board[y][x];
		if (!isIn(endX - 1, endY - 1)) {
			return Integer.MAX_VALUE;
		}
		for (int i = y; i < endY; i++) {
			for (int j = x; j < endX; j++) {
				if (board[i][j] != BW) {
					cnt++;
				}
				BW = !BW;
			}
			BW = !BW;
		}
		cnt = Math.min(cnt, 64 - cnt);

		return cnt;
	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= M || y >= N);
	}

}
