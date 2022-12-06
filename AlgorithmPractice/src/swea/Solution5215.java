package swea;

import java.util.Scanner;

public class Solution5215 {
	static int N;
	static int L;
	static int[] ingredient;
	static int[] kcal;
	static boolean[] isSelected;
	static int result;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			ingredient = new int[N];
			kcal = new int[N];
			isSelected = new boolean[N];
			result = -1;
			for (int i = 0; i < N; i++) {
				ingredient[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			generateSubset(0);
			System.out.println("#" + test_case + " " + result);
		}
	}

	public static void generateSubset(int cnt) {
		if (cnt == N) {
			int ingredientSum = 0;
			int kcalSum = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					ingredientSum += ingredient[i];
					kcalSum += kcal[i];
				}
			}
			if(kcalSum > L) {
				return;
			}
			else {
				if(ingredientSum > result) {
					result = ingredientSum;
				}
			}
			return;
		}

		// 선택
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		// 미선택
		isSelected[cnt] = false;
		generateSubset(cnt + 1);

	}
}