package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {
	static int N;
	static int[] cards;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		cards = new int[N];

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N - 1;
			// LowerBound (위에서 아래로 찾아줌),UpperBound(아래에서 위로 찾아줌)
			sb.append(LowerBound(target) - UpperBound(target)).append(" ");
		}

		System.out.println(sb.toString());

	}

	// Lower Bound
	public static int LowerBound(int target) {
		int start = 0;
		int end = N;
		while (start < end) {
			int mid = (start + end) / 2;
			if (target < cards[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}
		return start;
	}

	// Upper Bound
	public static int UpperBound(int target) {
		int start = 0;
		int end = N;

		while (start < end) {
			int mid = (start + end) / 2;

			if (cards[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}

}
