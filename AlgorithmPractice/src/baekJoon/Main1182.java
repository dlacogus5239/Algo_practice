package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 1182 부분수열의 합
public class Main1182 {
	static int N, S;
	static int[] nums;
	static ArrayList<Integer> sums = new ArrayList<>();
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		MakeSum(0, 0, N);

//		System.out.println(sums.toString());
		Collections.sort(sums);
		if (S == 0) {
			answer--;
		}

		System.out.println(answer);
	}

	public static void MakeSum(int sum, int start, int end) {
		if (start == end) {
			if (sum == S) {
				answer++;
			}
			return;
		}

		MakeSum(sum, start + 1, end);
		MakeSum(sum + nums[start], start + 1, end);
	}

}
