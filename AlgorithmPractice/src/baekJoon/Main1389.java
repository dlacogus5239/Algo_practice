package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1389 {
	// 백준 1389 케빈 베이컨의 6단게 법칙
	static int N, M;
	static int[][] distance;
	static int[] distanceSum;
	static int result = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		distance = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				distance[i][j] = 999_999_999;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			distance[from][to] = 1;
			distance[to][from] = 1;
		}
		br.close();
		// input END

		// distance[from][to]
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}

		distanceSum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				distanceSum[i] += distance[i][j];
			}

			if (min > distanceSum[i]) {
				result = i;
				min = distanceSum[i];
			}
		}
		System.out.println(result);
	}

}
