package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2239 {
	// 백준 2239 스도쿠
	static int[][] map;
	static ArrayList<int[]> ZeroIdx = new ArrayList<>(); // 비어있는(0) 좌표 [r, c]
	static int len;
	static boolean isDone = false;

	public static void main(String[] args) throws Exception {
		// 0인 좌표 전부 찾아서 저장
		// 이후 DFS로 BackTracking
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			char[] tmp = br.readLine().toCharArray();

			for (int j = 0; j < tmp.length; j++) {
				map[i][j] = (int) (tmp[j] - '0');
				if (map[i][j] == 0) {
					ZeroIdx.add(new int[] { i, j });
				}
			}
		}
		len = ZeroIdx.size();
		if (len == 0) {
			return;
		}
		DFS(0);

//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

	}

	public static void DFS(int idx) {
		// 마지막 0인 좌표까지 탐색 완료
		if (idx == len) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			isDone = true;
			return;
		}

		for (int n = 1; n <= 9; n++) {
			int[] cur = ZeroIdx.get(idx);
			if (CheckBox(cur[0], cur[1], n) && CheckRowCol(cur[0], cur[1], n)) {
				map[cur[0]][cur[1]] = n;
				DFS(idx + 1);
				map[cur[0]][cur[1]] = 0;
				if (isDone) {
					break;
				}
			}
		}

	}

	// 중복검사 --> 지금 넣으려는 수가 조건 충족하는지!
	// 충족하면 True, 충족못하면(겹치면) False
	// 박스 검사
	public static boolean CheckBox(int r, int c, int n) {
		int sR = (r / 3) * 3;
		int sC = (c / 3) * 3;

		for (int i = sR; i < sR + 3; i++) {
			for (int j = sC; j < sC + 3; j++) {
				if (map[i][j] == n) {
					return false;
				}
			}
		}

		return true;
	}

	// 행, 열 검사
	public static boolean CheckRowCol(int r, int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == n || map[i][c] == n) {
				return false;
			}
		}
		return true;
	}

}
