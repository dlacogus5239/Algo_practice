package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753 {
	public static class Node implements Comparable<Node> {
		int v;
		int weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());
		ArrayList<Node>[] Matrix = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			Matrix[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			Matrix[from].add(new Node(to, weight));
		}

		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		int[] distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			int v = n.v;
			int weight = n.weight;
			if (distance[v] < weight) {
				continue;
			}

			for (int i = 0; i < Matrix[v].size(); i++) {
				int v2 = Matrix[v].get(i).v;
				int weight2 = Matrix[v].get(i).weight + weight;
				if (distance[v2] > weight2) {
					distance[v2] = weight2;
					q.offer(new Node(v2, weight2));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}

	}

}