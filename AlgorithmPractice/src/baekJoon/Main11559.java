package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11559 {
	// 백준 Puyo Puyo
	static char[][] map = new char[12][6];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// R, G, B, P, Y
		for (int i = 0; i < 12; i++) {
			String cur = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = cur.charAt(j);
			}
		}
		// input END

		// Simulation Start

		// 1. 연쇄

		// 2. 내림

		// 반복

		System.out.println(answer);
	}

	// map 안에 있는지 판단하는 함수
	public static boolean isIn(int x, int y) {
		if (x < 0 || y < 0 || x >= 6 || y >= 12) {
			return false;
		}
		return true;
	}

	// 연쇄
	public static void bfs(int x, int y) {

	}

	// 내림
	public static void setDown() {

	}

}
