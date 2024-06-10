package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16401 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] snack = new int[N];
		for (int i = 0; i < N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(snack);
		int max = snack[N - 1];

		int start = 1;
		int end = max;
		int mid = 0;
		int answer = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (mid == 0) {
				break;
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				cnt += (int) (snack[i] / mid);
			}

			if (cnt < M) {
				end = mid - 1;
			} else if (cnt >= M) {
				answer = mid;
				start = mid + 1;
			}
		}

		System.out.println(answer);
	}

}
