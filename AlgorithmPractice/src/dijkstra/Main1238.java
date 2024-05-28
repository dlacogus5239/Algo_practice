package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1238 {
	static int N, M, X; // N명의 학생, M개의 도로(단방향), X 목적지

	static class Edge implements Comparable<Edge> {
		int to, weight;

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
	static final int INF = Integer.MAX_VALUE;
	static int[][] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		distance = new int[N + 1][N + 1]; // [i][j] --> i 부터 j까지 최단거리
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(distance[i], INF);
		}
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, weight));
		}

		for (int i = 1; i < N + 1; i++) {
			Dijkstra(i);
		}
		int result = 0;

//		for (int i = 1; i < N + 1; i++) {
//			for (int j = 1; j < N + 1; j++) {
//				System.out.print(distance[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int i = 1; i < N + 1; i++) {
			result = Math.max(result, distance[i][X] + distance[X][i]);
		}
		System.out.println(result);
	}

	public static void Dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		distance[start][start] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.weight > distance[start][cur.to]) {
				continue;
			}

			for (int i = 0; i < graph[cur.to].size(); i++) {
				Edge tmp = graph[cur.to].get(i);
				if (distance[start][tmp.to] > cur.weight + tmp.weight) {
					distance[start][tmp.to] = cur.weight + tmp.weight;
					pq.offer(new Edge(tmp.to, distance[start][tmp.to]));
				}
			}
		}
	}

}
