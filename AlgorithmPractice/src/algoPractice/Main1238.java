// 알고리즘 정답보고 한것들 정리
package algoPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1238 {
	// 백준 1238 파티 (다익스트라 알고리즘)
	static int N, M, X;
	static final int INF = 999_999_999;

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

		public String toString() {
			return "[" + to + ", " + weight + "]";
		}
	}

	static ArrayList<Edge>[] list;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// input START
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Edge(to, weight));

		}
		br.close();

		// input END

		int[][] distances = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			distances[i] = Dijkstra(i);
		}

		int[] Xdistance = new int[N + 1];
		Xdistance = Dijkstra(X);

		int result = Integer.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			result = Math.max(result, Xdistance[i] + distances[i][X]);
		}

//		for (int i = 1; i < N + 1; i++) {
//			for (int j = 0; j < N + 1; j++) {
//				System.out.print(distances[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		System.out.println("======");
//		for (int i = 1; i < Xdistance.length; i++) {
//			System.out.print(Xdistance[i] + " ");
//		}
		System.out.println(result);
	}

	public static int[] Dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		boolean[] isVisited = new boolean[N + 1];
		int[] tmpDist = new int[N + 1];
		Arrays.fill(tmpDist, INF);
		tmpDist[start] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curNo = cur.to;

			if (!isVisited[curNo]) {
				isVisited[curNo] = true;
				for (Edge e : list[curNo]) {
					if (!isVisited[e.to] && (tmpDist[e.to] > tmpDist[curNo] + e.weight)) {
						tmpDist[e.to] = tmpDist[curNo] + e.weight;
						pq.offer(new Edge(e.to, tmpDist[e.to]));
					}
				}
			}
		}

		return tmpDist;
	}

}
