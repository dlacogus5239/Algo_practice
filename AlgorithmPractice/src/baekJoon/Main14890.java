package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890 {
	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 지도 크기
		L = Integer.parseInt(st.nextToken()); // 경사로의 길이

		map = new int[N][N];

		// 초기화

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// input END
		int resultRoad = 0; // 결과괎 --> 길의 개수

		// 길은 행, 열 한줄 통과 가능하면 길이다

		for (int i = 0; i < N; i++) {
			// 0 : 가로 검사
			// 1 : 세로 검사
			if (makeRoad(0, i, 1)) {
				resultRoad++;
			}
			if (makeRoad(i, 0, 0)) {
				resultRoad++;
			}
		}

		System.out.println(resultRoad);
	}

	public static boolean isIn(int x) {
		if (x < 0 || x >= N) {
			return false;
		}
		return true;
	}

	public static boolean makeRoad(int x, int y, int ColOrRow) {
		boolean[] isRoad = new boolean[N]; // 경사로가 놓였나 안놓였나??
		int[] curMap = new int[N];
		if (ColOrRow == 0) {
			for (int i = 0; i < N; i++) {
				curMap[i] = map[i][x];
			}
		} else {
			for (int i = 0; i < N; i++) {
				curMap[i] = map[y][i];
			}
		}

		for (int i = 0; i < N - 1; i++) {
			// 높이가 모두 같으면 계속 continue 돼서 결국 true 반환
			if (curMap[i] == curMap[i + 1]) {
				continue;
			}
			// 차이가 1 초과로 날 경우
			if (curMap[i] - curMap[i + 1] > 1 || curMap[i] - curMap[i + 1] < -1) {
				return false;
			}

			// 내려가는 경우
			if (curMap[i] - 1 == curMap[i + 1]) {
				for (int r = i + 1; r <= i + L; r++) {
					if (!isIn(r)) { // 범위 밖
						return false;
					}
					if (isRoad[r]) { // 경사로가 이미 놓여져 있는 경우
						return false;
					}
					if (curMap[r] != curMap[i + 1]) { // 평평하지 않은 경우
						return false;
					}

					isRoad[r] = true;
				}
			}
			// 올라가는 경우
			else if (curMap[i] + 1 == curMap[i + 1]) {
				for (int r = i; r > i - L; r--) {
					if (!isIn(r)) { // 범위 밖
						return false;
					}
					if (isRoad[r]) { // 경사로가 이미 놓여져 있는 경우
						return false;
					}
					if (curMap[r] != curMap[i]) { // 평평하지 않은 경우
						return false;
					}

					isRoad[r] = true;
				}
			}
		}

		return true;
	}

}