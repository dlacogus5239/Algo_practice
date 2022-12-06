package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {
	static int[][] map;
	static int[][] date;
	static int M, N;
	static boolean[][] isVisited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static ArrayList<int[]> tomato;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		date = new int[N][M];
		isVisited = new boolean[N][M];
		tomato = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					tomato.add(new int[] { j, i });
				}
			}
		}
		// 익은 날짜를 배열에 저장하는 식으로 해보자
		Queue<int[]> q = new LinkedList<int[]>(); // {x, y}
		for (int i = 0; i < tomato.size(); i++) {
			q.offer(new int[] { tomato.get(i)[0], tomato.get(i)[1] });
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (!isVisited[tmp[1]][tmp[0]]) {
				isVisited[tmp[1]][tmp[0]] = true;
				for (int d = 0; d < dx.length; d++) {
					int next_x = tmp[0] + dx[d];
					int next_y = tmp[1] + dy[d];
					if (isIn(next_x, next_y) && !isVisited[next_y][next_x] && map[next_y][next_x] == 0) {
						date[next_y][next_x] = date[tmp[1]][tmp[0]] + 1;
						map[next_y][next_x] = 1;
						q.offer(new int[] { next_x, next_y });
					}

				}
			}
		}
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println("-1");
					return;
				}
				result = Math.max(result, date[i][j]);
//				System.out.print(date[i][j] + " ");
			}
//			System.out.println();
		}
		System.out.println(result);

	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= M || y >= N) {
			return false;
		} else {
			return true;
		}
	}

}