package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2473 {
	static int N;
	static long[] liquid;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		liquid = new long[N];

		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}

		// input END
		Arrays.sort(liquid);

		// 0에 가장 가까운 용액을 만들어 내는 3가지 용액
		long[] result = new long[3];
		int lo, hi;
		// 절대값으로 저장 (하나의 용액 각각 10억, 3개 합치면 10억 * 3 = 30억 --> 최댓값)
		long sum = 3_000_000_001L;

		long tmp = 0L;
		// 왼쪽 하나를 고정시키고 출발하자
		for (int k = 0; k < N - 2; k++) {

			lo = k + 1;
			hi = N - 1;
			while (lo < hi) {
				tmp = liquid[lo] + liquid[hi] + liquid[k];

				if (Math.abs(tmp) < sum) {
					sum = Math.abs(tmp);
					result[0] = liquid[k];
					result[1] = liquid[lo];
					result[2] = liquid[hi];
				}

				if (tmp == 0) {
					break;
				}
				if (tmp > 0) {
					hi--;
				} else {
					lo++;
				}
			}
		}

		System.out.println(result[0] + " " + result[1] + " " + result[2]);

	}

}
