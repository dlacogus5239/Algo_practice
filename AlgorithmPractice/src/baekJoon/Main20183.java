package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main20183 {
	// 백준 20183 골목 대장 호석 - 효율성 2

	static final int INF = 1_000_000_007;

	// 골목(간선) 클래스
	public static class Edge implements Comparable<Edge> {
		int no;
		long weight;

		public Edge(int no, long weight) {
			this.no = no;
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

		// 교차로 개수 (정점)
		int N = Integer.parseInt(st.nextToken());
		// 골목 개수 (간선)
		int M = Integer.parseInt(st.nextToken());

		// 시작 교차로 번호
		int A = Integer.parseInt(st.nextToken());
		// 도착 교차로 번호
		int B = Integer.parseInt(st.nextToken());

		// 가진 돈 (최대비용)
		long C = Long.parseLong(st.nextToken());

		// 그래프
		ArrayList<Edge>[] graph = new ArrayList[N + 1];

		// 그래프 초기화
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());

			// 양방향
			graph[from].add(new Edge(to, weight));
			graph[to].add(new Edge(from, weight));
		}

		// input END
		br.close();

		// 매개변수 탐색 + 이분탐색
		int start = 1;
		int end = 1_000_000_000;
		int answer = INF;
		// 이분탐색
		while (start <= end) {
			int mid = (start + end) / 2;
			long[] dist = new long[N + 1];

			// Dijkstra START
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			Arrays.fill(dist, 600_000_000_000_000L);
			pq.offer(new Edge(A, 0));
			dist[A] = 0;
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				if (cur.weight > dist[cur.no]) {
					continue;
				}

				for (Edge e : graph[cur.no]) {
					if (e.weight > mid) {
						continue;
					}
					long nextWeight = dist[cur.no] + e.weight;

					if (dist[e.no] > nextWeight) {
						dist[e.no] = nextWeight;
						pq.add(new Edge(e.no, dist[e.no]));
					}
				}
			}
			if (dist[B] > C) {
				start = mid + 1;
			} else {
				answer = mid;
				end = mid - 1;
			}
		}

//		for (int i = 1; i <= N; i++) {
//			System.out.print(maxWeight[i] + " ");
//		}
//		System.out.println();

		System.out.println((answer == INF) ? -1 : answer);

	}

}
