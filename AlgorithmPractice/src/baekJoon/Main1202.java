package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1202 {
	// 백준 1202 보석 도둑

	// 1. 보석 무게순으로 오름차순 정렬
	// 2. 가방에 담을 수 있는 최대 무게 오름차순
	// 3. 가격 순서대로 내림차순 정렬을 하는 우선순위 큐 생성
	// 4. 현재 가방이 담을 수 있는 최대 무게보다 작거나 같은 무게를 가진 보석을 우선순위 큐에 담아주기
	// 5. 우선순위 큐의 제일 첫 번째 값(가장 비싼 보석)을 꺼내어서 더해준다
	// 반복

	static int N, K;
	static ArrayList<Jewel> J = new ArrayList<>();

	static class Jewel {
		int weight;
		int value;

		public Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Jewel [weight=" + weight + ", value=" + value + "]";
		}

	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long result = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			J.add(new Jewel(w, v));

		}
		// 처음 보석들은 무게 순으로 정렬
		Collections.sort(J, (o1, o2) -> (o1.weight - o2.weight));

		int[] backpack = new int[K];
		for (int i = 0; i < K; i++) {
			backpack[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		// input END
		Arrays.sort(backpack);
		// 우선순위 큐에 담아줄때는 가격 우선으로 담아준다
		PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
		int idx = 0;
		for (int i = 0; i < backpack.length; i++) {
			int cur = backpack[i];
			while (idx < N && J.get(idx).weight <= backpack[i]) {
				Jewel tmp = J.get(idx++);
				pq.add(new Jewel(tmp.weight, tmp.value));
			}
			if (!pq.isEmpty()) {
				result += pq.poll().value;
			}

		}

		System.out.println(result);

	}

}
