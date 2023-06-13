package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17835 {
	// 백준 17835 면접보는 승범이네

	// 간선 클래스
	static class Edge implements Comparable<Edge> {
		int to;
		long weight;

		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M, K;
		ArrayList<Edge>[] list;
		long[] distance;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		distance = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		// 일일히 다 거리를 구하지 말고, 면접장으로 가는 길만 최솟값을 구하자
		// 그럴려면 면접장에서 다익스트라 구현
		// 면접장에서 역순으로 간다고 생각하자. 도로를 거꾸로 구상
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			list[to].add(new Edge(from, weight));
		}
		// 왜 이 숫자로(INF -> 100_000_000_000L로 하면 통과인지 모르겠음.
		Arrays.fill(distance, 100_000_000_000L);

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int curInterview = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(curInterview, 0));
			distance[curInterview] = 0;
		}
		br.close();
		// input END
		while (!pq.isEmpty()) {
			Edge curEdge = pq.poll();
			if (distance[curEdge.to] < curEdge.weight) {
				continue;
			}
			for (Edge e : list[curEdge.to]) {
				if (distance[e.to] > distance[curEdge.to] + e.weight) {
					distance[e.to] = distance[curEdge.to] + e.weight;
					pq.add(new Edge(e.to, distance[e.to]));
				}
			}
		}
		int idx = 1;
		long max = Long.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (max < distance[i]) {
				idx = i;
				max = distance[i];
			}
		}

		System.out.println(idx);
		System.out.println(max);
	}

//	public static void Dijkstra(int start) {
//		boolean[] isVisited = new boolean[N + 1];
//
//		PriorityQueue<Edge> pq = new PriorityQueue<>();
//		pq.offer(new Edge(start, 0));
//		distance[start] = 0;
//
//		while (!pq.isEmpty()) {
//			Edge curEdge = pq.poll();
//			if (!isVisited[curEdge.to]) {
//				for (Edge e : list[curEdge.to]) {
//					if (!isVisited[e.to] && distance[e.to] > distance[curEdge.to] + e.weight) {
//						distance[e.to] = distance[curEdge.to] + e.weight;
//						pq.add(new Edge(e.to, distance[e.to]));
//					}
//				}
//			}
//		}
//		// distance Checking
//		for (int i = 1; i < distance.length; i++) {
//			System.out.print(distance[i] + " ");
//		}
//		System.out.println();
//		return;
//	}

}
