package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 백준 2108 통계학
public class Main2108 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];
		int[] frequency = new int[8001];
		int sum = 0;

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
			frequency[nums[i] + 4000]++;

		}
		StringBuilder sb = new StringBuilder();
		int preFreqIdx = 0;
		int freqIdx = 0;
		int freq = 0;
		int cnt = 1;
		Arrays.sort(nums);
		for (int i = frequency.length - 1; i >= 0; i--) {
			if (freq <= frequency[i]) {
				if (freq == frequency[i]) {
					preFreqIdx = freqIdx;
					cnt++;
				}
				freq = frequency[i];
				freqIdx = i;

			}
		}
		sb.append(Math.round((double) (sum / N))).append("\n");
		sb.append(nums[N / 2]).append("\n");
		sb.append(cnt >= 2 ? preFreqIdx - 4000 : freqIdx - 4000).append("\n");
		sb.append(nums[N - 1] - nums[0]);
		System.out.println(sb.toString());
	}

}
