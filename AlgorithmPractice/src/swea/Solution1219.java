package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1219 {
	// SWEA 1219 길찾기
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// test case START
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());

			// Node 개수
			N = Integer.parseInt(st.nextToken());
			isVisited = new boolean[100];
			// 간선 저장 그래프
			graph = new ArrayList[100];

			// graph init
			for (int i = 0; i < 100; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			isVisited[0] = true;
			dfs(0);
			int result = isVisited[99] ? 1 : 0;
			sb.append("#" + T + " ").append(result).append("\n");

		}
		// test case END

		// output

		System.out.println(sb.toString());
	}

	public static void dfs(int cur) {

		for (int i = 0; i < graph[cur].size(); i++) {
			int next = graph[cur].get(i);
			if (!isVisited[next]) {
				isVisited[next] = true;
				dfs(next);
			}
		}

		return;
	}

}
