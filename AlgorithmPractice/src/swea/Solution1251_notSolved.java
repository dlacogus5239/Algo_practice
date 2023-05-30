package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1251_notSolved {
	// SWEA 1251 하나로
	// Prim 알고리즘
	static double L;
	static boolean[] isVisited;

	static class Edge {
		int from;
		int to;
		double weight;

		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// Test Case START
		for (int t = 1; t <= T; t++) {
			// 섬의 개수
			int N = Integer.parseInt(br.readLine());
			isVisited = new boolean[N];
			
			StringTokenizer st_x;
			StringTokenizer st_y;
			for (int i = 0; i < N; i++) {
				st_x = new StringTokenizer(br.readLine());
				st_y = new StringTokenizer(br.readLine());
			}

			L = Double.parseDouble(br.readLine());

		}
		// Test Case END
	}

	public static double Cost(int x1, int y1, int x2, int y2) {
		return ((double) (Math.abs(x1 - x2) + Math.abs(y1 - y2)) * Math.pow(L, 2));
	}

}
