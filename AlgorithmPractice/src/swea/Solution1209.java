package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1209 {
	// SWEA Sum
	static int[][] map;
	static final int T = 10;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			map = new int[100][100];
			int max = Integer.MIN_VALUE;

			br.readLine();
			StringTokenizer st;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = Math.max(rowMax(), Math.max(colMax(), crossMax()));

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static int rowMax() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 100; i++) {
			int sum = 0;

			for (int j = 0; j < 100; j++) {
				sum += map[i][j];
			}
			max = Math.max(max, sum);
			sum = 0;
		}
		return max;
	}

	public static int colMax() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 100; i++) {
			int sum = 0;

			for (int j = 0; j < 100; j++) {
				sum += map[j][i];
			}
			max = Math.max(max, sum);
			sum = 0;
		}
		return max;

	}

	public static int crossMax() {
		int max = Integer.MIN_VALUE;

		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (i == j) {
					sum += map[i][j];
				}
			}
		}
		max = sum;
		sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (i - 99 == j) {
					sum += map[j][i];
				}
			}
		}
		max = Math.max(max, sum);

		return max;
	}

}
