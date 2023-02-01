package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916 {
	// 백준 1916 최소비용 구하기
	// 다익스트라

	// 도시의 개수(노드)
	static int N;
	// 버스의 개수(간선)
	static int M;
	static ArrayList<Edge>[] map;
	static int[] distance;
	static int resTo, resFrom;
	static boolean[] isVisited;

	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		// 우선순위 큐 (priorityQueue 사용하기 위해서)
		// 우선순위 큐 관련은 찾아보기
		// 우선순위가 있는 큐로, 큐에서 poll될때 우선순위가 높은 요소부터 나온다.
		// 다익스트라는 최소 거리인 노드부터 탐색하게 해야함.
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		StringTokenizer st;
		map = new ArrayList[N + 1];
		distance = new int[N + 1];
		isVisited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			map[from].add(new Edge(to, cost));
		}

		st = new StringTokenizer(br.readLine());

		// 어디서부터 어디까지 최솟값 구하는지
		resFrom = Integer.parseInt(st.nextToken());
		resTo = Integer.parseInt(st.nextToken());

		// input END
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[resFrom] = 0;
		dijkstra(resFrom);
		System.out.println(distance[resTo]);

//		System.out.println(Arrays.toString(distance));

	}

	
	// 다익스트라 알고리즘. --> 우선순위 큐
	/* 
	 * 다익스트라 알고리즘
	 * 
	 * 1. 출발노드와 도착 노드 설정
	 * 2. 최단 거리 테이블(distance) 초기화
	 * 3. 현재 위치한 노드의 인접 노드 중 방문하지 않은 노드 구별
	 * 	3-1. 방문하지 않은 노드 중 거리가 가장 짧은 노드 선택 --> 우선순위 큐 이용!
	 * 	3-2. 방문처리
	 * 4. 해당 노드를 거쳐 다른 노드로 넘어가는 간선비용을 계산해 최단 거리 테이블(distance)업데이트
	 * 
	 * */
	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (!isVisited[cur.to]) {
				isVisited[cur.to] = true;
				for (Edge e : map[cur.to]) {
					int nextDistance = e.cost + cur.cost;
					if (nextDistance < distance[e.to]) {
						distance[e.to] = nextDistance;
						pq.offer(new Edge(e.to, nextDistance));
					}
				}
			}
		}
	}

}
