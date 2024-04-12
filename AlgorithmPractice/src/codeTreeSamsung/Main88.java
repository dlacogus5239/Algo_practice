package codeTreeSamsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main88 {
	static int N, M, H, K; // 격자 크기, 도망자, 나무 수, 턴 수
	static boolean[][] treeMap; // 나무 있으면 True
	static final int VIEW = 3; // 술래의 시야

	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 현재 턴
	static int turn = 0;

	static class Person {
		int r, c;
		int dir;
		boolean isCatched;

		public Person(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.isCatched = false;
		}

		@Override
		public String toString() {
			return "Person [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

	}

	static Person Catcher;
	static int CatcherMove = 0; // CatcherMove 0 - N * N -> 안쪽에서 달팽이, N * N - 1-> 바깥쪽에서 달팽이
	static int CatcherCurMove, CatcherCurChangeDir, CatcherCurNext; // 현재 움직인 칸 수, 방향을 바꾼 횟수, 움직여야 하는 칸 수
	static boolean CatcherClockWise = true;
	static ArrayList<Person> Runners = new ArrayList<>();
	static ArrayList<Integer>[][] map;
	static int score = 0;

	static int[][] CatcherMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Catcher = new Person(N / 2, N / 2, 0);
		CatcherMap = new int[N][N];
		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		treeMap = new boolean[N][N];

		// Catcher Init
		CatcherCurMove = 0;
		CatcherCurChangeDir = 0;
		CatcherCurNext = 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			// 1은 좌우, 2는 상하
			// 좌 먼저, 하 먼저
			int dir = Integer.parseInt(st.nextToken());
			Runners.add(new Person(r, c, dir));
		}

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			treeMap[r][c] = true;
		}

		for (int i = 1; i <= K; i++) {
//			System.out.println("BEFORE : " + Catcher.toString());
			turn = i;
			RunnerMove();
			CatcherMove();
			CatcherMap[Catcher.r][Catcher.c] = i;
//			System.out.println("AFTER : " + Catcher.toString());
		}

//		for (int i = 0; i < N * N * 2 + 1; i++) {
//			CatcherMap[Catcher.r][Catcher.c] = i + 1;
//			CatcherMove();
//		}
//		PrintMap();
		System.out.println(score);
	}

	public static void RunnerMove() {
		// map 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j].clear();
			}
		}

//		System.out.println("TURN : " + turn);
		for (int i = 0; i < Runners.size(); i++) {
			Person cur = Runners.get(i);
			// 잡힌 도망자는 제거
			if (cur.isCatched) {
				Runners.remove(i);
				// size 가 줄어드니까 i--
				i--;
				continue;
				// 거리가 3 이하인 도망자만 움직인다
			} else if (calcDistance(cur.r, cur.c, Catcher.r, Catcher.c) <= 3) {
				int nr = cur.r + dr[cur.dir];
				int nc = cur.c + dc[cur.dir];
				if (!isIn(nr, nc)) {
					cur.dir ^= 2; // 반대방향 전환
					nr = cur.r + dr[cur.dir]; // 전환한 방향으로 이동
					nc = cur.c + dc[cur.dir];
				}

				// 술래가 없으면 이동
				if (!(Catcher.r == nr && Catcher.c == nc)) {
					cur.r = nr;
					cur.c = nc;
				}

			}
			// 현재 리스트에서 몇번째 도망자가 있는지 기록
			map[cur.r][cur.c].add(i);
		}

	}

	public static void CatchRunner() {
		int curR = Catcher.r;
		int curC = Catcher.c;
		int cnt = 0;
		for (int v = 0; v < VIEW; v++) {
			int nr = curR + v * dr[Catcher.dir];
			int nc = curC + v * dc[Catcher.dir];
			if (!isIn(nr, nc)) {
				continue;
			}
			if (map[nr][nc].size() != 0) {
				if (!treeMap[nr][nc]) {
					cnt += map[nr][nc].size();
					// map에 기록되어있는 도망자들 isCatched = true처리
					for (int i = 0; i < map[nr][nc].size(); i++) {
						Runners.get(map[nr][nc].get(i)).isCatched = true;
					}
				}
			}
		}

		score += cnt * turn;
	}

	public static void PrintMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(CatcherMap[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void CatcherMove() {
		Catcher.r += dr[Catcher.dir];
		Catcher.c += dc[Catcher.dir];
		CatcherCurMove++;
		// 다움직인 거면 방향 전환
		if (CatcherCurMove == CatcherCurNext) {
			if (CatcherClockWise) { // 안쪽에서 이동
				// 방향 전환
				Catcher.dir = (Catcher.dir + 1) % 4;
				CatcherCurChangeDir++; // 방향 전환 횟수 증가
				if (CatcherCurChangeDir == 2) { // 두번 방향 전환했으면
					// 가야하는 거리 추가
					CatcherCurNext++;
					CatcherCurChangeDir = 0;
				}

			} else { // 바깥쪽에서 이동
				Catcher.dir = (Catcher.dir + 3) % 4;
				CatcherCurChangeDir++;
				if (CatcherCurChangeDir == 2) {
					CatcherCurNext--;
					CatcherCurChangeDir = 0;
				}
			}

			CatcherCurMove = 0; // 현재 이동한 거리 초기화

		}

		CatcherMove++;
		// N * N -1만큼 이동했으면 방향 틀어주기(바로 틀어줘야 하니까)
		if (CatcherMove == N * N - 1) {

			CatcherMove = 0;
			CatcherCurMove = 0;

			// init
			if (CatcherClockWise) {
				CatcherClockWise = false;
				Catcher.dir = 2;
				Catcher.r = 0;
				Catcher.c = 0;
				CatcherCurNext = N - 1;
				CatcherCurChangeDir = -1;
			} else {
				CatcherClockWise = true;
				Catcher.dir = 0;
				Catcher.r = N / 2;
				Catcher.c = N / 2;
				CatcherCurNext = 1;
				CatcherCurChangeDir = 0;
			}
		}
		// 도망자 잡기
		CatchRunner();
	}

	// 거리 계산
	public static int calcDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= N || c >= N);
	}

}
