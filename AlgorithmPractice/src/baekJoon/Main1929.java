package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1929 소수 구하기
public class Main1929 {
	static int N, M;
	static final int MAX = 1_000_001;
	static boolean[] isPrime = new boolean[MAX];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MakePrime();
		StringBuilder sb = new StringBuilder();
		for (int i = N; i <= M; i++) {
			if (isPrime[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());

	}

	public static void MakePrime() {

		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i <= Math.sqrt((double) MAX); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

}
