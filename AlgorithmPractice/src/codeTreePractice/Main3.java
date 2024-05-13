package codeTreePractice;

import java.util.Scanner;

public class Main3 {
	static int[] isChoosen;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		isChoosen = new int[N];
		Perm(1, 0);

		System.out.println(sb.toString());
	}

	public static void Perm(int start, int cnt) {
		if (cnt == N) {
			for (int i = 0; i < isChoosen.length; i++) {
				sb.append(isChoosen[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			isChoosen[cnt] = i;
			Perm(i + 1, cnt + 1);
		}
	}

}
