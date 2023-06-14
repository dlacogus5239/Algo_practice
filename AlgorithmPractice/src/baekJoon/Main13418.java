package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main13418 {
	// 백준 13418 학교 탐방하기
	static int N, M;
	static int startRoad;

	static class Edge {
		int from, to, weight;
		// 여기서 weight 0 -> 오르막길, 1 -> 내리막길

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

	}

	static ArrayList<Edge> map;
	static int[] p;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// input START
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList<>();

		for (int i = 0; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if (from == 0) {
				startRoad = weight;
				continue;
			}
			map.add(new Edge(from, to, weight));
		}

		// 최악의 경우
		int worst = 0;
		// Dijsktra
		map.sort(new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				if (o2.weight == o1.weight) {
					return o1.from - o2.from;
				}
				return o1.weight - o2.weight;
			}
		});
		makeSet();
		for (Edge e : map) {
			if (unionSet(e.from, e.to)) {
				if (e.weight == 0) {
					worst++;
				}
			}
		}
		worst = startRoad == 0 ? worst + 1 : worst;
//		System.out.println(map.toString());
//		for (int i = 0; i <= N; i++) {
//			System.out.print(p[i] + " ");
//		}

//		System.out.println(worst);

		// 최적의 경우
		int best = 0;
		// Dijsktra
		map.sort(new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				if (o2.weight == o1.weight) {
					return o1.from - o2.from;
				}
				return o2.weight - o1.weight;
			}
		});
		makeSet();
		for (Edge e : map) {
			if (unionSet(e.from, e.to)) {
				if (e.weight == 0) {
					best++;
				}
			}

		}
//		System.out.println(best);
		best = startRoad == 0 ? best + 1 : best;
		System.out.println((int) (Math.pow(worst, 2) - Math.pow(best, 2)));

	}

	// unionSet

	public static void makeSet() {
		p = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}

		unionSet(0, 1);
	}

	public static int findSet(int a) {
		if (a == p[a]) {
			return a;
		}

		p[a] = findSet(p[a]);

		return p[a];
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

}
