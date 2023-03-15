package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17144 {
	// 백준 17144 미세먼지 안녕!
	// R, C -> map 크기
	// T -> T 초가 흐른 뒤의 미세먼지의 양
	static int R, C, T;
	static int[][] map;
	static int[][] nextMap;
	static int[] airCleaner = new int[2];

	// 확산 방향. 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					// 공기 청정기는 항상 0번 row에 존재
					// 공기 청정기 위쪽 좌표
					airCleaner[0] = i - 1;
					// 아래쪽 좌표
					airCleaner[1] = i;
				}
			}
		}
		br.close();

		for (int t = 0; t < T; t++) {
			nextMap = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0 || map[i][j] != -1) {
						Spread(j, i);
					}
				}
			}
			map = nextMap.clone();
			Circulation();
		}

//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 미세먼지 합산
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) {
					result += map[i][j];
				}
			}
		}
		// 결과
		System.out.println(result);
	}

	// 미세먼지 확산
	// nextMap 에 값 저장 후 map으로 옮겨주기
	// END
	public static void Spread(int x, int y) {
		int cnt = 0;
		// 인접한 네 방향으로 확산

		for (int d = 0; d < 4; d++) {
			int nx = dx[d] + x;
			int ny = dy[d] + y;
			// 칸이 없으면 확산 X
			if (!isIn(nx, ny)) {
				continue;
			}
			// 공기청정기 쪽으로 확산되면 없애기
			if (map[ny][nx] == -1) {
				continue;
			}
			cnt++;

			// 확산되는 양은 map[y][x] / 5
			nextMap[ny][nx] = nextMap[ny][nx] + map[y][x] / 5;

		}
		// 남은 양은 map[y][x] - (map[y][x] / 5) * 확산된 방향수
		nextMap[y][x] = map[y][x] - (map[y][x] / 5) * cnt + nextMap[y][x];
	}

	// 공기 순환
	public static void Circulation() {
		// 바람 반시계방향으로 순환
		// 바람 방향으로 비세먼지 이동
		// airCleaner[0] : 위쪽 좌표
		// airCleaner[1] : 아래쪽 좌표

		for (int i = airCleaner[0] - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int i = airCleaner[1] + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}

		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
			map[R - 1][i] = map[R - 1][i + 1];
		}

		for (int i = 0; i < airCleaner[0]; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = R - 1; i > airCleaner[1]; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}

		for (int i = C - 1; i > 1; i--) {
			map[airCleaner[0]][i] = map[airCleaner[0]][i - 1];
			map[airCleaner[1]][i] = map[airCleaner[1]][i - 1];
		}
		map[airCleaner[0]][1] = 0;
		map[airCleaner[1]][1] = 0;
	}

	// 배열 범위 안인지
	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= C || y >= R);
	}

}
