package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		Arrays.sort(nums);
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (UpperBound(tmp, nums)) {
				sb.append("1").append("\n");
			} else {
				sb.append("0").append("\n");
			}

		}
		System.out.println(sb.toString());
	}

	public static boolean UpperBound(int n, int[] arr) {
		int s = 0;
		int e = arr.length - 1;

		while (s <= e) {
			int mid = (e + s) / 2;

			if (arr[mid] < n) {
				s = mid + 1;
			} else if (arr[mid] > n) {
				e = mid - 1;
			} else {

				return true;
			}
		}

		return false;
	}

}
