package dx_pre;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1 {
	// 학생 수 N, 마니또 관계의 수 M
	static int N, M;
	static ArrayList<Node>[] graph;

	// 최소비용
	static int result;
	// 이미 탐색한 노드인지(탐색한 노드인 경우 다시 탐색하지 않는다)
	static boolean[] done;

	// 방문체크
	static boolean[] isVisited;

	static class Node implements Comparable<Node> {
		int to;
		int weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			// 방문, 탐색노드 배열 초기화
			done = new boolean[N + 1];
			isVisited = new boolean[N + 1];
			// 방향 그래프 정보 저장
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph[from].add(new Node(to, weight));
			}
			// test case Input END

			// 싸이클이 일어날때의 결과값 저장용
			int tmp = 0;

			for (int i = 1; i <= N; i++) {
				isVisited = new boolean[N + 1];
				int next = graph[i].get(0).to;
				System.out.println(i + ", " + next);
				dfs(next, i, graph[i].get(0).weight);
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int cur, int start, int cost) {
		// 사이클 형성
		if (cur == start) {
			result = Math.min(result, cost);
			return;
		}
		for (int i = 1; i < graph[cur].size(); i++) {
			int next = graph[cur].get(i).to;
			dfs(next, start, cost + graph[cur].get(i).weight);

		}
	}

}
