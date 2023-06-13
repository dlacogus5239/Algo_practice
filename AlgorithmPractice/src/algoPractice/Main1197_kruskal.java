package algoPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1197_kruskal {
	// 백준 1197 최소 스패닝 트리
	// 최소 스패닝 트리 알고리즘
	// 1. 크루스칼 (Kruskal) --> Union Set
	// 2. 프림 (Prim)

	static int V, E;

	// Union-Set
	static int[] p;

	static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	// 크루스칼 구현
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ArrayList<Edge> edges = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges.add(new Edge(from, to, weight));
		}
		// 비용에 따른 오름차순 정렬
		edges.sort(new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		makeSet();

		int result = 0;
		// 오름차순 정렬이라 가장 비용이 적은 간선부터 선택된다
		for (Edge e : edges) {
			// 사이클을 이루지 않을 경우 결과값에 추가해준다
			if (unionSet(e.from, e.to)) {
				result += e.weight;
			}
		}

		System.out.println(result);

	}

	public static void makeSet() {
		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
	}

	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		// 부모 노드가 같을 경우 사이클 형성 --> 트리 구성 X
		if (aRoot == bRoot) {
			return false;
		}
		p[bRoot] = aRoot;

		return true;
	}

	public static int findSet(int a) {
		// 부모 노드일 경우
		if (a == p[a]) {
			return a;
		}
		p[a] = findSet(p[a]);

		return p[a];
	}

}
