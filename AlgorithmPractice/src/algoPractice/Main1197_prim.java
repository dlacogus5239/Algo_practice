package algoPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1197_prim {
	// 백준 1197 최소 스패닝 트리
	// 최소 스패닝 트리 알고리즘
	// 1. 크루스칼 (Kruskal) --> Union Set
	// 2. 프림 (Prim)

	static int V, E;
	static boolean[] isVisited;

	static class Edge {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

	}

	// 프림 알고리즘 구현
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		isVisited = new boolean[V + 1];
		ArrayList<Edge>[] graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, weight));
			graph[to].add(new Edge(from, weight));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		// 정점 모두 트리에 추가했는지 판단
		int cnt = V;
		int result = 0;
		pq.offer(new Edge(1, 0));
		while (cnt > 0 && !pq.isEmpty()) {
			Edge cur = pq.poll();
			if (isVisited[cur.to]) {
				continue;
			}
			isVisited[cur.to] = true;
			cnt--;
			result += cur.weight;
			for (Edge e : graph[cur.to]) {
				if (!isVisited[e.to]) {
					pq.offer(e);
				}
			}

		}

		System.out.println(result);

	}

}
