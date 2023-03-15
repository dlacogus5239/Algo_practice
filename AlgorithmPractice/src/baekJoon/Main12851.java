package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12851 {
	// 백준 12851 숨바꼭질 2
	static int N, K;
	static int[] map = new int[100001];
	static int min = Integer.MAX_VALUE;
	static int cnt = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(map, 0);

		// 수빈이가 앞에 있을 경우는 뒤로 갈 수 밖에 없다.
		// 이 경우 예외처리 !
		if (N >= K) {
			System.out.println(N - K);
			System.out.println(1);
			return;
		}

		bfs(N);
		System.out.println(map[K]);
		System.out.println(cnt);

	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		map[start] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (min < map[cur]) {
				return;
			}
			int[] arr = { cur + 1, cur - 1, cur * 2 };
			for (int tmp : arr) {
				if (!isIn(tmp)) {
					continue;
				}
				if (tmp == K) {
					min = map[cur];
					cnt++;
				}

				if (map[tmp] == 0 || map[tmp] == map[cur] + 1) {
					q.add(tmp);
					map[tmp] = map[cur] + 1;
				}
			}

		}

	}

	public static boolean isIn(int x) {
		return !(x < 0 || x >= 100001);
	}

}
