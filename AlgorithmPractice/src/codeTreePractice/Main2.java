package codeTreePractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken()) - 1;
		int c1 = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		int r2 = Integer.parseInt(st.nextToken()) - 1;
		int c2 = Integer.parseInt(st.nextToken()) - 1;

		int result = 0;
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				result += map[i][j];
			}
		}

		System.out.println(result);
	}

}
