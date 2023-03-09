package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3151 {
	// 백준 3151 합이 0
	static int[] arr;
	static int N;
	static long result = 0L;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// input END
		Arrays.sort(arr);

		// arr 확인용
//		for (int i = 0; i < N; i++) {
//			System.out.print(arr[i] + " ");
//		}

		for (int i = 0; i < N; i++) {
			if (arr[i] > 0) {
				break;
			}

			int low = i + 1;
			int high = N - 1;

			while (low < high) {
				int start = 1;
				int end = 1;

				// 현재 선택된 값들 총합
				int cur = arr[low] + arr[high] + arr[i];

				// 조건에 만족
				if (cur == 0) {
					if (arr[low] == arr[high]) {
						result += comb(high - low + 1);
						break;
					}

					// 같은 원소(값)일 경우 다른 사람이니까 Comb 계산을 위해
					while (low + 1 < high && arr[low] == arr[low + 1]) {
						start++;
						low++;
					}
					while (low < high - 1 && arr[high] == arr[high - 1]) {
						end++;
						high--;
					}

					result += start * end;
				}
				// 이분탐색 포인터 이동
				if (cur > 0) {
					high--;
				} else {
					low++;
				}
			}
		}

		System.out.println(result);
	}

	public static int comb(int n) {
		return n * (n - 1) / 2;
	}

}
