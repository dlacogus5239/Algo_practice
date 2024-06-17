package binarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1202 {
	static class Gem {
		int weight, value;

		public Gem(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Gem [weight=" + weight + ", value=" + value + "]";
		}

	}

	// 이 문제 핵심은
	// 가방에 담을 수 있는 보석 전부를 가려낸 후
	// 그 중 가치가 높은것들을 꺼내서 계산! (vPQ --> Value PQ)
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Gem> Gems = new ArrayList<>();
		PriorityQueue<Gem> vPQ = new PriorityQueue<>((o1, o2) -> (o2.value - o1.value));
		int N = Integer.parseInt(st.nextToken()); // 보석의 총 개수
		int K = Integer.parseInt(st.nextToken()); // 가방의 총 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken()); // 무게 입력
			int V = Integer.parseInt(st.nextToken()); // 가치 입력
			Gems.add(new Gem(M, V));
		}
		Collections.sort(Gems, (o1, o2) -> (o1.weight - o2.weight));
		int[] backpack = new int[K];
		for (int i = 0; i < backpack.length; i++) {
			backpack[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(backpack);

		long answer = 0L;
		int idx = 0;
		for (int i = 0; i < backpack.length; i++) {
			int curMax = backpack[i];
			// 오름차순 정렬되어 있다. 현재 가방의 무게보다 작거나 같은 무게는 전부 우선순위 큐에 담아주자
			while (idx < N && Gems.get(idx).weight <= curMax) {
				Gem cur = Gems.get(idx++);
				vPQ.offer(new Gem(cur.weight, cur.value));
			}
			// 현재 담을 수 있는거 이상으로 나오면
			// 큐에서 꺼내서 더해주자
			if (!vPQ.isEmpty()) {
				answer += vPQ.poll().value;
			}
		}

		System.out.println(answer);
	}

}
