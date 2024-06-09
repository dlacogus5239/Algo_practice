package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());

		int[] target = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int curTarget = target[i];
			boolean flag = false;
			int start = 0;
			int end = N - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (A[mid] == curTarget) {
					sb.append("1").append("\n");
					flag = true;
					break;
				}

				if (A[mid] < curTarget) {
					start = mid + 1;
				} else if (A[mid] > curTarget) {
					end = mid - 1;
				}

			}

			if (!flag) {
				sb.append("0").append("\n");
			}
		}

		System.out.println(sb.toString());

	}

}
