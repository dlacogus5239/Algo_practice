package dynamicProgramming;

import java.util.Scanner;

public class Main2193 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] one = new int[N + 1];
		int[] zero = new int[N + 1];

		one[1] = 1;
		zero[1] = 0;

//		one[2] = 0;
//		zero[2] = 1;

		for (int i = 2; i <= N; i++) {
			one[i] = zero[i - 1];
			zero[i] = one[i - 1] + zero[i - 1];
		}

		System.out.println(one[N] + zero[N]);
	}

}
