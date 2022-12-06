package baekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1697{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수빈이 위치
		int K = sc.nextInt(); // 동생 위치
		int[] isVisited = new int[1000000];
		// 수빈이가 동생을 찾아감

		// 순간이동은 (현재 위치 * 2)
		// 걷는건 (현재 위치 + 1)

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		int cur = 0;
		isVisited[N] = 1;
		while (!q.isEmpty()) {
			cur = q.poll(); // 수빈이의 현재 위치
			if (cur == K) {
				break;
			}
			if (isIn(cur * 2) && isVisited[cur * 2] == 0) {
				isVisited[cur * 2] = isVisited[cur] + 1;
				q.offer(cur * 2);
			}
			if (isIn(cur + 1) && isVisited[cur + 1] == 0) {
				isVisited[cur + 1] = isVisited[cur] + 1;
				q.offer(cur + 1);
			}
			if (isIn(cur - 1) && isVisited[cur - 1] == 0) {
				isVisited[cur - 1] = isVisited[cur] + 1;
				q.offer(cur - 1);
			}
		}
		System.out.println(isVisited[cur] - 1);
	}

	public static boolean isIn(int x) {
		if (x < 0 || x >= 1000000) {
			return false;
		}
		return true;
	}

}