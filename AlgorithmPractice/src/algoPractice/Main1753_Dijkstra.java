package algoPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753_Dijkstra {

	static int V, E; // 정점개수, 간선개수
	static final int INF = Integer.MAX_VALUE;
	static int[] distance;

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	static ArrayList<Edge>[] graph;
	static int START;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		START = Integer.parseInt(br.readLine());
		distance = new int[V + 1];
		Arrays.fill(distance, INF);
		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, weight));

		}
		Dijkstra(START);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INF) {
				sb.append("INF").append("\n");
			} else {
				sb.append(distance[i]).append("\n");
			}
		}
		System.out.println(sb.toString());

	}

	public static void Dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(); // weight 오름차순으로 뽑아냄
		pq.offer(new Edge(start, 0));
		distance[start] = 0; // 처음 시작점은 0
		while (!pq.isEmpty()) {
			Edge cur = pq.poll(); // 정점 하나 꺼낸다.
			int curVertex = cur.to; // 정점 정보 저장
			int curWeight = cur.weight;
			if (curWeight > distance[curVertex]) { // 지금 현재값이 더 크면 검사 X
				continue;
			}
			for (int i = 0; i < graph[curVertex].size(); i++) {
				Edge tmp = graph[curVertex].get(i);

				if (distance[tmp.to] > curWeight + tmp.weight) {
					distance[tmp.to] = curWeight + tmp.weight;
					pq.offer(new Edge(tmp.to, curWeight + tmp.weight));
				}
			}
		}
	}

}
