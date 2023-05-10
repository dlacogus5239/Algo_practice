package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15652 {
	// 백준 15652 N과 M (4)
	static int N, M;
	static int[] selected;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M];

		dupComb(1, 0);

	}

	public static void dupComb(int start, int cnt) {
		if (cnt == M) {
			print();
			return;
		}
		for (int i = start; i <= N; i++) {
			selected[cnt] = i;
			dupComb(i, cnt + 1);
		}
	}

	public static void print() {
		for (int i = 0; i < selected.length; i++) {
			System.out.print(selected[i] + " ");
		}

		System.out.println();
	}

}
