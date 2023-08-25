package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5648 {

	static int tCase, N, MAX = 4001;
	static int[][] visited;
	static boolean[][] collapse;
	static Node[] atoms;
	static int[] dirX = new int[] { 1, -1, 0, 0 };
	static int[] dirY = new int[] { 0, 0, -1, 1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {

		tCase = Integer.parseInt(br.readLine());
		collapse = new boolean[MAX][MAX];
		visited = new int[MAX][MAX];

		for (int t = 1; t <= tCase; t++) {

			N = Integer.parseInt(br.readLine());

			atoms = new Node[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				atoms[i] = new Node((row + 1000) * 2, (col + 1000) * 2, dir, power);
				visited[atoms[i].row][atoms[i].col] = 1;
			}
			int ans = solve();
			System.out.println("#" + t + " " + ans);
		}
	}

	public static int solve() {

		int numOfAtom = N;
		int ans = 0;

		for (int j = 0; j < MAX + 5; j++) {
			// 원자들을 이동시킴
			for (int i = 0; i < numOfAtom; i++) {

				// 이동시키기 전
				int row = atoms[i].row;
				int col = atoms[i].col;
				int dir = atoms[i].dir;
				visited[row][col] -= 1;

				// 이동시키기
				if (isBoundary(row + dirX[dir], col + dirY[dir])) {
					row += dirX[dir];
					col += dirY[dir];
					atoms[i].row = row;
					atoms[i].col = col;
					visited[row][col] += 1;

					if (visited[row][col] >= 2)
						collapse[row][col] = true;

				} else {
					// 좌표를 벗어나는 원자들을 제거한다.
					atoms[i] = atoms[numOfAtom - 1];
					numOfAtom--;
					i--;
				}
			}

			// 원자들의 충돌여부 확인
			for (int i = 0; i < numOfAtom; i++) {

				int row = atoms[i].row;
				int col = atoms[i].col;

				if (collapse[row][col] == true) {

					if (visited[row][col] == 1)
						collapse[row][col] = false;

					ans += atoms[i].power;
					visited[row][col] -= 1;
					atoms[i] = atoms[numOfAtom - 1];
					numOfAtom--;
					i--;
				}
			}
			if (numOfAtom == 0)
				break;
		}
		return ans;
	}

	public static boolean isBoundary(int row, int col) {
		return (row >= 0 && row < MAX) && (col >= 0 && col < MAX);
	}
}

class Node {
	int row;
	int col;
	int dir;
	int power;

	public Node(int row, int col, int dir, int power) {
		this.row = row;
		this.col = col;
		this.dir = dir;
		this.power = power;
	}

}