package swea;

import java.util.Scanner;

public class Solution2001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int size = sc.nextInt();
			int area = sc.nextInt();
			int[][] ary = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					ary[i][j] = sc.nextInt();
				}
			}
			// 배열 입력 END
			int max = -1;
			// 순회하면서 탐색
			for (int i = 0; i <= size - area; i++) {
				for (int j = 0; j <= size - area; j++) {
					int sum = 0;
					for (int dx = 0; dx < area; dx++) {
						for (int dy = 0; dy < area; dy++) {
							sum += ary[i + dx][j + dy];
							if (sum >= max) {
								max = sum;
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + max);

		}
	}

}
