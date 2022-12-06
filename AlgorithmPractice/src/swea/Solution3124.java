package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 코드 걍 똑같은데 왜 안되는지 모르겠음 -->다른코드 복붙해둠

public class Solution3124 {
	static int n, m;
	static int[] parents;
	static Edge[] edgeList;

	// 간선
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(from).append(", ").append(to).append(", ").append(weight).append("]");
			return builder.toString();
		}

	}

	// ------------ 서로소 집합-------------//
	// 각 사람들을 초기화 해준다.
	// 처음은 다 자기 자신이 부모
	static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int num) {
		// 자신이 root이면 반환
		if (parents[num] == num)
			return num;
		// path compression을 하여 해당 노드를 최상위 노드 바로 밑에 붙게 한다.
		return parents[num] = findSet(parents[num]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) // a와 b의 root가 같으면, 같은 집합이므로 종료
			return false;
		int Min_Parent = Math.min(aRoot, bRoot); // 최대한 한쪽으로 몰아 넣는다.
		parents[aRoot] = Min_Parent;
		parents[bRoot] = Min_Parent;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int tc = stoi(br.readLine());

		for (int tidx = 1; tidx <= tc; tidx++) {
			stk = new StringTokenizer(br.readLine());
			n = stoi(stk.nextToken());
			m = stoi(stk.nextToken());
			edgeList = new Edge[m];
			parents = new int[n + 1];

			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				edgeList[i] = new Edge(stoi(stk.nextToken()), stoi(stk.nextToken()), stoi(stk.nextToken()));
			}

			Arrays.sort(edgeList); // 가중치가 적은 순으로 간선들을 정렬한다.

			make();
			long result = 0;
			int count = 0; // 선택한 간선 수

			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) { // 만약 사이클이 존재하게 되면 root가 같으므로, 해당 간선은 넘긴다.
					result += edge.weight;
					if (++count == n - 1) {
						break;
					}
				}
			}

			System.out.println("#" + tidx + " " + result);
		}

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
