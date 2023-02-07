package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution0207_4 {

	public int solution(int[] A, int[] B) {
		int answer = 0;
		PriorityQueue<Integer> pq_a = new PriorityQueue<>();
		PriorityQueue<Integer> pq_b = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < A.length; i++) {
			pq_a.add(A[i]);
			pq_b.add(B[i]);
		}
		while (!pq_a.isEmpty()) {
			answer += pq_a.poll() * pq_b.poll();
		}

		return answer;
	}

}
