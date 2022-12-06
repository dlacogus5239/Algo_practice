package swea;

import java.util.Scanner;

public class Solution1954 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		Solution1954 s = new Solution1954();
		int size = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			size = sc.nextInt();
			int[][] ary = new int[size][size];
			int cnt = 1;
			int[] dx = { 1, 0, -1, 0 };
			int[] dy = { 0, 1, 0, -1 };
			int x = 0;
			int y = 0;
			int[] move = { 0, 1, 2, 3 };
			int d = 0;
			while (cnt <= size * size) {
				int next_x = x + dx[move[d]];
				int next_y = y + dy[move[d]];
				if (next_x < 0 || next_y < 0 || next_x >= size || next_y >= size || ary[next_y][next_x] != 0) {
					d = (d + 1) % 4;
					next_x = x + dx[move[d]];
					next_y = y + dy[move[d]];
				}
				ary[y][x] = cnt;
				cnt ++;
				x = next_x;
				y = next_y;
			}
            System.out.println("#" + test_case);
			for (int i = 0; i < ary.length; i++) {
				for (int j = 0; j < ary.length; j++) {
					System.out.print(ary[i][j] + " ");
				}
				System.out.println();
			}
		}
	}


}
