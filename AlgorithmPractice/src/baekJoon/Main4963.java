package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4963 {
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dx = { 0, 0, -1, 1, 1, -1, 1, -1 };
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int H;
	static int W;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) {
				break;
			}
			map = new int[H][W];
			isVisited = new boolean[H][W];
			for (int i = 0; i < H; i++) {

				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!isVisited[i][j] && map[i][j] == 1) {
						dfs(j, i);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	public static void dfs(int x, int y) {
		isVisited[y][x] = true;
		for (int i = 0; i < dx.length; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			if (isIn(next_x, next_y) && !isVisited[next_y][next_x] && map[next_y][next_x] == 1) {
				dfs(next_x, next_y);
			}
		}
	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= W || y >= H) {
			return false;
		}
		return true;
	}
}