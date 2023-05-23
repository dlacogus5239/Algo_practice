package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1206 {
	// SWEA 1206 View

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] apt = new int[N];
			for (int i = 0; i < N; i++) {
				apt[i] = Integer.parseInt(st.nextToken());
			}
			// input END
			int answer = 0;

			for (int i = 2; i < N - 2; i++) {
				if (apt[i - 2] < apt[i] && apt[i - 1] < apt[i] && apt[i] > apt[i + 1] && apt[i] > apt[i + 2]) {
					int tmpMax = Math.max(Math.max(Math.max(apt[i - 2], apt[i - 1]), apt[i + 1]), apt[i + 2]);
					answer += apt[i] - tmpMax;
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());

	}

}
