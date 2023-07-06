package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main3190 {
	// 백준 3190 뱀
	// 보드 크기, 사과 개수, 뱀의 방향 변환 횟수
	static int N, K, L;
	static int[][] map;

	// 이동 좌표 변화값( 상, 우, 하, 좌)
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	// 현재 방향 저장(처음은 오른쪽으로 진행중)
	static int direction = 1;

	public static class Snake {
		int x, y;

		Snake(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			Snake s = (Snake) o;
			return x == s.x && y == s.y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		// 뱀 정보
		Deque<Snake> snake = new ArrayDeque<>();

		// map[y좌표][x좌표]
		map = new int[N + 1][N + 1];
		StringTokenizer st;

		// 사과 정보 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			// 사과가 위치한 칸은 1로 표시
			map[row][col] = 1;
		}

		L = Integer.parseInt(br.readLine());
		// 명령어 입력
		int[] time = new int[L];
		String[] dir = new String[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			dir[i] = st.nextToken();
		}
		br.close();
		// input END

		// 뱀 처음 위치
		snake.offer(new Snake(1, 1));
		// 처음 시간
		int curTime = 1;
		// idx번째 명령어
		int idx = 0;

		// 처음 명령어 입력
		int nextTime = time[idx];
		String nextDir = dir[idx];

		while (curTime <= 10000) {
			Snake cur = snake.peekFirst();
			// 다음 Head 위치
			int nx = cur.x + dx[direction];
			int ny = cur.y + dy[direction];
//			System.out.println(nx + ", " + ny);
			// 보드 바깥이면 종료
			if (!isIn(nx, ny)) {
				System.out.println(curTime);
				break;
			}
			// 다음 위치가 몸통 포함이면 탈출
			if (snake.contains(new Snake(nx, ny))) {
				System.out.println(curTime);
				break;
			}
			// 몸을 늘려서 다음칸에 위치
			snake.offerFirst(new Snake(nx, ny));

			// 사과가 있을 경우
			if (map[ny][nx] == 1) {
				// 사과 없앰
				map[ny][nx] = 0;
			}
			// 사과가 없을 경우
			else {
				// 꼬리를 비워준다
				snake.pollLast();
			}

			// 시간이 X초 뒤면
			if (curTime == nextTime) {
				if (nextDir.equals("D")) {
					// 오른쪽 방향
					direction = (direction + 1) % 4;
				} else {
					// 왼쪽 방향
					direction = (direction + 3) % 4;
				}

				// 다음 명령어 저장
				idx++;
				if(idx < L) {
//					System.out.println(curTime);
//					System.out.println(idx);
					nextTime = time[idx];
					nextDir = dir[idx];
				}
			}
			// 다음시간
			curTime++;

		}

	}

	public static boolean isIn(int x, int y) {
		return !(x < 1 || y < 1 || x > N || y > N);
	}

}
