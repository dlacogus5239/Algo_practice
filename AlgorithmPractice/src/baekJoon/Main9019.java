package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9019 {
	// 백준 9019 DSLR
	static int start, end;
	static String[] answer;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			answer = new String[10000];
			isVisited = new boolean[10000];
			Arrays.fill(answer, "");
			bfs(start);
			System.out.println(answer[end]);
		}

	}

	public static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();

		q.offer(num);
		isVisited[num] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			int D = D(cur);
			int S = S(cur);
			int L = L(cur);
			int R = R(cur);
//			System.out.println(D + ", " + S + ", " + L + ", " + R);
			if (cur == end) {
				return;
			}

			if (!isVisited[D]) {
				q.offer(D);
				answer[D] = answer[cur] + "D";
				isVisited[D] = true;
			}
			if (!isVisited[S]) {
				q.offer(S);
				answer[S] = answer[cur] + "S";
				isVisited[S] = true;
			}
			if (!isVisited[L]) {
				q.offer(L);
				answer[L] = answer[cur] + "L";
				isVisited[L] = true;
			}
			if (!isVisited[R]) {
				q.offer(R);
				answer[R] = answer[cur] + "R";
				isVisited[R] = true;
			}

		}
	}

	// DSLR 동작 구현

	// N * 2
	public static int D(int num) {
		return (num * 2) % 10000;
	}

	// N - 1
	public static int S(int num) {
		return num == 0 ? 9999 : num - 1;
	}

	// d2 d3 d4 d1
	public static int L(int num) {

		return (num % 1000) * 10 + num / 1000;
	}

	// d4 d1 d2 d3
	public static int R(int num) {

		return (num % 10) * 1000 + num / 10;
	}

}
