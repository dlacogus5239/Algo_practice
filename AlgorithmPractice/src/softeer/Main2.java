package softeer;

import java.util.*;
import java.io.*;

public class Main2 {
	// 지우는 소수를 좋아해 
	static int N, M;

	static class Edge {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;

		}
	}

	static ArrayList<Edge>[] graph;
	static boolean[] isPrime;
	static int[] distance;

	public static void main(String args[]) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from].add(new Edge(to, weight));
			graph[to].add(new Edge(from, weight));
		}
		Dijkstra();
		StringBuilder sb = new StringBuilder();
		// for(int i = 1; i <= N; i++){
		// sb.append(distance[i] + ", ");
		// }
		// System.out.println(sb.toString());

		for (int i = distance[N] + 1; i < distance[N] * 2; i++) {
			if (i % 2 == 0) {
				continue;
			}
			boolean flag = true;
			for (int j = 2; j * j < i + 1; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println(i);
				break;
			}
		}

	}

	public static void Dijkstra() {
		// 현재 노드, 현재 Node까지의 최소 Level
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		pq.offer(new int[] { 1, 0 });
		distance[1] = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (distance[cur[0]] < cur[1]) {
				continue;
			}
			for (Edge e : graph[cur[0]]) {
				int nextLevel = Math.max(cur[1], e.weight);
				int next = e.to;

				if (nextLevel < distance[next]) {
					distance[next] = nextLevel;
					pq.offer(new int[] { next, nextLevel });
				}

			}
		}

	}

	// 소수 판별 (에라토스테네스의 체)
	// public static void prime(){
	// isPrime[0] = isPrime[1] = true;

	// for(int i = 2; i * i <= 1_000_000_000; i++){
	// if(!isPrime[i]){
	// for(int j = i * i; i <= 1_000_000_000; j += i){
	// isPrime[j] = true;
	// }
	// }
	// }
	// }

}