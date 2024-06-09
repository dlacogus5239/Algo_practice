package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main2295 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		long[] input = new long[N];
		HashSet<Long> hs = new HashSet<>();
		for (int i = 0; i < N; i++) {
			hs.add(Long.parseLong(br.readLine()));
		}
		int tmp = 0;
		for (long num : hs) {
			input[tmp++] = num;
		}
		Arrays.sort(input);
		long[] sum = new long[N * N];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum[idx++] = input[i] + input[j];
			}
		}
		Arrays.sort(sum);
		long max = 0L;
		loop: for (int i = N - 1; i > 0; i--) {
			long target = input[i];
			for (int j = 0; j < N * N; j++) {
				if (target - sum[j] < 0) {
					continue;
				} else if (hs.contains(target - sum[j])) {
					max = target;
					break loop;
				}
			}
		}

		System.out.println(max);
	}

}
