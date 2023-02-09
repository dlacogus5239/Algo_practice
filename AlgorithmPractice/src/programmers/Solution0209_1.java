package programmers;

import java.util.*;

public class Solution0209_1 {

	// Left ==> + 1
	// Right ==> - 1
	// Straight ==> 0
	static int[][] movement = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static String[][] map;
	static ArrayList<Integer> answer = new ArrayList<Integer>();
	static int row, col;
	static boolean[][][] isVisited;

	public int[] solution(String[] grid) {

		map = new String[grid.length][grid[0].length()];

		for (int i = 0; i < grid.length; i++) {
			String[] tmp = grid[i].split("");
			for (int j = 0; j < tmp.length; j++) {
				map[i][j] = tmp[j];
			}
		}

		col = map.length;
		row = map[0].length;
		isVisited = new boolean[col][row][4];
		// 모든 정점마다 들리지 않은 모든 방향에 대하여 빛의 경로를 구해줘야 한다

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				for (int m = 0; m < 4; m++) {
					int tmp;
					if (!isVisited[i][j][m]) {
						tmp = Cycle(j, i, m);
						answer.add(tmp);
					}
				}
			}
		}

		return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
	}

	public static int Cycle(int x, int y, int move) {
		// S, R, L 에 따라서 달라질 현재의 이동
		// 파라미터로 받아온 move는 사이클 검사용

		int count = 0;

		while (true) {
			if (isVisited[y][x][move]) {
				break;
			}
			count += 1;
			isVisited[y][x][move] = true;

			if (map[y][x].equals("L")) {
				move = (move + 5) % 4;
			} else if (map[y][x].equals("R")) {
				move = (move + 3) % 4;
			}
			x = (x + movement[move][0] + row) % row;
			y = (y + movement[move][1] + col) % col;
		}

		return count;
	}
}
