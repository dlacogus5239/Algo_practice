package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1149 RGB 거리 
public class Main1149 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 집의 개수
		int N;
		N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {
			cost[i][0] = Math.min(cost[i - 1][1] + cost[i][0], cost[i - 1][2] + cost[i][0]);
			cost[i][1] = Math.min(cost[i - 1][0] + cost[i][1], cost[i - 1][2] + cost[i][1]);
			cost[i][2] = Math.min(cost[i - 1][0] + cost[i][2], cost[i - 1][1] + cost[i][2]);

		}
		Arrays.sort(cost[N - 1]);
		System.out.println(cost[N - 1][0]);
	}

}
