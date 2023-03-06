package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11054 {
	// 백준 11054 가장 긴 바이토닉 부분 수열
	static int N;
	static int[] nums;
	static Integer[] dp_up;
	static Integer[] dp_down;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		nums = new int[N];
		dp_up = new Integer[N];
		dp_down = new Integer[N];
		int result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			LBS_up(i);
		}
		for (int i = N - 1; i >= 0; i--) {
			LBS_down(i);
		}

//		for (int i = 0; i < N; i++) {
//			System.out.print(dp_up[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.print(dp_down[i] + " ");
//		}
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dp_up[i] + dp_down[i]);
		}
		System.out.println(result - 1);
	}

	// 증가수열
	public static int LBS_up(int idx) {
		// 탐색하지 않은 위치
		if (dp_up[idx] == null) {
			dp_up[idx] = 1;

			for (int i = idx - 1; i >= 0; i--) {
				if (nums[i] < nums[idx]) {
					dp_up[idx] = Math.max(dp_up[idx], LBS_up(i) + 1);
				}
			}
		}

		return dp_up[idx];
	}

	// 감소수열
	// 끝에서 부터 증가하는 수열 찾기
	public static int LBS_down(int idx) {
		if (dp_down[idx] == null) {
			dp_down[idx] = 1;

			for (int i = idx + 1; i < N; i++) {
				if (nums[i] < nums[idx]) {
					dp_down[idx] = Math.max(dp_down[idx], LBS_down(i) + 1);
				}
			}
		}

		return dp_down[idx];
	}

}
