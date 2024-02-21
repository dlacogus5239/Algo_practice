package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K, N;
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[] arr = new int[K];
		long hi = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (hi < arr[i]) {
				hi = arr[i];
			}
		}
		hi++;

		// Upper bound

		long lo = 0;

		while (lo < hi) {
			long mid = (lo + hi) / 2;

			long sum = 0;
			for (int i = 0; i < K; i++) {
				sum += (arr[i] / mid);
			}

			if (sum < N) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		System.out.println(lo - 1);
	}

}
