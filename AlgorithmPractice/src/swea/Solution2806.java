package swea;

import java.util.Scanner;

public class Solution2806 {
	static int N;
	static int[] col; // 열의 위치값을 저장하는 배열 --> col[행 번호] = 열의 값 --> col[4] = 3; --> 4행 3열 (3, 4)
	static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			col = new int[N + 1]; // 0 index는 생각하지 않기로 하자
			result = 0;
			setQueen(1);

			System.out.println("#" + test_case + " " + result);
		}
	}

	static void setQueen(int row) { // 젤 위쪽 row 부터 차례대로 내려온다.

		if (!isPromising(row - 1)) { // 이전 행의 queen과 겹치지 않게 놓아졌는지 검사
			return;
		}
		if (row > N) {
			result++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			col[row] = i;

			setQueen(row + 1);
		}

	}

	static boolean isPromising(int row) {
		for (int i = 1; i < row; i++) {
			if (col[row] == col[i]) {
				// 같은 줄
				return false;
			}
			if (row - i == Math.abs(col[row] - col[i])) {
				// 대각선
				return false;
			}
		}

		return true;
	}

}
