package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {
	// 백준 1074 Z

	static int cnt = 0;

	// r, c가 몇 사분면인지 찾아서
	// 앞에 count한건 따로 하나하나 증가시키지 말고 더해주자
	static int R, C;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N;
		N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		br.close();

		partition(0, 0, N);

		System.out.println(cnt);

	}

	public static void partition(int r, int c, int size) {
		if (size == 1) {
			return;
		}

		int newSize = size / 2;

		if (R < r + newSize && C < c + newSize) {
			partition(r, c, newSize);
		}
		if (R < r + newSize && c + newSize <= C) {
			cnt += (size * size) / 4;
			partition(r, c + newSize, newSize);
		}
		if (r + newSize <= R && C < c + newSize) {
			cnt += ((size * size) / 4) * 2;
			partition(r + newSize, c, newSize);
		}
		if (r + newSize <= R && c + newSize <= C) {
			cnt += ((size * size) / 4) * 3;
			partition(r + newSize, c + newSize, newSize);
		}

	}

}
