package codeTreePractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

		}
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			for (int idx = from; idx <= to; idx++) {
				arr[idx] = 0;
			}
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] != 0) {
					stack.add(arr[j]);
				}
			}
			arr = new int[stack.size()];
			int idx = arr.length - 1;
			while (!stack.isEmpty()) {
				arr[idx--] = stack.pop();
			}

		}
		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				System.out.println(arr[i]);
			}
		}
	}

}
