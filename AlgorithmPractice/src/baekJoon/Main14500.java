package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500 {
	// 백준 14500 테트로미노
	static int N, M;
	static int[][] map;
	static int result;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 세로 N, 가로 M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// map, isVisited 생성
		map = new int[N][M];
		isVisited = new boolean[N][M];

		// input 받음
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		// input END;

		// ㅗ모양을 제외한 모양들은 대칭, 회전 모두 포함해서 dfs로 4번까지 탐색하면
		// 모든 모양을 만들 수 있다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				isVisited[i][j] = true;
				dfs(j, i, 1, map[i][j]);
				isVisited[i][j] = false;
			}
		}

		System.out.println(result);
	}

	public static void dfs(int x, int y, int cnt, int sum) {
		if (cnt == 4) {
//			System.out.println(sum);
			result = Math.max(result, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!isIn(nx, ny)) {
				continue;
			}
			if (!isVisited[ny][nx]) {
				// ㅗ모양은 2번째 칸에서 탐색 한번 더 진행한다.
				if (cnt == 2) {
					isVisited[ny][nx] = true;
					dfs(x, y, cnt + 1, sum + map[ny][nx]);
					isVisited[ny][nx] = false;
				}

				isVisited[ny][nx] = true;
				dfs(nx, ny, cnt + 1, sum + map[ny][nx]);
				isVisited[ny][nx] = false;
			}
		}
	}

	// 배열안 검사
	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= M || y >= N);
	}

}
