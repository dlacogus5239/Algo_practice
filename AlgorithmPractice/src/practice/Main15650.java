package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15650 {
	// 백준 156650 N 과 M (2)
	static int N, M;
	static StringBuilder sb;

	static boolean[] isSelected;
	static int[] num;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = i;
		}

		isSelected = new boolean[N + 1];
		comb(1, 0);
	}

	public static void comb(int start, int cnt) {
		if (cnt == M) {
			print();
			return;
		}

		for (int i = start; i <= N; i++) {
			isSelected[i] = true;
			comb(i + 1, cnt + 1);
			isSelected[i] = false;
		}
	}

	public static void print() {
		for (int i = 1; i < isSelected.length; i++) {
			if (isSelected[i]) {
				System.out.print(num[i] + " ");
			}
		}
		System.out.println();

	}

}
