package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
// 실버 2
public class Main1012 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	// 세로 (y)
	static int N;
	// 가로 (x)
	static int M;
	// 배추 위치의 개수
	static int K;
	// Map
	static int[][] map;
	static boolean[][] isVisited;
	static int result;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			isVisited = new boolean[N][M];

			int x, y;
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (map[j][j2] == 1 && !isVisited[j][j2]) {
						bfs(j2, j);
						result += 1;
					}
				}
			}
			System.out.println(result);
		}
	}
//
	public static void dfs(int x, int y) {
		if (isVisited[y][x]) {
			return;
		}
		isVisited[y][x] = true;
		for (int d = 0; d < 4; d++) {
			if (isIn(x + dx[d], y + dy[d]) && !isVisited[y + dy[d]][x + dx[d]] && map[y + dy[d]][x + dx[d]] == 1) {
				dfs(x + dx[d], y + dy[d]);
			}
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		isVisited[y][x] = true;
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			isVisited[tmp[1]][tmp[0]] = true;
			for (int d = 0; d < 4; d++) {
				int next_x = tmp[0] + dx[d];
				int next_y = tmp[1] + dy[d];
				if (isIn(next_x, next_y) && !isVisited[next_y][next_x] && map[next_y][next_x] == 1) {
					q.add(new int[] { next_x, next_y });
					isVisited[next_y][next_x] = true;
					
				}
			}

		}

	}

	// 배열(map)안인지
	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= M || y >= N) {
			return false;
		}
		return true;
	}

}