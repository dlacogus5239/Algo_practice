package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2667 {
	// 백준 2667 단지번호붙이기
	static int N;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] isVisited;
	static int cnt;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		br.close();
		// input END
		cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !isVisited[i][j]) {
					bfs(j, i);
				}
			}
		}

		int[] nums = new int[cnt];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					nums[map[i][j] - 1]++;
				}
			}
		}

		Arrays.sort(nums);
		System.out.println(cnt);

		for (int i = 0; i < cnt; i++) {
			System.out.println(nums[i]);
		}

	}

	public static void bfs(int x, int y) {
		cnt++;
		Queue<int[]> q = new LinkedList<>();
		map[y][x] = cnt;
		q.offer(new int[] { x, y });

		isVisited[y][x] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (!isIn(nx, ny))
					continue;

				if (map[ny][nx] == 1 && !isVisited[ny][nx]) {
					isVisited[ny][nx] = true;
					q.offer(new int[] { nx, ny });
					map[ny][nx] = cnt;
				}
			}

		}
	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= N || y >= N);
	}

}
