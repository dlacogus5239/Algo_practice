package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1966 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// 문서의 개수, 몇번째로 인쇄되는지 궁금한 문서 idx
		int N, M;
		StringTokenizer st;
		// test case START
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			// 중요도, idx
			LinkedList<int[]> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int cur = Integer.parseInt(st.nextToken());
				q.offer(new int[] { cur, i });
			}
			int cnt = 0;
			// 구현 시작
			while (!q.isEmpty()) {
				// 큐에서 가장 앞의 문서 중요도 확인
				int[] cur = q.poll();
				boolean flag = true;
				// 나머지 문서들 중에서 현재 문서보다 중요도가 높은 무서가 하나라도 있으면 큐 가장 마지막에 재배치
				for (int i = 0; i < q.size(); i++) {
					if (cur[0] < q.get(i)[0]) {
						q.offer(cur);
						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}

						flag = false;
						break;
					}
				}

				if (!flag) {
					continue;
				}
				cnt++;
				if (cur[1] == M) {
					break;
				}
				// 없으면 출력

			}
			System.out.println(cnt);
		}
		// test case END

	}

}
