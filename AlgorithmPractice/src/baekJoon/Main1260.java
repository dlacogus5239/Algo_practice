package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DFS와 BFS
public class Main1260 {
	static int N, M, V;
	static LinkedList<Integer>[] tree;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		isVisited = new boolean[N + 1];
		tree = new LinkedList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree[from].add(to);
			tree[to].add(from);
		}
		for (int i = 0; i < N + 1; i++) {
			tree[i].sort((o1, o2) -> o1 - o2);
//			System.out.println(tree[i].toString());
		}
		dfs(V);
		System.out.println();
		Arrays.fill(isVisited, false);
		bfs(V);
//		for (int i = 0; i < isVisited.length; i++) {
//			System.out.print(isVisited[i] + " ");
//		}

	}

	public static void dfs(int node) {
		System.out.print(node + " ");
		isVisited[node] = true;
		for (int i = 0; i < tree[node].size(); i++) {
			int cur = tree[node].get(i);
			if (!isVisited[cur]) {
				isVisited[cur] = true;
				dfs(cur);
			}
		}

	}

	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			int cur = q.poll();
			isVisited[cur] = true;
			System.out.print(cur + " ");
			for (int i = 0; i < tree[cur].size(); i++) {
//				System.out.print(tree[cur].get(i) + " ");
				if (!isVisited[tree[cur].get(i)]) {
					q.add(tree[cur].get(i));
					isVisited[tree[cur].get(i)] = true;
				}
			}
//			System.out.print(q.toString() + " ");
		}
	}

}