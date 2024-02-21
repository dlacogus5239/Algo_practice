package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] Woods = new int[N];
		int max = 0;
		int min = 0;
		for (int i = 0; i < N; i++) {
			Woods[i] = Integer.parseInt(st.nextToken());
			if (max < Woods[i]) {
				max = Woods[i];
			}
		}
		int mid = 0;
		while (min < max) {
			mid = (max + min) / 2;
			long sum = 0L;
			for (int i = 0; i < Woods.length; i++) {
				if (Woods[i] - mid > 0) {
					sum += Woods[i] - mid;
				}
			}

			// 값이 작으면 윗(max)값 감소
			// 그래야 더 많이 자름
			if (sum < M) {
				max = mid;
			} else {
				// 아니면 아래(min)값 증가
				// 그래야 덜 자름
				min = mid + 1;
			}
		}

		// Upper Bound 방식을 사용할 경우
		// 탐색값의 + 1
		System.out.println(min - 1);
	}

}
