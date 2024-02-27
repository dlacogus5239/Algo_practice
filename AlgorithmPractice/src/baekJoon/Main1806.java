package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		int[] cumulate = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cumulate[i] = arr[i] + cumulate[i - 1];
		}

		// cumulate[end] - cumulate[start] => start + 1부터 end까지의 합
		int start = 0;
		int end = 1;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while (end <= N) {
			sum = cumulate[end] - cumulate[start];
			if (sum < S) {
				end++;
			} else if (sum >= S) {
				min = Math.min(min, end - start);
				start++;
			}

		}
		System.out.println(min == Integer.MAX_VALUE ? "0" : min);
//		System.out.println("START : " + start + ", END : " + end);
//		System.out.println(sum);

	}

}
