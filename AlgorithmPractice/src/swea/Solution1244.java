package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1244 {
	// SWEA 1244 최대 상금
	static int max, change;
	static int[] nums;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 구현
			max = 0;
			String[] input;
			StringTokenizer st = new StringTokenizer(br.readLine());
			input = st.nextToken().split("");
			change = Integer.parseInt(st.nextToken());
			nums = new int[input.length];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(input[i]);
			}
			if (nums.length < change) {
				change = nums.length;
			}
			dfs(0, 0);

			sb.append("#").append(test_case).append(" ").append(max).append("\n");

		}
		System.out.println(sb.toString());
	}

	public static void dfs(int start, int cnt) {
		if (cnt == change) {
			String result = "";
			for (int i = 0; i < nums.length; i++) {
				result += Integer.toString(nums[i]);
			}
			max = Math.max(max, Integer.parseInt(result));
			return;
		}

		for (int i = start; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;

				dfs(i, cnt + 1);
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;

			}
		}
	}
}