package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7236 {
	static int[] dx = { 0, 0, -1, 1, 1, -1, 1, -1 };
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			char[][] map = new char[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}

			int result = 1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tmp = 0;
					if (map[i][j] == 'W') {

						for (int d = 0; d < dx.length; d++) {
							int next_x = j + dx[d];
							int next_y = i + dy[d];
							if (isIn(next_x, next_y) && map[next_y][next_x] == 'W') {
								tmp++;
							}
						}
						result = Math.max(result, tmp);
					}

				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;

		}
		return true;
	}

}
