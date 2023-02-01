package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1167 : 트리의 지름
public class Main1167 {

	// 23.01.31 Hint
	/*
	 * 
	 * 한 정점에서 가장 먼 정점을 구하면 트리의 지름을 이루는 정점 중 하나를 구할 수 있다.
	 * 
	 * 지름을 이루는 정점 하나를 구하면 그 정점에서 가장 먼 정점까지의 거리가 트리의 지름!
	 * 
	 */
	static class Node {
		int to;
		int cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", cost=" + cost + "]";
		}

	}

	static int V;
	static ArrayList<Node>[] tree;
	static int diameterNodeFrom, diameterNodeTo;
	static int result, distance;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		StringTokenizer st;

		// 트리 초기화
		tree = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) {
					break;
				}
				int cost = Integer.parseInt(st.nextToken());
				tree[from].add(new Node(to, cost));
			}
		}

		// 트리 체킹용
//		for (int i = 1; i <= V; i++) {
//			for (int j = 0; j < tree[i].size(); j++) {
//				System.out.print(tree[i].get(j).toString() + " ");
//			}
//			System.out.println();
//		}
		distance = 0;
		isVisited = new boolean[V + 1];
		dfs(1, 0);
		isVisited = new boolean[V + 1];
		dfs(diameterNodeFrom, 0);
		System.out.println(distance);
	}

	public static void dfs(int n, int curDis) {

		if (curDis > distance) {
			distance = curDis;
			diameterNodeFrom = n;
		}
		isVisited[n] = true;

		for (int i = 0; i < tree[n].size(); i++) {
			Node cur = tree[n].get(i);
			if (!isVisited[cur.to]) {
				dfs(cur.to, curDis + cur.cost);
				isVisited[cur.to] = true;
			}
		}

	}

}
