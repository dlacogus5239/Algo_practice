package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main18110 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] difficulty = new int[N];

		for (int i = 0; i < N; i++) {
			difficulty[i] = Integer.parseInt(br.readLine());
		}
		// input END

		Arrays.sort(difficulty);
		int del = (int) Math.round(N * 0.15);

		int sum = 0;
		for (int i = del; i < N - del; i++) {
			sum += difficulty[i];
		}

		double result = 0;
		result = (double) sum / (N - (del * 2));

		System.out.println(Math.round(result));

	}

}
