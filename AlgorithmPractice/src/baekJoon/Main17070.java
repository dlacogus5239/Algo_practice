package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17070 {
	// 백준 17070 파이프 옮기기
	static int N;
	static int[][] map;
	static int result = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// input END

		// 가로 : 0
		// 세로 : 1
		// 대각선 : 2

		dfs(1, 2, 0);

		System.out.println(result);

	}

	public static void dfs(int x, int y, int state) {
		if (x == N && y == N) {
			result++;
			return;
		}

		switch (state) {
		case 0:
			if (y + 1 <= N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
			break;
		case 1:
			if (x + 1 <= N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
			break;
		case 2:
			if (x + 1 <= N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
			if (y + 1 <= N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
			break;

		}

		if (y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
			dfs(x + 1, y + 1, 2);
		}
	}

	public static boolean isIn(int x, int y) {
		return (x <= 0 || y <= 0 || x > N || y < N);
	}

}
