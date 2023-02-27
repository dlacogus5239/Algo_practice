package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1005 {
	// 백준 1005 ACM Craft
	// https://codingnojam.tistory.com/66 --> 위상 정렬 설명
	// 대표적인 위상 정렬이다
	/*
	 * 위상 정렬이란? 순서가 정해져있는 작업들의 목록들을 가지고 전체 작업 순서를 결정하도록 하는 알고리즘!!! 사이클이 없는 방향그래프에서만
	 * 해야한다.
	 */
	static int N, K, W;
	static ArrayList<Integer>[] graph; // 그래프
	static int[] cost; // 비용정보
	static int[] indegree; // 진입차수
	static int[] max; // 각 위치까지 빌딩을 짓는 비용의 최대값

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			graph = new ArrayList[N + 1];
			cost = new int[N + 1];
			indegree = new int[N + 1];
			max = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				indegree[to]++;
			}
			W = Integer.parseInt(br.readLine());
			TopologicalSort();

			System.out.println(max[W]);

		}
	}

	public static void TopologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				max[i] = cost[i];
				q.offer(i);
			}

		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				max[next] = Math.max(max[cur] + cost[next], max[next]);
				indegree[next]--;
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}

	}

}
