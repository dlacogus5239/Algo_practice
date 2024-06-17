package binarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main21944 {
	static class Problem implements Comparable<Problem> {
		int num, diff, algo;

		public Problem(int num, int diff, int algo) {
			super();
			this.num = num;
			this.diff = diff;
			this.algo = algo;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.diff != o.diff) {
				return this.diff - o.diff;
			}
			return this.num - o.num;
		}

		@Override
		public String toString() {
			return "Problem [num=" + num + ", diff=" + diff + ", algo=" + algo + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		TreeSet<Problem>[] sets = new TreeSet[101];
		TreeSet<Problem> totalProblem = new TreeSet<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		HashMap<Integer, Integer> hmAlgo = new HashMap<>();
		for (int i = 1; i < 101; i++) {
			sets[i] = new TreeSet<>();
		}
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int diff = Integer.parseInt(st.nextToken());
			int algo = Integer.parseInt(st.nextToken());
			sets[algo].add(new Problem(num, diff, algo));
			totalProblem.add(new Problem(num, diff, algo));
			hm.put(num, diff);
			hmAlgo.put(num, algo);
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			if (oper.equals("add")) // 문제 추가
			{
				int num = Integer.parseInt(st.nextToken());
				int diff = Integer.parseInt(st.nextToken());
				int algo = Integer.parseInt(st.nextToken());
				Problem cur = new Problem(num, diff, algo);
				sets[algo].add(cur);
				totalProblem.add(cur);
				hm.put(num, diff);
				hmAlgo.put(num, algo);
			} else if (oper.equals("recommend")) // 추천방법 1
			{
				int algo = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) { // 어려운거
					sb.append(sets[algo].last().num).append("\n");
				} else { // 쉬운거
					sb.append(sets[algo].first().num).append("\n");
				}

			} else if (oper.equals("recommend2")) // 추천방법 2
			{
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					sb.append(totalProblem.last().num).append("\n");
				} else {
					sb.append(totalProblem.first().num).append("\n");
				}

			} else if (oper.equals("recommend3")) // 추천방법 3
			{
				int num = Integer.parseInt(st.nextToken());
				int diff = Integer.parseInt(st.nextToken());
				if (num == 1) {
					Problem cur = totalProblem.ceiling(new Problem(-1, diff, -1));
					sb.append(cur == null ? "-1" : cur.num).append("\n");
				} else {
					Problem cur = totalProblem.floor(new Problem(-1, diff, -1));
					sb.append(cur == null ? "-1" : cur.num).append("\n");
				}

			} else if (oper.equals("solved")) // 문제 해결
			{
				int num = Integer.parseInt(st.nextToken());
				Problem cur = new Problem(num, hm.get(num), hmAlgo.get(num));
				sets[cur.algo].remove(cur);
				totalProblem.remove(cur);
				hm.remove(num);
				hmAlgo.remove(num);
			}
		}

		System.out.println(sb.toString());

	}

}
