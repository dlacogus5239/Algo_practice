package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 백준 2961번 도영이가 만든 맛있는 음식
public class Main2961 {
	static int[][] ingredient;
	static boolean[] isSelected;
	static int N;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ingredient = new int[N][2];
		isSelected = new boolean[N];
		// ingredient --> [S 신맛, B 쓴맛]
		// 신맛 --> 곱
		// 쓴맛 --> 합
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken());
			ingredient[i][1] = Integer.parseInt(st.nextToken());
		}
		subset(0);
		System.out.println(min);
	}

	public static void subset(int cnt) {
		if (cnt == N) {
			int S = 1;
			int B = 0;
			boolean flag = false;
			// System.out.println(taste);
			for (int n = 0; n < N; n++) {
				if (isSelected[n]) {
					S *= ingredient[n][0];
					B += ingredient[n][1];
					flag = true;
				}
			}
			if (flag) {
				min = Math.min(Math.abs(S - B), min);
			}
			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}
}