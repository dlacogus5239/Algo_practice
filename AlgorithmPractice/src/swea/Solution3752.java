package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3752 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] score = new int[N];
			st = new StringTokenizer(br.readLine());
			int total = 0;
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				total += score[i];
			}

			int[] result = new int[total + 1];
			result[0] = 1;
			for (int i = 0; i < N; i++) {
				int tmp = score[i];
				for (int j = total; j >= 0; j--) {
					if (result[j] == 1) {
						result[j + tmp] = 1;
					}
				}
			}
			int answer = 0;
			for (int i = 0; i <= total; i++) {
				if (result[i] == 1) {
					answer++;
				}
			}
			sb.append("#" + t + " ").append(answer).append("\n");

		}

		System.out.println(sb.toString());
	}

}
