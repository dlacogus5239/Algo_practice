package codeTreeSamsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main42 {
	static int N, K;
	static int[][] map, rottenMap;
	static boolean[][] isVisited;
	static ArrayList<int[]> rotten = new ArrayList<>();

//	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
//	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		rottenMap = new int[N][N];
		isVisited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0) {
					rottenMap[i][j] = -1;
				} else if (map[i][j] == 2) {
					rotten.add(new int[] { i, j });
				} else {
					rottenMap[i][j] = -2;
				}

			}
		}

		BFS();
		PrintMap(rottenMap);
	}

	public static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < K; i++) { // 초기 썩은 귤 추가
			int[] cur = rotten.get(i);

			q.offer(new int[] { cur[0], cur[1], 0 });
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			isVisited[cur[0]][cur[1]] = true;
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (!isIn(nr, nc)) {
					continue;
				}
				if (!isVisited[nr][nc] && map[nr][nc] == 1) {
					isVisited[nr][nc] = true;
					rottenMap[nr][nc] = cur[2] + 1;
					q.offer(new int[] { nr, nc, cur[2] + 1 });
				}

			}
		}

	}

	public static void PrintMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= N || c >= N);
	}

}
