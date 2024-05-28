package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916 {
	static int N, M; // 도시의 개수, 버스의 개수

	static class Edge implements Comparable<Edge> {
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

	}

	static ArrayList<Edge>[] graph;
	static int[] distance;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		distance = new int[N + 1];
		Arrays.fill(distance, INF);
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Dijkstra(start);

		System.out.println(distance[end]);
	}

	public static void Dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[start] = 0;

		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (distance[cur.to] < cur.weight) {
				continue;
			}

			for (int i = 0; i < graph[cur.to].size(); i++) {
				Edge tmp = graph[cur.to].get(i);

				if (distance[tmp.to] > cur.weight + tmp.weight) {
					distance[tmp.to] = cur.weight + tmp.weight;
					pq.offer(new Edge(tmp.to, distance[tmp.to]));
				}
			}
		}

	}

}
