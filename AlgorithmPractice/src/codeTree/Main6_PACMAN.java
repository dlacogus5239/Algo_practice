package codeTree;

import java.util.ArrayList;

public class Main6_PACMAN {
	static class Monster {
		int r, c;
		int direction;

	}

	static class Egg extends Monster {
		int turn;

	}

	static class DeadBody extends Monster {
		int turn;

	}

	static class Pacman {
		int r, c;

		public Pacman(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pacman [r=" + r + ", c=" + c + "]";
		}

	}

	// 이동 방향 (12시 방향부터 반시계방향)
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

	// 팩맨 Move (상좌하우 우선순위)
	static int[] drPac = { -1, 0, 1, 0 };
	static int[] dcPac = { 0, -1, 0, 1 };

	static ArrayList<Monster> Monsters = new ArrayList<>(); // 몬스터 저장
	static ArrayList<Egg> Eggs = new ArrayList<>(); // 알 저장
	static ArrayList<DeadBody> Deads = new ArrayList<>(); // 시체 저장

	public static void main(String[] args) throws Exception {
		MakePacMovement(0);
		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(pacMove[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 팩맨 움직임 만드는 함수 DONE
	static int COUNT = 0;
	static int[][] pacMove = new int[64][3];
	static int[] tmp = new int[3];

	public static void MakePacMovement(int cnt) {
		if (cnt == 3) {

			for (int i = 0; i < 3; i++) {
				pacMove[COUNT][i] = tmp[i];
			}
			COUNT++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			tmp[cnt] = i;
			MakePacMovement(cnt + 1);
		}

	}
	// 팩맨 움직임 만드는 함수 DONE

	public static boolean isIn(int r, int c) {
		return !(r <= 0 || c <= 0 || r > 4 || c > 4);
	}

}
