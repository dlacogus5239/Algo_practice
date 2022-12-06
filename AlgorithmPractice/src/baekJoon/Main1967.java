package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리의 지름
public class Main1967 {
	static class Node {
		int to;
		int weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static int N; // 노드의 개수
	static boolean[] isVisited;
	static ArrayList<Node>[] tree;
	static int maxDistance = 0; // 가장 긴 거리

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<Node>();
		} // ArrayList Init

		// map [from][to] = weight 의 값..
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree[from].add(new Node(to, weight));
			tree[to].add(new Node(from, weight));
		}
		// input END
		for (int i = 1; i < N + 1; i++) {
			isVisited = new boolean[N + 1];
			dfs(i, 0);
		}
		System.out.println(maxDistance);
	}

	public static void dfs(int cur, int distance) {
		isVisited[cur] = true;
		maxDistance = Math.max(maxDistance, distance);

		for (Node n : tree[cur]) {
			if (!isVisited[n.to]) {
				isVisited[n.to] = true;
				dfs(n.to, distance + n.weight);
			}
		}
	}

}