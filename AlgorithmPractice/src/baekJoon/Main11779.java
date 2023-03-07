package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main11779 {
	// 백준 11779 최소비용 구하기 2
	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
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

	static int N, M, start, end;
	static ArrayList<Edge>[] graph;
	static int[] distance;
	static int[] way;
	static final int INF = 999_999_999;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		distance = new int[N + 1];
		way = new int[N + 1];
		Arrays.fill(distance, INF);
		for (int i = 1; i <= N; i++) {
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
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		Dijkstra(start);

		Stack<Integer> s = new Stack<>();
		int cnt = 0;
		s.push(end);
		System.out.println(distance[end]);

		while (way[end] != 0) {
			cnt += 1;
			s.push(way[end]);
			end = way[end];
		}
		System.out.println(cnt + 1);
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}

	public static void Dijkstra(int idx) {
		PriorityQueue<Edge> q = new PriorityQueue<>();

		q.add(new Edge(start, 0));
		distance[idx] = 0;

		while (!q.isEmpty()) {
			Edge cur = q.poll();

			if (distance[cur.to] < cur.weight) {
				continue;
			}

			for (Edge e : graph[cur.to]) {
				if (distance[e.to] > distance[cur.to] + e.weight) {
					distance[e.to] = distance[cur.to] + e.weight;
					way[e.to] = cur.to;
					q.offer(new Edge(e.to, distance[e.to]));
				}
			}
		}
	}

}
