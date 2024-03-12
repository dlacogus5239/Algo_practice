package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상 정렬
public class Main2252 {
	// 학생 수, 키를 비교한 횟수
	static int N, M;

	static ArrayList<Integer>[] graph;
	// 진입차수
	static int[] nodeIn;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		nodeIn = new int[N + 1];
		// graph init
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			nodeIn[B]++;
		}
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (nodeIn[i] == 0) {
				q.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			int len = graph[cur].size();
			for (int i = 0; i < len; i++) {
				int tmp = graph[cur].get(i);
				nodeIn[tmp]--;
				if (nodeIn[tmp] == 0) {
					q.offer(tmp);
				}
			}

			graph[cur].clear();
		}

		System.out.println(sb.toString());
	}

}
