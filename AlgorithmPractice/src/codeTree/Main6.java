package codeTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main6 {
	// 상하좌우 대각선..?
	// 대각선 (12시부터 시계 반대방향)
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

	// 상좌하우(우선순위 순)
	static int[] p_dr = { -1, 0, 1, 0 };
	static int[] p_dc = { 0, -1, 0, 1 };

	// 팩맨
	static class Monster {
		int direction;

		public Monster(int direction) {
			super();
			this.direction = direction;
		}

		@Override
		public String toString() {
			return "Monster [direction=" + direction + "]";
		}

	}

	// 2턴이 지난 후 부화
	static class Egg extends Monster {
		int turn;

		public Egg(int direction) {
			super(direction);
			this.turn = 2;
		}

	}

	// 2턴 지난 후 사라짐
	static class Dead extends Monster {
		int turn;

		public Dead(int direction) {
			super(direction);
			this.turn = 2;
		}
	}

	static class Pacman {
		int r;
		int c;

		public Pacman(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	// 맵은 (1, 1) ~ (4, 4)
	// 큐로 구현해보자.,,

	// 현재 몬스터 맵
	static ArrayList<Monster>[][] MonsterMap = new ArrayList[5][5];
	// 알 있는 맵
	static ArrayList<Egg>[][] EggMap = new ArrayList[5][5];
	// 시체 있는 맵
	static ArrayList<Dead>[][] DeadMap = new ArrayList[5][5];

	static Pacman Pacman;
	// 몬스터 수 M, 턴 수 T
	static int M, T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		Pacman = new Pacman(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		// MAPS INIT START
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				MonsterMap[i][j] = new ArrayList<>();
				EggMap[i][j] = new ArrayList<>();
				DeadMap[i][j] = new ArrayList<>();
			}
		}
		// MAPS INIT END

		// Monster INPUT START
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 방향은 1부터 12시방향... -1해서 입력 받기
			int direction = Integer.parseInt(st.nextToken()) - 1;
			MonsterMap[r][c].add(new Monster(direction));
		}
		// Monster INPUT END

		// INPUT END

		// Turn START

		MakeMovePac(0);
		TryDuplicateMonster();
		MoveMonster();
//		MovePacman();

		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				System.out.print(MonsterMap[i][j].toString() + " ");
			}
			System.out.println();
		}

	}

	// 복제 시도
	public static void TryDuplicateMonster() {
		// 알 생성
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (MonsterMap[i][j].size() != 0) {
					for (int m = 0; m < MonsterMap[i][j].size(); m++) {
						Monster cur = MonsterMap[i][j].get(m);
						EggMap[i][j].add(new Egg(cur.direction));
					}
				}
			}
		}
	}

	// 몬스터 이동
	public static void MoveMonster() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (MonsterMap[i][j].size() != 0) {
					int len = MonsterMap[i][j].size();
					for (int m = 0; m < len; m++) {
						Monster cur = MonsterMap[i][j].get(m);
						int nDirection = cur.direction;
						boolean flag = false;
						// 갈 수 있는 방향 찾기(360회전)
						for (int d = 0; d < 8; d++) {
							nDirection = (nDirection + d) % 8;
							int nr = i + dr[nDirection];
							int nc = j + dc[nDirection];
							if (!isIn(nr, nc)) {
								continue;
							}
							if (DeadMap[nr][nc].size() != 0 || (Pacman.r == nr && Pacman.c == nc)) {
								continue;
							} else {
								flag = true;
								cur.direction = nDirection;
								MonsterMap[nr][nc].add(new Monster(nDirection));
								MonsterMap[i][j].remove(m);
								break;
							}
						}
						if (!flag) {
							continue;
						}

					}
				}
			}
		}
	}

	// 팩맨 움직임 총 64개 만들기
	static int COUNT = 0;
	static int[][] pacMove = new int[64][3];
	static int[] tmpMove = new int[3];

	public static void MakeMovePac(int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < 3; i++) {
				pacMove[COUNT][i] = tmpMove[i];
			}
			COUNT++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			tmpMove[cnt] = i;
			MakeMovePac(cnt + 1);
		}
	}

	// MakeMovePac에서 움직임 다 만들었다. 이걸로 움직이자
	public static void MovePacman() {

		int idx = 0;
		int eatenMonster = 0;
		int result = 0;

		// 최대 방향 결정
		// 우선순위가 높은거 부터 탐색.
		for (int i = 0; i < 64; i++) {
			eatenMonster = 0;
			int curR = Pacman.r;
			int curC = Pacman.c;
			int nr = curR;
			int nc = curC;
			for (int j = 0; j < 3; j++) {
				nr += dr[pacMove[i][j]];
				nc += dc[pacMove[i][j]];
				if (!isIn(nr, nc)) {
					break;
				}
				if (MonsterMap[nr][nc].size() != 0) {
					eatenMonster += MonsterMap[nr][nc].size();
				}
			}
			if (eatenMonster > result) {
				idx = i;
				result = eatenMonster;
			}
		}

		// 방향 결정하고 삭제 과정
		int nr = Pacman.r;
		int nc = Pacman.c;
		for (int i = 0; i < 3; i++) {
			nr += dr[pacMove[idx][i]];
			nc += dc[pacMove[idx][i]];
			if (MonsterMap[nr][nc].size() != 0) {
				int len = MonsterMap[nr][nc].size();
				for (int j = 0; j < len; j++) {
					Monster cur = MonsterMap[nr][nc].get(j);
					DeadMap[nr][nc].add(new Dead(cur.direction));
					MonsterMap[nr][nc].remove(j);
				}
			}
		}

	}

	// 격자 안인지 판별
	public static boolean isIn(int r, int c) {
		return !(r <= 0 || c <= 0 || r >= 5 || c >= 5);
	}

}
