package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11724 {
	// 백준 11724 연결 요소의 개수

	// 정점의 개수 N, 간선의 개수 M
	static int N, M;
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	static int result = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];

		// ArrayList Init
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
			graph[to].add(from);

		}

		for (int i = 1; i <= N; i++) {
			if (!isVisited[i]) {
				result++;
				dfs(i);
			}
		}
		System.out.println(result);

	}

	public static void dfs(int n) {
		isVisited[n] = true;
		for (int i = 0; i < graph[n].size(); i++) {
			int cur = graph[n].get(i);
			if (!isVisited[cur]) {
				isVisited[cur] = true;
				dfs(cur);
			}
		}
	}

	public static boolean isIn(int n) {
		return !(n <= 0 || n > N);
	}

}
