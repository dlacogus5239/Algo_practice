package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {
	// 백준 14503 로봇 청소기

	// 맵의 크기
	static int N, M;
	static int[][] map;

	// 방향에 따른 다음 앞칸(0 : 북, 1 : 동, 2 : 남, 3 : 서 )
	// x--> c
	// y--> r
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	// 청소기 위치 (r, c)
	static int[] cleaner = new int[2];
	// 방향
	static int direction;

	// 결과값
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		cleaner[0] = Integer.parseInt(st.nextToken());
		cleaner[1] = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());

		// 1은 벽, 0은 청소 안된 공간, 청소된 공간은 2
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// input END

		// 청소기 동작 START
		// 청소기 동작중이면 참
		boolean flag = true;
		while (flag) {
			// 현재 칸이 청소되어있지 않은 칸이면 청소
			if (map[cleaner[0]][cleaner[1]] == 0) {
				Clean();
			}
			// 주변칸 중에서 청소되지 않은 빈 칸이 없는 경우
			if (isCleaned()) {
				// 후진
				flag = Back();
			} else if (!isCleaned()) {
				// 아니면 전진(회전 포함)
				Forward();
			}
		}

		System.out.println(result);

	}

	// 현재 칸이 청소되지 않은 경우 청소(청소완료는 2로 표시)
	public static void Clean() {
		if (map[cleaner[0]][cleaner[1]] == 0) {
			map[cleaner[0]][cleaner[1]] = 2;
			result++;
		}
		return;
	}

	// 후진
	public static boolean Back() {
		int nr = cleaner[0] - dy[direction];
		int nc = cleaner[1] - dx[direction];

		// 후진할 곳이 벽이면
		if (map[nr][nc] == 1) {
			return false;
		}
		cleaner[0] = nr;
		cleaner[1] = nc;

		return true;
	}

	// 청소기 회전
	public static void Rotate() {
		direction += 3;
		direction %= 4;
		return;
	}

	// 전진
	public static void Forward() {
		Rotate();
		int nr = cleaner[0] + dy[direction];
		int nc = cleaner[1] + dx[direction];
		while (map[nr][nc] != 0) {
			Rotate();
			nr = cleaner[0] + dy[direction];
			nc = cleaner[1] + dx[direction];
		}
		cleaner[0] = nr;
		cleaner[1] = nc;

		return;
	}

	// 주변 4칸이 전부 청소가 되었는지
	public static boolean isCleaned() {
		for (int d = 0; d < 4; d++) {
			int nr = cleaner[0] + dy[d];
			int nc = cleaner[1] + dx[d];
			if (!isIn(nr, nc)) {
				continue;
			}
			if (map[nr][nc] == 0) {
				return false;
			}
		}
		return true;
	}

	// 맵 안인지
	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= N || c >= M);
	}

}
