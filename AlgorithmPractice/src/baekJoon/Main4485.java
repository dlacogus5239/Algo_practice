package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4485 {
	static int N;
	static int[][] map;
	static int[][] distance;
	static boolean[][] isVisited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우

	static class Vertex implements Comparable<Vertex> {
		int x;
		int y;
		int minDistance;

		public Vertex(int x, int y, int minDistance) {
			super();
			this.x = x;
			this.y = y;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.minDistance - o.minDistance;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			int result = 0;

			if (N == 0) {
				break;
			}
			map = new int[N][N];
			isVisited = new boolean[N][N];
			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			// input END
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			// Dijstra PQ
			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
			pq.offer(new Vertex(0, 0, map[0][0]));
			distance[0][0] = map[0][0];

			while (!pq.isEmpty()) {
				Vertex cur = pq.poll();
				if (isVisited[cur.y][cur.x]) {
					continue;
				}

				isVisited[cur.y][cur.x] = true;

				// 4방위 탐색을 진행하면서, 최솟값 갱신
				for (int d = 0; d < 4; d++) {
					int next_x = cur.x + dx[d];
					int next_y = cur.y + dy[d];
					if (isIn(next_x, next_y) && isVisited[next_y][next_x]) {
						continue;
					}

					if (isIn(next_x, next_y)
							&& distance[next_y][next_x] > distance[cur.y][cur.x] + map[next_y][next_x]) {
						distance[next_y][next_x] = distance[cur.y][cur.x] + map[next_y][next_x];
						pq.offer(new Vertex(next_x, next_y, distance[next_y][next_x]));
					}
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(distance[i][j] + " ");
//				}
//				System.out.println();
//			}
			result = distance[N - 1][N - 1];
			// Output
			System.out.println("Problem " + test_case + ": " + result);
			test_case++;
		}
	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		return true;
	}
}