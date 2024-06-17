package binarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main21939 {

	static class Problem implements Comparable<Problem> {
		int num, diff;

		public Problem(int num, int diff) {
			super();
			this.num = num;
			this.diff = diff;
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
			return "Problem [num=" + num + ", diff=" + diff + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		TreeSet<Problem> ts = new TreeSet<>();
		HashMap<Integer, Integer> hm = new HashMap<>(); // 각 문제 번호마다 난이도를 저장하기 위함. --> 이걸 통해서 삭제 진행

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int diff = Integer.parseInt(st.nextToken());
			ts.add(new Problem(num, diff));
			hm.put(num, diff);
		}
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			if (oper.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				int diff = Integer.parseInt(st.nextToken());
				ts.add(new Problem(num, diff));
				hm.put(num, diff);
			} else if (oper.equals("recommend")) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) { // 가장 어려운거 출력
					sb.append(ts.last().num).append("\n");
				} else if (num == -1) { // 가장 쉬운거 출력
					sb.append(ts.first().num).append("\n");
				}
			} else if (oper.equals("solved")) {
				int num = Integer.parseInt(st.nextToken());
				ts.remove(new Problem(num, hm.get(num)));
				hm.remove(num);
			} else {
				System.out.println("OPERATION ERROR");
			}
		}

		System.out.println(sb.toString());
	}

}
