package codeTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main6 {
	// 12, 11, 9, 7, 6, 5, 3, 2
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static public class Monster {
		int r, c;
		int direction;

		public Monster(int r, int c, int direction) {
			super();
			this.r = r;
			this.c = c;
			this.direction = direction;
		}

	}

	static public class Egg extends Monster {
		int turn;

		public Egg(int r, int c, int direction) {
			super(r, c, direction);
			this.turn = 1;
		}

	}

	static public class Pacman {
		int r, c;

		public Pacman(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int[][] map;
	// 몬스터 수
	static int M;
	static ArrayList<Monster> monsters;
	static ArrayList<Egg> eggs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T;
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		// pacman init
		st = new StringTokenizer(br.readLine());
		Pacman Pacam = new Pacman(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		// map init
		map = new int[4][4];

		// Monster INPUT
		monsters = new ArrayList<>();
		eggs = new ArrayList<>();
		for (int i = 0; i < args.length; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken()) - 1;
			monsters.add(new Monster(r, c, direction));
		}

	}

	// 몬스터 복제 시도
	public static void CopyMonster() {
		// 알 복제
		for (Monster m : monsters) {
			eggs.add(new Egg(m.r, m.c, m.direction));
		}
	}

	// 몬스터 이동
	public static void MoveMonster() {
		for (Monster m : monsters) {
			int nr = m.r + dr[m.direction];
			int nc = m.c + dc[m.direction];
			int nextDirection = m.direction;
			if (!isIn(nr, nc)) {
				nextDirection = (nextDirection + 1) % 8;
			}
		}
	}

	// 팩맨 이동

	// 몬스터 시체 소멸

	// 몬스터 복제 완성
	public static void AwakeEgg() {
		for (Egg e : eggs) {
			monsters.add(new Monster(e.r, e.c, e.direction));
		}
		eggs.clear();
	}

	// 격자 안인지
	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= 4 || c >= 4);
	}

}
