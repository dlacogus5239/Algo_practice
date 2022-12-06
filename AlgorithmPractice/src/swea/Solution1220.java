package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1220 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // input END
			int result = 0;
			boolean isN = false; // n극을 찾으면,,,
			// N, S의 쌍을 찾으면 된다..
			for (int w = 0; w < N; w++) {
				for (int h = 0; h < N; h++) {
					if (map[h][w] == 1) {
						isN = true;
					}

					if (isN && map[h][w] == 2) {
						result++;
						isN = false;
					}
				}
				isN = false;

			}

			System.out.println("#" + test_case + " " + result);
		}

	}

}
