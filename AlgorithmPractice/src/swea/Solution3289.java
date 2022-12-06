package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3289 {
	static int[] p;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken()); // a, b <= N
			int M = Integer.parseInt(st.nextToken()); // 연산의 개수
			System.out.print("#" + test_case + " ");
			makeSet();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int op = Integer.parseInt(st.nextToken()); // 0 : 합집합, 1 : 같은 집합인지?
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (op == 0) {
					unionSet(a, b);
				} else if (op == 1) {
					if (findSet(a) == findSet(b)) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}
			}

			System.out.println();
		}
	}

	static void makeSet() {
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == p[a]) {
			return a;
		}
		p[a] = findSet(p[a]);
		return p[a];
	}

	static void unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot != bRoot) {
			p[bRoot] = aRoot;
		}

		return;
	}
}

