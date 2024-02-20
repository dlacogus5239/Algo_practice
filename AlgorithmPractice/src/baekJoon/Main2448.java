package baekJoon;

import java.util.Scanner;

public class Main2448 {
	static final String[] star = { "  *  ", " * * ", "*****" };
	static String[] map;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// input END

		map = new String[N];
		map[0] = star[0];
		map[1] = star[1];
		map[2] = star[2];
		for (int k = 1; 3 * (int) Math.pow(2, k) <= N; ++k) {
			DrawStar(k);
		}

		for (int i = 0; i < N; i++) {
			System.out.println(map[i]);
		}

	}

	public static void DrawStar(int cnt) {
		int bottom = 3 * (int) Math.pow(2, cnt);

		int mid = bottom / 2;
		for (int i = mid; i < bottom; ++i) {
			map[i] = map[i - mid] + " " + map[i - mid];
		}
		String empty = "";
		while (empty.length() < mid) {
			empty += " ";
		}

		for (int i = 0; i < mid; ++i) {
			map[i] = empty + map[i] + empty;
		}

	}

}
