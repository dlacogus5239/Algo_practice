package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5644 {
	// SWEA 5644무선 충전

	// 이동시간
	static int M;
	// BC의 개수
	static int A;

	// 이동 0 -> A. 1 -> B
	static int[][] Move;

	// map
	static boolean[][][] map;

	// 이동(상우하좌)
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	// 결과값
	static int result;

	static class BC implements Comparable<BC> {
		int x, y;
		// 충전 범위
		int C;
		// 충전양
		int P;

		BC(int x, int y, int C, int P) {
			this.x = x;
			this.y = y;
			this.C = C;
			this.P = P;
		}

		// 내림차순 정렬
		@Override
		public int compareTo(BC o) {
			return o.P - this.P;
		}
	}

	static BC[] Chargers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		// TEST CASE START
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			Move = new int[2][M];

			// 이동정보 저장
			for (int i = 0; i < M; i++) {
				Move[0][i] = Integer.parseInt(st.nextToken());
				Move[1][i] = Integer.parseInt(st2.nextToken());
			}

			Chargers = new BC[A];

			map = new boolean[10][10][A];

			// 결과값 초기화
			result = 0;

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				Chargers[i] = new BC(x - 1, y - 1, C, P);

			}
			// 충전양 내림차순
			Arrays.sort(Chargers);
			// 충전가능한 부분 입력
			CanCharge();

			// 충전기 파트 확인
//			for (int i = 0; i < 10; i++) {
//				for (int j = 0; j < 10; j++) {
//					boolean flag = false;
//					for (int k = 0; k < A; k++) {
//						if (map[i][j][k]) {
//							System.out.print("o ");
//							flag = true;
//							break;
//						}
//					}
//					if (!flag) {
//						System.out.print("- ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println();

			Solve();

			sb.append("#").append(t).append(" ").append(result).append("\n");

		}
		// TEST CASE END

		System.out.println(sb.toString());
	}

	// map에 충전 가능한 충전기 입력
	public static void CanCharge() {

		for (int c = 0; c < A; c++) {
			BC cur = Chargers[c];

			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { cur.x, cur.y, cur.C });
			map[cur.y][cur.x][c] = true;
			while (!q.isEmpty()) {
				int[] tmp = q.poll();

				for (int d = 1; d < 5; d++) {
					int nx = tmp[0] + dx[d];
					int ny = tmp[1] + dy[d];
					int curC = tmp[2];
					if (!isIn(nx, ny)) {
						continue;
					}
					map[ny][nx][c] = true;

					if (curC - 1 == 0) {
						continue;
					} else {
						q.offer(new int[] { nx, ny, curC - 1 });
					}
				}
			}
		}

	}

	// 사용자 이동, 계산
	public static void Solve() {
		// 처음 위치
		int[] personA = { 0, 0 };
		int[] personB = { 9, 9 };

		int time = 0;
		// 이동 시간만큼 반복
		while (time <= M) {
			ArrayList<Integer> canChargeA = new ArrayList<>();
			ArrayList<Integer> canChargeB = new ArrayList<>();

			// 충전가능한 충전기 검사
			for (int i = 0; i < A; i++) {
				// 충전 가능한 위치면
				if (map[personA[1]][personA[0]][i]) {
					canChargeA.add(i);
				}
				if (map[personB[1]][personB[0]][i]) {
					canChargeB.add(i);
				}
			}

			int max = 0;
			int tmp;
			// 충전기 계산
			if (canChargeA.size() > 0 && canChargeB.size() > 0) {
				for (int a : canChargeA) {
					for (int b : canChargeB) {
						tmp = 0;
						if (a == b) {
							tmp = Chargers[a].P;
						} else {
							tmp += Chargers[a].P;
							tmp += Chargers[b].P;
						}
						max = Math.max(max, tmp);
					}
				}
			} else if (canChargeA.size() > 0) {
				for (int a : canChargeA) {
					if (max < Chargers[a].P) {
						max = Chargers[a].P;
					}
				}
			} else if (canChargeB.size() > 0) {
				for (int b : canChargeB) {
					if (max < Chargers[b].P) {
						max = Chargers[b].P;
					}
				}
			}
//			System.out.println("===" + time + "===");
//			System.out.println(max);

			result += max;

			if (time == M) {
				break;
			}

			// 다음 위치

			personA[0] += dx[Move[0][time]];
			personA[1] += dy[Move[0][time]];

			personB[0] += dx[Move[1][time]];
			personB[1] += dy[Move[1][time]];
			time++;
		}
		// 시간 종료
	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= 10 || y >= 10);
	}

}
