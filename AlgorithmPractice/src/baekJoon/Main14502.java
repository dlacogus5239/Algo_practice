package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502 {
	static int N, M; // map 크기 N * M
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static ArrayList<int[]> virus;
	static int result;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		/*
		 * 0 : 빈 칸 // 1 : 벽 // 2 : 바이러스
		 */
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
			}
		}

		// input END

		result = Integer.MIN_VALUE; // 결과
		MakeWall(0);

		System.out.println(result);

	}

	// 바이러스를 BFS를 통해서 퍼뜨림
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>(); // bfs 방문 좌표를 저장할 큐
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
				if (map[i][j] == 2) {
					q.offer(new int[] { j, i });
				}
			}
		} // map 복사

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int next_x = cur[0] + dx[d];
				int next_y = cur[1] + dy[d];

				if (!isIn(next_x, next_y)) {
					continue;
				}
				if (copyMap[next_y][next_x] == 0) { // 빈공간을 대상으로만
					q.offer(new int[] { next_x, next_y });
					copyMap[next_y][next_x] = 2; // 바이러스 퍼짐 map에 표시
				}
			}
		}
		countZero(copyMap);

	}

	public static void MakeWall(int cnt) {
		if (cnt == 3) { // 벽을 3개 세운다. 세운 이후에 바이러스 퍼뜨리는거 계산
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1; // 벽 세우기
					MakeWall(cnt + 1);
					map[i][j] = 0;
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

	public static void countZero(int[][] curMap) {
		int tmp = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (curMap[i][j] == 0) {
					tmp++;
				}
//				System.out.print(curMap[i][j] + " ");
			}
//			System.out.println();
		}
//		System.out.println("=====" + tmp + "=======");
		result = Math.max(result, tmp);
	}

}