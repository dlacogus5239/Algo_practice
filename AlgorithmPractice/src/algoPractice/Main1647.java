package algoPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1647 {
	// 백준 1647 도시 분할 계획

	static class Edge {
		int from;
		int to;
		int weight;

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

	static int N, M;
	static int[] p;
	static ArrayList<Edge> roads;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// input START
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 노드(집)의 개수
		N = Integer.parseInt(st.nextToken());
		// 간선(길)의 개수
		M = Integer.parseInt(st.nextToken());

		// 간선 배열
		roads = new ArrayList<>();
		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			roads.add(new Edge(from, to, weight));
		}
		br.close();
		// input END

		// 마을을 두 마을로 분할하고 유지비를 최소로 하기 위해선
		// 마을의 MST 구성후, 가장 큰 가중치를 가진 간선을 제거하면 된다.

		// Kruskal

		// 정렬
		roads.sort(new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});

		makeSet();

		int maxRoad = Integer.MIN_VALUE;
		int result = 0;

		// MST를 이루는 간선 중 가장 작은 가중치를 가진 도로를 뺴야 한다
		// 처음에 그냥 가중치가 가장 큰 도로 뺏다가 봉변당함
		for (Edge e : roads) {
			if (unionSet(e.from, e.to)) {
				result += e.weight;
				maxRoad = Math.max(maxRoad, e.weight);
			}
		}

		System.out.println(result - maxRoad);

	}

	public static void makeSet() {
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		return;
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
		if (p[a] == a) {
			return a;
		}
		p[a] = findSet(p[a]);
		return p[a];
	}

}
