package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {
	static int[][] map;
	static int N, M;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] isVisited;
	static int totalCheese;
	static int curCheese;
	static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		totalCheese = 0;
		time = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					totalCheese++;
				}
			}
		}

		// input END
		
		// 0, 즉 공기를 중심으로 bfs
		// 전체 맵을 계속 처음부터 탐색하면서, 너비우선 탐색을 진행한다.
		// 공기를 중심으로 치즈인 부분을 너비우선  탐색을 한번 실행하면, 공기와 맞닿은 치즈를 찾아서 녹일 수 있다.
		while (totalCheese != 0) {
			curCheese = totalCheese;
			time++;
			isVisited = new boolean[N][M];
			bfs(0, 0);
		}
		System.out.println(time);
		System.out.println(curCheese);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		isVisited[y][x] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			for (int d = 0; d < 4; d++) {
				int next_x = cur_x + dx[d];
				int next_y = cur_y + dy[d];
				if (isIn(next_x, next_y) && !isVisited[next_y][next_x]) {
					isVisited[next_y][next_x] = true;
					if (map[next_y][next_x] == 0) {
						q.offer(new int[] { next_x, next_y });
					} else {
						totalCheese--;
						map[next_y][next_x] = 0;
					}
				}
			}
		}
	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= M || y >= N) {
			return false;
		}
		return true;
	}

}