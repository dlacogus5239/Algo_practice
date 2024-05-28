package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 이 문제의 핵심 --> 시간초과 안나게 
// 면접장의 개수가 정해져있다. 전체 경우의 수를 탐색하면 시간초과가 난다 
// 그러니까 면접장에서 각 도시의 거리를 구하면 된다
// 근데 이때 반대로 면접장 -> 도시 를 구하기 때문에 
// 입력을 반대로 받자 

public class Main17835 {
	static int N, M, K;

	static class Edge implements Comparable<Edge> {
		int to;
		long weight;

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

		public Edge(int to, long weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}

	}

	static ArrayList<Edge>[] graph;
	static int[] interview;
	static long[] distance;
	static final long INF = 10000000000L;
	static long maxCity = -1, maxWeight = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());

			if (graph[from].size() == 0) {
				graph[from].add(new Edge(to, weight));
				continue;
			}

			graph[from].add(new Edge(to, weight));
		} // 최소거리로 INPUT

		st = new StringTokenizer(br.readLine());
		interview = new int[K];

		for (int i = 0; i < K; i++) {
			interview[i] = Integer.parseInt(st.nextToken());
		}
		distance = new long[N + 1];

		Dijkstra(interview);

		for (int i = 1; i < N + 1; i++) {
			if (maxWeight < distance[i]) {
				maxWeight = distance[i];
				maxCity = i;
			}
		}

		System.out.println(maxCity);
		System.out.println(maxWeight);
	}

	public static void Dijkstra(int[] start) {
		Arrays.fill(distance, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < start.length; i++) {
			distance[start[i]] = 0;
			pq.offer(new Edge(start[i], 0));
		}
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (distance[cur.to] < cur.weight) {
				continue;
			}

			for (int i = 0; i < graph[cur.to].size(); i++) {
				Edge tmp = graph[cur.to].get(i);

				if (distance[tmp.to] > tmp.weight + cur.weight) {
					distance[tmp.to] = tmp.weight + cur.weight;

					pq.offer(new Edge(tmp.to, distance[tmp.to]));
				}
			}
		}

	}

}
