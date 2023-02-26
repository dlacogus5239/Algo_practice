package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
 * 
 * 개중요합니당 
 * 
 */

public class Main12865 {
	// 백준 12865 평범한 배낭

	static class Item {
		int weight;
		int value;

		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Item> arr = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i - 1][j];

				if (j - arr.get(i - 1).weight >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr.get(i - 1).weight] + arr.get(i - 1).value);
				}
			}
		}

		System.out.println(dp[N][K]);

	}

}
