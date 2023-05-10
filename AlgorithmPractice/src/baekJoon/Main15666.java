package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main15666 {
	// 백준 15666 N 과 M (12)
	static int N, M;
	static int[] nums, selected;
	static boolean[] isSelected;
	static LinkedHashSet<String> result = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N + 1];
		selected = new int[M];
		isSelected = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		dupPerm(1, 0);
		for (String s : result) {
			System.out.println(s);
		}

	}

	public static void dupPerm(int start, int cnt) {
		if (cnt == M) {
			print();
			return;
		}

		for (int i = start; i <= N; i++) {
			selected[cnt] = nums[i];
			dupPerm(i, cnt + 1);
		}

	}

	public static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(selected[i]).append(" ");
		}

		result.add(sb.toString());

	}

}
