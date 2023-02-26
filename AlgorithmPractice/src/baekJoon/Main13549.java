package baekJoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main13549 {
	// 백준 13549 숨바꼭질 3

	static int[] distance;
	static boolean[] isVisited;
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		// input END

		distance = new int[1000001];
		isVisited = new boolean[1000001];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[N] = 0;

		bfs(N);

		System.out.println(distance[K]);
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		isVisited[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			isVisited[cur] = true;
			if (cur == K) {
				break;
			}
			if (isIn(cur + 1) && !isVisited[cur + 1]) {
				q.add(cur + 1);
				distance[cur + 1] = Math.min(distance[cur + 1], distance[cur] + 1);
			}
			if (isIn(cur - 1) && !isVisited[cur - 1]) {
				q.add(cur - 1);
				distance[cur - 1] = Math.min(distance[cur - 1], distance[cur] + 1);
			}
			if (isIn(cur * 2) && !isVisited[cur * 2]) {
				q.add(cur * 2);
				distance[cur * 2] = Math.min(distance[cur * 2], distance[cur]);
			}

		}
	}

	public static boolean isIn(int x) {
		if (x < 0 || x >= 1000001) {
			return false;
		}
		return true;
	}

}
