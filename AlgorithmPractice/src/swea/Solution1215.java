package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1215 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			char[][] map = new char[8][8];

			for (int i = 0; i < 8; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (i <= 8 - N) {
						int tmp = 0;
						for (int i2 = 0; i2 < N; i2++) {
							// x축에 대해서
							if (map[i + i2][j] != map[i + (N - i2 - 1)][j]) {
								break;
							} else {
								tmp++;
							}
						}
						if (tmp == N) {
							result++;
						}
					}
					if (j <= 8 - N) {
						int tmp = 0;
						for (int j2 = 0; j2 < N; j2++) {
							// y축에 대해서
							if (map[i][j + j2] != map[i][j + (N - j2 - 1)]) {
								break;
							} else {
								tmp++;
							}
						}
						if (tmp == N) {
							result++;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

}
