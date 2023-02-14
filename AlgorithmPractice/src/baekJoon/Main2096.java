package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2096 {
	// 백준 2096 내려가기
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] maxArr = new int[N][3];
		int[][] minArr = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				maxArr[i][j] = Integer.parseInt(st.nextToken());
				minArr[i][j] = maxArr[i][j];
			}
		}

		for (int i = 1; i < N; i++) {
			maxArr[i][0] = Math.max(maxArr[i - 1][1] + maxArr[i][0], maxArr[i - 1][0] + maxArr[i][0]);
			maxArr[i][1] = Math.max(Math.max(maxArr[i - 1][0] + maxArr[i][1], maxArr[i - 1][1] + maxArr[i][1]),
					maxArr[i - 1][2] + maxArr[i][1]);
			maxArr[i][2] = Math.max(maxArr[i - 1][1] + maxArr[i][2], maxArr[i - 1][2] + maxArr[i][2]);

			minArr[i][0] = Math.min(minArr[i - 1][1] + minArr[i][0], minArr[i - 1][0] + minArr[i][0]);
			minArr[i][1] = Math.min(Math.min(minArr[i - 1][0] + minArr[i][1], minArr[i - 1][1] + minArr[i][1]),
					minArr[i - 1][2] + minArr[i][1]);
			minArr[i][2] = Math.min(minArr[i - 1][1] + minArr[i][2], minArr[i - 1][2] + minArr[i][2]);
		}

		Arrays.sort(maxArr[N - 1]);
		Arrays.sort(minArr[N - 1]);

		System.out.println(maxArr[N - 1][2] + " " + minArr[N - 1][0]);
	}
}
