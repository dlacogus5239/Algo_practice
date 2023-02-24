package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 개중요 
public class Main9663 {
	// 백준 9663 N-Queen
	static int N;
	static int[] map;
	static int cnt = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// map[i] = j --> (i, j)에 Queen이 놓임을 의미.
		map = new int[N];
		nQueen(0);

		System.out.println(cnt);

	}

	public static void nQueen(int d) {
		if (d == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			map[d] = i;
			if (Possibility(d)) {
				nQueen(d + 1);
			}
		}

	}

	public static boolean Possibility(int row) {
		for (int i = 0; i < row; i++) {
			// 같은 행에 놓임을 의미
			if (map[row] == map[i]) {
				return false;
			}
			// 대각선에 놓임을 의미
			else if (Math.abs(row - i) == Math.abs(map[row] - map[i])) {
				return false;
			}
		}
		return true;
	}

}
