package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1927 {
	// 백준 1927 최소 힙
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			if (cur == 0) {
				if (pq.isEmpty()) {
					sb.append(0);
				} else {
					sb.append(pq.poll());
				}
				sb.append("\n");
			} else {
				pq.offer(cur);
			}
		}
		System.out.println(sb.toString());
	}

}
