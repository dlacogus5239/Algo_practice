package binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2467 {
	// 투 포인터 이용
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] liquid = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}

		long min = Long.MAX_VALUE;
		long[] result = new long[2];

		int start = 0;
		int end = N - 1;
		while (start < end) {
			long tmp = liquid[start] + liquid[end];
			if (min > Math.abs(tmp)) {
				min = Math.abs(tmp);
				result[0] = liquid[start];
				result[1] = liquid[end];
			}
			// 크기에 따라서, 현재 값이 양수이면 끝을 줄여주고, 음수면 앞을 줄여주자
			// --> 정렬을 했기 때문!
			if (tmp >= 0) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println(result[0] + " " + result[1]);

	}

}
