package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16928 {
	// 백준 16928 뱀과 사다리 게임
	static int N, M;
	static int[] map = new int[101];
	// 이동횟수 저장
	static int[] distance = new int[101];
	static final int INF = 999_999_999;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i < 101; i++) {
			map[i] = i;
		}

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a] = b;
		}
		Arrays.fill(distance, INF);
		distance[1] = 0;

		bfs();
//		for (int i = 1; i < 101; i++) {
//			System.out.print(distance[i] + " ");
//		}
//		System.out.println();
		System.out.println(distance[100]);

	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		boolean[] isVisited = new boolean[101];
		isVisited[1] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == 100) {
				break;
			}
			for (int i = 1; i <= 6; i++) {
				int nx = cur + i;
				// 100 초과면 탈출

				if (!isIn(nx) || isVisited[nx]) {
					continue;
				}
				distance[map[nx]] = Math.min(distance[map[nx]], distance[cur] + 1);

				q.offer(map[nx]);
				isVisited[map[nx]] = true;
			}
		}
	}

	public static boolean isIn(int x) {
		return !(x > 100);
	}

}
