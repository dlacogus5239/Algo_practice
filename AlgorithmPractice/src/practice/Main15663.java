package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main15663 {
	// 백준 15663 N과 M (9)
	static int N, M;
	static int[] nums;
	static int[] selected;
	static boolean[] isSelected;
	// 중복된 순열 제외하기 위함
	static LinkedHashSet<String> result = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		nums = new int[N + 1];
		selected = new int[M];
		isSelected = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
		perm(0);

		for (String s : result) {
			System.out.println(s);
		}
	}

	public static void perm(int cnt) {
		if (cnt == M) {
			print();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				selected[cnt] = nums[i];
				perm(cnt + 1);
				isSelected[i] = false;
			}
		}

	}

	public static void print() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			sb.append(selected[i] + " ");
		}

		result.add(sb.toString());
	}

}
