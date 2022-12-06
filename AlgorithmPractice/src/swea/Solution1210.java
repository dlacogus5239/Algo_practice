package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1210 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] ladder = new int[100][100];
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine()); // test_case의 번호
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());

				}
			} // input END

			int x = 0;
			int y = 99;
			for (int j = 0; j < 100; j++) {
				if (ladder[99][j] == 2) {
					x = j;
					break;
				}
			} // 끝나는(목표하는) X좌표 찾기

			while (y != 0) {
				ladder[y][x] = 0; // 방문했던 곳은 0으로

				if (x != 0 && ladder[y][x - 1] == 1) {// 좌
					while (ladder[y][x - 1] == 1) {
						x--;
						ladder[y][x] = 0;
						if (x == 0) {
							break;
						}
					}
				} else if (x != 99 && ladder[y][x + 1] == 1) {// 우
					while (ladder[y][x + 1] == 1) {
						x++;
						ladder[y][x] = 0;
						if (x == 99) {
							break;
						}
					}
				} else if (y != 0 && ladder[y - 1][x] == 1) {
					y--;
					ladder[y][x] = 0;
				}
			}
			System.out.println("#" + test_case + " " + x);

		}
	}

}
