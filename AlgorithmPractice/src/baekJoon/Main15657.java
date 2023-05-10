package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15657 {
	// 백준 15657 N 과 M(8)
	static int N, M;
	static int[] nums;
	static int[] selected;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N + 1];
		selected = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// input END

		Arrays.sort(nums);
		dupComb(1, 0);
	}

	public static void dupComb(int start, int cnt) {
		if (cnt == M) {
			print();
			return;
		}
		for (int i = start; i <= N; i++) {
			selected[cnt] = nums[i];
			dupComb(i, cnt + 1);
		}

	}

	public static void print() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			sb.append(selected[i] + " ");
		}

		System.out.println(sb.toString());
	}

}
