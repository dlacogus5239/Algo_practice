package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main20183 {
	static int N, M, A, B; // 교차로 개수, 골목 개수, 시작 교차로 번호, 도착 교차로 번호, 가진 돈
	static long C;

	static class Edge implements Comparable<Edge> {
		int to;
		long weight;

		public Edge(int to, long weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}

	}

	static ArrayList<Edge>[] graph;
	static final long INF = 1_000_000_007L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken()); // 시작 좌표
		B = Integer.parseInt(st.nextToken()); // 끝 좌표
		C = Long.parseLong(st.nextToken()); // 가진 돈

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			// 양방향 간선 정보 입력
			graph[from].add(new Edge(to, weight));
			graph[to].add(new Edge(from, weight));
		}

		// 한 구간 가중치 최대값(최댓값의 최소치?)을 고정시키고 (매개변수 탐색, 이분탐색)
		// 다익스트라 탐색을 통해 경로를 찾자
		long start = 1;
		long end = 1_000_000_000L;
		long answer = INF;
		long mid = -1; // 찾을 매개변수
		long[] distance = new long[N + 1];

		while (start <= end) {
			mid = (start + end) / 2;
			Arrays.fill(distance, 600_000_000_000_000L); // 이 부분 INF로 설정하면 (32/42)개만 맞음
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			distance[A] = 0; // 시작점은 0

			// Djikstra 수행
			pq.offer(new Edge(A, 0));
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();

				if (distance[cur.to] < cur.weight) {
					continue;
				}

				for (Edge e : graph[cur.to]) {
					// 정해준 기준치 이상이면 넘어갓
					if (e.weight > mid) {
						continue;
					}

					if (distance[e.to] > e.weight + distance[cur.to]) {
						distance[e.to] = e.weight + distance[cur.to];
						pq.offer(new Edge(e.to, distance[e.to]));
					}
				}
			}
			// Dijkstra END

			// 최종적으로 최소거리(가중치)를 구했을때
			if (distance[B] > C) { // 총 금액이 예산 초과일 경우
				start = mid + 1;
			} else { // 총 금액이 예산 이하일 경우
				answer = mid;
				end = mid - 1;
			}
		}
		// 갈 수 있는 경로가 없으면 -1 출력
		System.out.println((answer == INF) ? -1 : answer);

	}

}
