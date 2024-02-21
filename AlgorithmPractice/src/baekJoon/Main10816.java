package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] Cards = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Cards[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		int[] nums = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// INPUT END
		Arrays.sort(Cards);
//		for (int i = 0; i < N; i++) {
//			System.out.print(Cards[i] + " ");
//		}
//		System.out.println();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int cur = nums[i];

			sb.append(UpperBound(cur, Cards) - LowerBound(cur, Cards)).append(" ");
		}
		System.out.println(sb.toString());

	}

	public static int UpperBound(int cur, int[] arr) {
		int lo = 0;
		int hi = arr.length;
		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (cur < arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}

		}

		return lo;
	}

	public static int LowerBound(int cur, int[] arr) {
		int lo = 0;
		int hi = arr.length;
		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (arr[mid] >= cur) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;

	}
}
