package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1647 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int[] p;
	static int N, M;
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// 마을을 분리시키는데, 길의 비용을 최소한으로 하고싶어함 --> 가장 weight가 큰 길 하나 제거!
		// 그러면 마을 2개로 분리 가능.
		// 최소스패닝트리 --> Kruskal
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edgeList = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		// input END
		Arrays.sort(edgeList);// 정렬
		makeSet();

		int result = 0;
		int maxWeight = 0;
		for (Edge e : edgeList) {
			if (unionSet(e.from, e.to)) {
				result += e.weight;
				maxWeight = e.weight;
			}
		}

		System.out.println(result - maxWeight);
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
