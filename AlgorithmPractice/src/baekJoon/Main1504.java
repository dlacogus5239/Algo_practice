package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1504 {
	// 백준 1504 특정한 최단 경로
	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}

	}

	static int N, E;
	static ArrayList<Edge>[] graph;
	static int v1, v2;
	static int[] distance, distanceV1, distanceV2, distanceFirst;
	static boolean[] isVisited;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int answer = -1;
		graph = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];
		distance = new int[N + 1];
		distanceV1 = new int[N + 1];
		distanceV2 = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from].add(new Edge(to, cost));
			graph[to].add(new Edge(from, cost));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		// input END

		// PriorityQueue 쓸거라 정렬 따로 필요없음
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[1] = 0;
		Dijsktra(1);
		distanceFirst = distance.clone();
//		System.out.println("Distance from 1");
//		for (int i = 1; i <= N; i++) {
//			System.out.print(distanceFirst[i] + " ");
//		}
//		System.out.println();
		if (!isVisited[N]) {
			System.out.println("-1");
			return;
		}

		int oneToV1 = distance[v1];
		int oneToV2 = distance[v2];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[v1] = 0;
		isVisited = new boolean[N + 1];
		Dijsktra(v1);
		distanceV1 = distance.clone();
//		System.out.println("Distance from V1");
//		for (int i = 1; i <= N; i++) {
//			System.out.print(distanceV1[i] + " ");
//		}
//		System.out.println();

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[v2] = 0;
		isVisited = new boolean[N + 1];
		Dijsktra(v2);
		distanceV2 = distance.clone();
//		System.out.println("Distance from V2");
//		for (int i = 1; i <= N; i++) {
//			System.out.print(distanceV2[i] + " ");
//		}
//		System.out.println();		
		int v1Tov2 = distanceFirst[v1] + distanceV1[v2] + distanceV2[N];
		int v2Tov1 = distanceFirst[v2] + distanceV2[v1] + distanceV1[N];
		System.out.println(Math.min(v1Tov2, v2Tov1));

	}

	public static void Dijsktra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int to = cur.to;
			int cost = cur.cost;
			if (!isVisited[to]) {
				isVisited[to] = true;
				for (Edge next : graph[to]) {
					int nextDis = next.cost + cost;
					if (nextDis < distance[next.to]) {
						distance[next.to] = nextDis;
						pq.offer(new Edge(next.to, nextDis));
					}
				}
			}

		}
	}

}
