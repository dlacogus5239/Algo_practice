package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}

}

public class Main1197 {

	static int V, E;
	static int[] p;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ArrayList<Edge> edges = new ArrayList<>();
		p = new int[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges.add(new Edge(from, to, weight));
		}
		edges.sort((o1, o2) -> (o1.weight - o2.weight));
		makeSet();
		int result = 0;
		for (int i = 0; i < E; i++) {
			Edge e = edges.get(i);
			if (unionSet(e.from, e.to)) {
				result += e.weight;
			}
		}
		System.out.println(result);

	}

	public static void makeSet() {
		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
	}

	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		p[bRoot] = aRoot;
		return true;
	}

	public static int findSet(int a) {
		if (a == p[a]) {
			return a;
		}
		p[a] = findSet(p[a]);
		return p[a];
	}

}