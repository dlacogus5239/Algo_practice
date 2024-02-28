package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Union-find Algorithm
// Disjoint Set

public class Main20040 {
	static int N, M;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		makeSet();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (unionSet(a, b)) {
				System.out.println(i + 1);
				return;
			}
		}

		System.out.println(0);
		return;
	}

	public static void makeSet() {
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}

		return;
	}

	public static int findSet(int a) {
		if (p[a] == a) {
			return a;
		}

		return findSet(p[a]);
	}

	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot != bRoot) {
			p[bRoot] = aRoot;
			return false;
		}
		return true;

	}
}
