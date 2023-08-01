package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {
	// 백준 14503 로봇 청소기
	// 방 크기
	static int N, M;

	// 이동방향
	// 북 : 0, 동 : 1, 남 : 2, 서 : 3
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int direction;
	static int[][] map;
	static int cleanerX, cleanerY;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 청소안됨 : 0, 청소함 -1, 벽 : 1
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		cleanerX = Integer.parseInt(st.nextToken());
		cleanerY = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Activate();
		System.out.println(result);

	}

	// map 안인지
	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= M || y >= N);
	}

	// 로봇청소기 동작
	public static void Activate() {
		while (true) {
			// 현재 칸이 청소되지 않은 경우 현재 칸 청소
			if (map[cleanerY][cleanerX] == 0) {
				map[cleanerY][cleanerX] = -1;
				result++;
			}

			// 4방향 청소안된 곳 체크
			boolean isClean = true;
			for (int d = 0; d < 4; d++) {
				int nx = dx[d] + cleanerX;
				int ny = dy[d] + cleanerY;
				if (!isIn(nx, ny) || map[ny][nx] == 1) {
					continue;
				}

				if (map[ny][nx] == 0) {
					isClean = false;
					break;
				}
			}

			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			if (isClean) {
				int nx = cleanerX - dx[direction];
				int ny = cleanerY - dy[direction];
				// 바라보는 방향 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다
				if (!isIn(nx, ny) || map[ny][nx] == 1) {
					break;
				}

				// 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다
				cleanerX = nx;
				cleanerY = ny;
				continue;
			}

			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			if (!isClean) {
				for (int i = 0; i < 4; i++) {
					// 반시계 방향으로 회전
					direction = (direction + 3) % 4;
					// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
					int nx = cleanerX + dx[direction];
					int ny = cleanerY + dy[direction];
					if (isIn(nx, ny) && map[ny][nx] == 0) {
						cleanerX = nx;
						cleanerY = ny;
						// 1번으로 돌아간다
						break;

					}
				}
			}
		}

	}

}
