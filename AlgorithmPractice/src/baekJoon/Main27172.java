package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main27172 {
	// 에라토스테네스의 체 응용

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N + 1];
		int[] nums = new int[1_000_001]; // nums[num] = idx

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			nums[tmp] = i;
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 0) {
				continue;
			}
			for (int j = i * 2; j < nums.length; j += i) {
				if (nums[j] != 0) {
					result[nums[j]]--;
					result[nums[i]]++;
				}
			}
		}
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				sb.append(result[nums[i]] + " ");
			}
		}

		System.out.println(sb.toString());

	}

}
