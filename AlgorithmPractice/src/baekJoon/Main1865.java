package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1865 {
	// 백준 1865 웜홀
	static class Edge implements Comparable<Edge> {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	static int N, M, W;
	static ArrayList<Edge>[] map;

	// 벨만-포드 알고리즘
	/*
	 * 1. 출발 노드 설정
	 * 2. 최단 거리 테이블 초기화
	 * 3. 다음 과정 반복
	 * 	3-1. 모든 간선 확인
	 * 	3-2. 각 간선을 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블 갱신
	 *  만약 음수 간선 순환이 발생하는지 체크하고 싶다면 3번 과정을 한번 더 수행. 이때 최단 거리 테이블이 갱신된다면 음수 간선 순환 존재
	 *  
	 *  */
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				map[i] = new ArrayList<Edge>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				map[from].add(new Edge(to, cost));
				map[to].add(new Edge(from, cost));
			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = -(Integer.parseInt(st.nextToken()));
				map[from].add(new Edge(to, cost));
			}
		}
	}

}
