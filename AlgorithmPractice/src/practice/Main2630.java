package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2630 {
	// 백준 2630 색종이 만들기
	static int N;
	static int[][] map;
	static int white = 0, blue = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		// input END
		partition(0, 0, N);

		System.out.println(white);
		System.out.println(blue);
	}

	// 나누기
	public static void partition(int row, int col, int size) {
		if (check(row, col, size)) {
			if (map[row][col] == 0) {
				white++;
			} else {
				blue++;
			}

			return;
		}

		// 한 색종이를 4개로 나눈다.
		// 함수평면 생각했을 때

		// 제 2사분면
		partition(row, col, size / 2);

		// 제 1사분면
		partition(row, col + size / 2, size / 2);

		// 제 3사분면
		partition(row + size / 2, col, size / 2);

		// 제 4사분면
		partition(row + size / 2, col + size / 2, size / 2);
	}

	// 범위 내가 같은 색종이인지 판단
	public static boolean check(int row, int col, int size) {
		// 같은 색인지 판단하기 위한 변수
		int wb = map[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (wb != map[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

}
