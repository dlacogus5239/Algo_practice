package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1520 {
	// 백준 1520 내리막 길
	static int M, N;
	static int[][] map;

	// 이동경로 개수 저장
	static int[][] dp;

	// 이동 방향 ( 상 하 좌 우 )
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	// 결과

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];
		// 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		// Input END

		// dp 배열의 값을 모두 -1 로 초기화
		for (int i = 0; i < M; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println(dfs(0, 0));

	}

	public static int dfs(int x, int y) {
		if (x == N - 1 && y == M - 1) {
			return 1;
		}
		if (dp[y][x] != -1) {
			return dp[y][x];
		}
		dp[y][x] = 0;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isIn(nx, ny)) {
				if (map[ny][nx] < map[y][x]) {
					dp[y][x] += dfs(nx, ny);
				}
			}
		}
		return dp[y][x];
	}

	// 배열 범위 밖인지 검사
	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= N || y >= M);
	}

}
