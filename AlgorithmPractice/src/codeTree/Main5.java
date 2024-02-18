package codeTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
	static int N;
	static int[] arr;
	static boolean[] isChoosen;

	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		isChoosen = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// INPUT END
		for (int i = 0; i < N - 1; i++) {
			isChoosen[i] = true;
			Perm(1, i);
			isChoosen[i] = false;
		}
		System.out.println(result);
	}

	public static void Perm(int cnt, int start) {
		if (cnt == 2) {
			int tmp = 1;
			for (int i = 0; i < N; i++) {
				if (isChoosen[i]) {
					tmp *= arr[i];
				}
			}
			result = Math.max(result, tmp);
			return;
		}

		for (int i = start + 1; i < N; i++) {
			if (!isChoosen[i]) {
				isChoosen[i] = true;
				Perm(cnt + 1, i);
				isChoosen[i] = false;
			}
		}

	}

}
