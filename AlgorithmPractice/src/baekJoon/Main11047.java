package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {
	// 백준 11047 동전 0
	// 로직은 맞았는데 시작 인덱스 설정에서 잘못된듯
	static int N, K;
	static int[] coins;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new int[N];
		int cur = 0;
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());

		}

		int answer = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (coins[i] > K) {
				continue;
			}

			answer += K / coins[i];
			K = K % coins[i];
		}
		System.out.println(answer);
	}

}
