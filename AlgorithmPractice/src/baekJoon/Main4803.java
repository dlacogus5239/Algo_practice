package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main4803 {
	static int N, M;
	static boolean[] isVisited;
	static ArrayList<Integer>[] tree;
	// dfs 이용
	// 직전 노드를 제외하고 이미 방문된 노드 방문할 경우에는 싸이클이 있는 경우이다. --> 트리가 아님

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int test_case = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 정점
			M = Integer.parseInt(st.nextToken()); // 간선의 수
			if (N == 0 && M == 0) {
				break;
			}
			isVisited = new boolean[N + 1];
			tree = new ArrayList[N + 1];
			for (int i = 0; i < tree.length; i++) {
				tree[i] = new ArrayList<Integer>();
			} // tree 초기화

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tree[a].add(b);
				tree[b].add(a);
			} // input END

			StringBuilder sb = new StringBuilder();
			int result = 0;
			for (int i = 1; i <= N; i++) {
				if (!isVisited[i]) {
					isVisited[i] = true;
					if (dfs(i, 0)) {
						result++;
					}
				}
			}
			sb.append("Case ").append(test_case).append(": ");
			if (result == 0) {
				sb.append("No trees.\n");
			} else if (result == 1) {
				sb.append("There is one tree.\n");
			} else {
				sb.append("A forest of ").append(result).append(" trees.\n");
			}

			bw.append(sb);
			test_case++;
		}
		bw.flush();
		bw.close();
	}

	// 트리가 아닐 경우 false 반환, 트리일 경우 true 반환
	// start --> 지금 현재
	// pre --> 그 전
	public static boolean dfs(int start, int pre) {
		for (int i = 0; i < tree[start].size(); i++) {
			int cur = tree[start].get(i);
			if (cur == pre) { // 방문하고자 하는 노드가 이전 노드일 경우 pass
				continue;
			}
			if (isVisited[tree[start].get(i)]) { // 이미 방문된 노드일 경우 --> 싸이클 있음. 트리가 아님
				return false;
			}
			isVisited[tree[start].get(i)] = true;
			if (!dfs(tree[start].get(i), start)) { // 더 방문한 결과에서 싸이클이 있으면 트리가 아님
				return false;
			}
		}
		return true;
	}

}
