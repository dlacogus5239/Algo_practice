package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 백준 20955 민서의 응급 수술

public class Main20955{
	static int N, M;
	static int[] p;
	static HashSet<Integer> parent = new HashSet<Integer>(); // 부모 정보 저장(Set이라서 중복 피함)
	static int result = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 뉴런(노드)의 개수
		M = Integer.parseInt(st.nextToken()); // 시냅스(간선)의 개수

		// init
		makeSet();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			// union 하기 전 부모가 같으면 싸이클 존재하므로 끊어주는 연산
			if (!unionSet(from, to)) {
				result++;
			}
		}

		for (int i = 1; i < N + 1; i++) {
			parent.add(findSet(i));
		}
		// 분리된 트리 연결하기 위한 연산
		result += parent.size() - 1;
		System.out.println(result);

	}

	public static void makeSet() {
		p = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			p[i] = i;
		}
	}

	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		p[bRoot] = aRoot;
		return true;
	}

	public static int findSet(int a) {
		if (a == p[a]) {
			return a;
		}
		p[a] = findSet(p[a]);
		return p[a];
	}

}
