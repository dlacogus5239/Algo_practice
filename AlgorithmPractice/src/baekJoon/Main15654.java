package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15654 {
	// 백준 15654 N과 M (5)
	static int N, M;
	static int[] nums;
	static int[] selected;
	static boolean[] isSelected;

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
		br.close();

		// input END

		Arrays.sort(nums);

		comb(0);

	}

	public static void comb(int cnt) {
		if (cnt == M) {
			print();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				selected[cnt] = nums[i];
				comb(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < selected.length; i++) {
			sb.append(selected[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
