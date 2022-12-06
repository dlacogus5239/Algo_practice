package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7465 {
	static int[] p;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			p = new int[N + 1];
			makeSet();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				unionSet(a, b);
			}
			for (int i = 1; i <= N; i++) {
				findSet(i);
			}
			Arrays.sort(p);
			int tmp = p[1];
			int result = 1;
			for (int i = 2; i <= N; i++) {
				if (tmp != p[i]) {
					result++;
					tmp = p[i];
				}
			}
			System.out.println("#" + test_case + " " + result);
		}

	}

	public static void makeSet() {
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == p[a]) {
			return a;
		}
		p[a] = findSet(p[a]);
		return p[a];
	}

	public static void unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return;
		}
		p[bRoot] = aRoot;
		return;
	}
}
