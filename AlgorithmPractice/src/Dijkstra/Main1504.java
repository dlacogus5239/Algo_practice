package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1504 {
	static int N, E;

	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	static ArrayList<Edge>[] graph;
	static int[][] distance;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
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

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		distance = new int[3][N + 1]; // 정점 에서 최단거리 0, v1에서 최단거리 1, v2에서 최단거리 2
		for (int i = 0; i < 3; i++) {
			Arrays.fill(distance[i], INF);
		}

		Dijkstra(1, 0);
		Dijkstra(v1, 1);
		Dijkstra(v2, 2);

		// 경우의 수
		// 시작점 -> v1 -> v2 -> 끝점
		// 경우의 수가 없을 경우
		int caseOne = distance[0][v1] + distance[1][v2] + distance[2][N];
		if (distance[0][v1] == INF || distance[1][v2] == INF || distance[2][N] == INF) {
			caseOne = Integer.MAX_VALUE;
		}
		// 시작점 -> v2 -> v1 -> 끝점
		int caseTwo = distance[0][v2] + distance[2][v1] + distance[1][N];
		if (distance[0][v2] == INF || distance[2][v1] == INF || distance[1][N] == INF) {
			caseTwo = Integer.MAX_VALUE;
		}
		int result = Math.min(caseOne, caseTwo);
		System.out.println(result == INF ? -1 : result);
	}

	public static void Dijkstra(int start, int vertex) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		distance[vertex][start] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (distance[vertex][cur.to] > cur.weight) {
				continue;
			}

			for (int i = 0; i < graph[cur.to].size(); i++) {
				Edge tmp = graph[cur.to].get(i);

				if (distance[vertex][tmp.to] > cur.weight + tmp.weight) {
					distance[vertex][tmp.to] = cur.weight + tmp.weight;
					pq.offer(new Edge(tmp.to, distance[vertex][tmp.to]));
				}
			}
		}
	}

}
