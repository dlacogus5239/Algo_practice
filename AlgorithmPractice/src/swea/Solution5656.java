package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution5656 {
	// SWEA 벽돌 깨기
	// map 크기
	static int W, H;
	// 구슬 떨어뜨리는 횟수
	static int N;

	// 벽돌 정보
	static int[][] map;

	// 현재 단계에서 계산을 위한 map 설정
	static int[][] curMap;

	// 움직임 정보
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	// 중복 순열을 저장할 배열
	static int[] choosen;

	// 최솟값 저장
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		// test case START
		for (int t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// input END / testCase

			choosen = new int[N];
			copyMap();
			BackTracking(0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		// test case END
		System.out.println(sb.toString());
	}

	// 벽 부수는거 백트래킹으로 계산
	// 구슬 던지는 횟수
	// 순열을 만든 다음에 Map 계산
	public static void BackTracking(int cnt) {
		// 구슬 던지는 횟수 모두 사용시
		if (cnt == N) {

			Break();
			int tmp = CountMap();
			result = Math.min(tmp, result);
			copyMap();
			return;
		}

		for (int i = 0; i < W; i++) {
			choosen[cnt] = i;
			BackTracking(cnt + 1);
		}

	}

	// 벽돌 부수기
	public static void Break() {

		// 구슬을 떨어뜨릴 위치 저장한 배열 탐색
		for (int i = 0; i < choosen.length; i++) {
			Queue<int[]> q = new LinkedList<>();

			// 맨 위 벽돌을 찾아내고 queue에 넣어준다
			for (int h = 0; h < H; h++) {
				if (curMap[h][choosen[i]] != 0) {
					// x, y 좌표와 터뜨리는 개수 curMap[h][i]
					q.offer(new int[] { choosen[i], h, curMap[h][choosen[i]] });
					curMap[h][choosen[i]] = 0;
					break;
				}
			}

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				// 현재 칸 0으로 만듬

				// 4방향 탐색
				for (int d = 0; d < 4; d++) {
					// 떠드리는 개수 만큼 반복
					for (int a = 1; a < cur[2]; a++) {
						int nx = dx[d] * a + cur[0];
						int ny = dy[d] * a + cur[1];

						// 배열 밖이면 계산 스킵
						if (!isIn(nx, ny)) {
							continue;
						}
						// 벽돌이면 부수기 진행
						if (curMap[ny][nx] != 0) {
							q.offer(new int[] { nx, ny, curMap[ny][nx] });
							curMap[ny][nx] = 0;
						}

					}
				}
			}

			// 구슬 한번 떨어뜨리고 연쇄된 작업 처리 후 별돌 아래로 내려주기
			Down();

		}
		return;
	}

	// 벽돌 내리기
	public static void Down() {
		// 아래서부터 0이 아닌 부분 찾아서
		// 스택에 저장하고
		// 아래서부터 스택에서 꺼내서 저장

		Stack<Integer> s = new Stack<>();
		for (int w = 0; w < W; w++) {
			for (int h = 0; h < H; h++) {
				if (curMap[h][w] != 0) {
					s.add(curMap[h][w]);
				}
			}
			// 아래서 부터 쌓아주자
			for (int h = H - 1; h >= 0; h--) {
				// 스택이 비었으면 다 내린거니까 0 저장
				if (s.isEmpty()) {
					curMap[h][w] = 0;
				} else {
					curMap[h][w] = s.pop();
				}
			}
		}

		return;

	}

	public static int CountMap() {
		int res = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (curMap[i][j] != 0) {
					res++;
				}
//				System.out.print(curMap[i][j] + " ");
			}
//			System.out.println();
		}
		return res;
	}

	// 맵 안인지
	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= W || y >= H);
	}
	// 정적 메소드는 프로그램 실행 시에 메모리에 먼저 올라가때문에
	// 복사에서 문제가 생김 --> 초기 상태가 복사됨
	// 현재 입력한 값으로 복사해주자

	public static void copyMap() {
		curMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				curMap[i][j] = map[i][j];
			}
		}
	}

}
