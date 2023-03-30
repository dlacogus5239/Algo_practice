package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992 {
	// 백준 1992 쿼드트리
	static int N;
	static int[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		br.close();

		// input END

		partition(0, 0, N);

		System.out.println(sb.toString());
	}

	public static void partition(int row, int col, int size) {

		if (check(row, col, size)) {
			sb.append(map[col][row]);
		} else {
			sb.append("(");
			partition(row, col, size / 2);
			partition(row + size / 2, col, size / 2);
			partition(row, col + size / 2, size / 2);
			partition(row + size / 2, col + size / 2, size / 2);
			sb.append(")");
		}

	}

	public static boolean check(int row, int col, int size) {
		int cur = map[col][row];
		for (int i = col; i < col + size; i++) {
			for (int j = row; j < row + size; j++) {
				if (map[i][j] != cur) {
					return false;
				}
			}
		}

		return true;
	}

}
