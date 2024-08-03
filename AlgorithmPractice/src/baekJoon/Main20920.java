package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main20920 {
	// 백준 20920 영단어 암기는 괴로워
	static class Word implements Comparable<Word> {
		int cnt;
		String word;
		int length;

		public Word(int cnt, String word, int length) {
			super();
			this.cnt = cnt;
			this.word = word;
			this.length = length;
		}

		@Override
		public int compareTo(Word o) {
			if (this.cnt != o.cnt) {
				return o.cnt - this.cnt;
			} else if (this.length != o.length) {
				return o.length - this.length;
			}
			return this.word.compareTo(o.word);
		}

		@Override
		public String toString() {
			return "Word [cnt=" + cnt + ", word=" + word + ", length=" + length + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.length() < M) {
				continue;
			}
			hm.put(input, hm.getOrDefault(input, 0) + 1);
		}
		PriorityQueue<Word> pq = new PriorityQueue<>();
		for (String s : hm.keySet()) {
			pq.offer(new Word(hm.get(s), s, s.length()));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Word cur = pq.poll();

			sb.append(cur.word).append("\n");
		}

		System.out.println(sb.toString());
	}

}
