package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238 {
	static ArrayList<Integer>[] graph;
	static int[] depth;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			graph = new ArrayList[101];
			depth = new int[101];
			Arrays.fill(depth, -1);
			for (int i = 0; i <= 100; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from].add(to);
			}
			bfs(V);
			int ans = 0;
			result = depth[0];
			for (int i = 0; i < depth.length; i++) {
				if (result <= depth[i]) {
					result = depth[i];
					ans = i;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}

	}

	public static void bfs(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(V);
		depth[V]++;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < graph[tmp].size(); i++) {
				if (depth[graph[tmp].get(i)] == -1) {
					q.offer(graph[tmp].get(i));
					depth[graph[tmp].get(i)] = depth[tmp] + 1;
				}
			}

		}
	}

}
