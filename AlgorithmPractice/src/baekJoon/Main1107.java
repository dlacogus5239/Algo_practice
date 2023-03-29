package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1107 {
	// 백준 1107 리모컨

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] button = new boolean[10];
		Arrays.fill(button, true);
		int result = Integer.MAX_VALUE;
		// 1. +, - 버튼만을 눌렀을 때
		result = Math.min(result, Math.abs(N - 100));

		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				button[tmp] = false;
			}
		}

		// 2. 고장나지 않은 버튼을 눌러서 번호 표현 가능하면
		// 그 번호에서 +, - 로 그 수까지 갈 때 횟수 계산

		int cnt = 0;

		for (int i = 0; i <= 999_999; i++) {
			String s = String.valueOf(i);
			boolean flag = true;
			for (int j = 0; j < s.length(); j++) {
				// 버튼을 못 누를 경우 PASS
				if (!button[s.charAt(j) - '0']) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				continue;
			}

			// 고장난 버튼이 없어서 바로 i를 누를 수 있으면 i를 누르고 +, -를 이동한다.

			cnt = s.length() + Math.abs(i - N);

			// 최솟값
			result = Math.min(cnt, result);
		}

		System.out.println(result);
	}

}
