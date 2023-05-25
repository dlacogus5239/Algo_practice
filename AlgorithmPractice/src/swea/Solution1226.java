package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1226 {
	// SWEA 1226 미로 1
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Test Case START
		for (int t = 1; t <= 10; t++) {
			map = new int[16][16];
			int testNum = Integer.parseInt(br.readLine());
			int[] start = new int[2];
			int[] end = new int[2];

			// map input START
			for (int i = 0; i < 16; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < 16; j++) {
					map[i][j] = Integer.parseInt(input[j]);
					if (map[i][j] == 2) {
						start[0] = j;
						start[1] = i;
					}
					if (map[i][j] == 3) {
						end[0] = j;
						end[1] = i;
					}
				}
			}
			// map input END

			// search
			bfs(start[0], start[1]);

			sb.append("#").append(testNum).append(" ").append(map[end[1]][end[0]] == 4 ? "1" : "0").append("\n");

		}
		// Test Case END

		// out

		System.out.println(sb.toString());

	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (!isIn(nx, ny)) {
					continue;
				}
				if (map[ny][nx] == 0 || map[ny][nx] == 3) {
					q.offer(new int[] { nx, ny });
					map[ny][nx] = 4;
				}
			}

		}

	}

	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= 16 || y >= 16);
	}

}
