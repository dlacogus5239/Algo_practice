package codeTree;

import java.util.*;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], ' ');
		}

		if (N == 1) {
			System.out.println("A");
			return;
		}

		int alpha = 0;
		int idx = N / 2;
		int size = 1;
		for (int i = N - 1; i >= N / 2; i--) {
			for (int j = idx; j < size + idx; j++) {
				arr[j][i] = (char) ((alpha) + 'A');
				alpha = (alpha + 1) % 26;
			}
			size += 2;
			idx -= 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == ' ') {
					continue;
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}