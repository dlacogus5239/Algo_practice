package swea;


import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution2805 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int size = Integer.parseInt(sc.next());
			int[][] farm = new int[size][size];
			int sum = 0;
			for (int i = 0; i < size; i++) {
				String tmp = sc.next();
				for (int j = 0; j < size; j++) {
					farm[i][j] = (int) (tmp.charAt(j) - '0');
				}
			}
			// 배열에 저장 END
			
			// 계산 (윗부분)
			for (int i = 0; i < size / 2; i++) {
				for (int j = size / 2 - i; j <= size / 2 + i; j++) {
					sum += farm[i][j];
				}
			}

			// 아래
			for (int i = size / 2; i >= 0; i--) {
				for (int j = size / 2 - i; j <= size / 2 + i; j++) {
					sum += farm[size - i - 1][j];
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}