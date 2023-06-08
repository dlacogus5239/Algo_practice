package algoPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1504 {
	// 백준 1504 특정한 최단 경로
	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static ArrayList<Edge>[] list;
	static int N, E;
	static int v1, v2;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = -1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		int[] distanceStart = Dijkstra(1);
		int[] distanceV1 = Dijkstra(v1);
		int[] distanceV2 = Dijkstra(v2);

		if (distanceStart[N] == INF) {
			System.out.println("-1");
			return;
		}
		result = Math.min(distanceStart[v1] + distanceV1[v2] + distanceV2[N],
				distanceStart[v2] + distanceV2[v1] + distanceV1[N]);

		System.out.println(result);
	}

	public static int[] Dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		int[] tmpDist = new int[N + 1];
		Arrays.fill(tmpDist, INF);
		tmpDist[start] = 0;

		boolean[] isVisited = new boolean[N + 1];
		pq.add(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge curEdge = pq.poll();
			if (!isVisited[curEdge.to]) {
				for (Edge e : list[curEdge.to]) {
					if (!isVisited[e.to] && (tmpDist[e.to] > tmpDist[curEdge.to] + e.weight)) {
						tmpDist[e.to] = tmpDist[curEdge.to] + e.weight;
						pq.offer(new Edge(e.to, tmpDist[e.to]));
					}
				}
			}
		}

		return tmpDist;

	}

}
