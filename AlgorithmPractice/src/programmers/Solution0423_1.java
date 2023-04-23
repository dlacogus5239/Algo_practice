package programmers;

public class Solution0423_1 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map = new int[11][11];
	static boolean[][][] isVisited = new boolean[11][11][4];

	class Solution {

		public int solution(String dirs) {
			int answer = 0;
			int[] cur = new int[2];
			cur[0] = 5;
			cur[1] = 5;

			for (int i = 0; i < dirs.length(); i++) {
				int way = -1;
				int oppWay = -1;
				int nx, ny;
				switch (dirs.charAt(i)) {
				case 'U':
					way = 0;
					oppWay = 1;
					break;
				case 'D':
					way = 1;
					oppWay = 0;
					break;
				case 'R':
					way = 2;
					oppWay = 3;
					break;
				case 'L':
					way = 3;
					oppWay = 2;
					break;

				}

				nx = cur[0] + dx[way];
				ny = cur[1] + dy[way];

				if (!isIn(nx, ny)) {
					continue;
				} else if (!isVisited[ny][nx][way]) {
					isVisited[ny][nx][way] = true;

					// 반대방향도 체크
					isVisited[cur[1]][cur[0]][oppWay] = true;

					answer++;
				}

				cur[0] = nx;
				cur[1] = ny;

			}

			return answer;
		}

		public boolean isIn(int x, int y) {
			return !(x < 0 || y < 0 || x >= 11 || y >= 11);
		}
	}
}
