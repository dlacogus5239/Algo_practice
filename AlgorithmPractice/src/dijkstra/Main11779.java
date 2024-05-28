package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main11779 {
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

	static int N, M;
	static ArrayList<Edge>[] graph;
	static int[] distance;
	static int START, END;
	static final int INF = Integer.MAX_VALUE;
	// 이전 경로를 저장하는 배열
	static int[] way;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		way = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		distance = new int[N + 1];
		Arrays.fill(distance, INF);
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, weight));
		}

		st = new StringTokenizer(br.readLine());
		START = Integer.parseInt(st.nextToken());
		END = Integer.parseInt(st.nextToken());

		Dijkstra(START);
		StringBuilder sb = new StringBuilder();
		int idx = END;
		Stack<Integer> s = new Stack<>();
		s.push(END);
		int cnt = 0;
		while (idx != START) {
			cnt++;
			s.push(way[idx]);
			idx = way[idx];
		}
		while (!s.isEmpty()) {
			sb.append(s.pop()).append(" ");
		}
		System.out.println(distance[END]);
		System.out.println(cnt + 1);
		System.out.println(sb.toString());

	}

	public static void Dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[start] = 0;
		way[start] = start;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.to == END) {
				break;
			}
			if (cur.weight > distance[cur.to]) {
				continue;
			}
			for (int i = 0; i < graph[cur.to].size(); i++) {
				Edge tmp = graph[cur.to].get(i);

				if (distance[tmp.to] > cur.weight + tmp.weight) {
					distance[tmp.to] = cur.weight + tmp.weight;
					pq.offer(new Edge(tmp.to, cur.weight + tmp.weight));
					way[tmp.to] = cur.to;
				}
			}
		}

	}

}
