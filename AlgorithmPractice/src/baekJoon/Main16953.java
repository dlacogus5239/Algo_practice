package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16953 {
	// 백준 16953 A -> B
	static long A, B;
	static int result = -1;
	static int cnt = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		System.out.println(bfs(A));
	}

	public static int bfs(long n) {
		Queue<Long> q = new LinkedList<>();
		q.add(n);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				long cur = q.poll();

				if (cur == B) {
					return cnt + 1;
				}

				if (cur * 2 <= B) {
					q.offer(cur * 2);
				}
				if (cur * 10 + 1 <= B) {
					q.offer(cur * 10 + 1);
				}
			}
			cnt++;
		}
		return -1;
	}

}
