package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution2105 {
	// SWEA 2105 디저트 카페

	// 5시, 7시,11시, 1시(시계방향 순)
	static int[] dx = { 1, -1, -1, 1 };
	static int[] dy = { 1, 1, -1, -1 };

	static int N;
	static int[][] map;
	static boolean[][] isVisited;
	static boolean[] dessert;

	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		// test case START
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			result = -1;
			// map 방문체크
			isVisited = new boolean[N][N];
			// 디저트 개수 체크
			dessert = new boolean[101];

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// input end

			for (int i = 1; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 방문했던 디저트 카페
					isVisited[i][j] = true;
					// 처음 디저트 개수 입력
					dessert[map[i][j]] = true;
					DFS(i, j, 0, i, j);
				}
			}
			sb.append("#" + t).append(" ").append(result).append("\n");
		}

		// test case END
		// out
		System.out.println(sb.toString());
	}

	// 처음 위치 r, c 이전 방향(0 -> 3), 탐색중인 r, c
	public static void DFS(int startR, int startC, int preDirection, int r, int c) {

		// 처음 시작점으로 돌아오면 탈출
//		System.out.println(preDirection);
		if (startR == r && startC == c && preDirection == 3) {
			System.out.println("Calculate");
			int cnt = 0;
			for (int i = 1; i < dessert.length; i++) {
				if (dessert[i]) {
					cnt++;
				}
			}
			if (cnt != 0) {
				result = Math.max(result, cnt);
			}

			return;
		}
		// 방향은 시계방향으로 0->3 까지. 현재 자신의 방향으로 진행하던지, 다음 방향으로 진행한다.
		// 근데 방향이 3이면 3으로만 진행 가능. 4일경우 overFlow. --> 예외처리
		for (int d = 0; d < 2; d++) {
			int nr = r + dy[preDirection + d];
			int nc = c + dx[preDirection + d];
			// map 안이면 탐색 들어감
			// 방문했던 디저트 개수를 가졌으면 continue
			if (!isIn(nr, nc) || dessert[map[nr][nc]]) {
				continue;
			}
			// 방문체크
			isVisited[nr][nc] = true;
			// 디저트 개수 체크
			dessert[map[nr][nc]] = true;
			// 다음 단계
			DFS(startR, startC, preDirection + d, nr, nc);

			// 다른 방향일때 고려하기 위해서 미방문 처리
			isVisited[nr][nc] = false;
			dessert[map[nr][nc]] = false;
		}

	}

	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= N || c >= N);
	}

}
