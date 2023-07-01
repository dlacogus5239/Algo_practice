package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// tilt 기울이다
public class Main13460 {
	// 백준 13460 구슬 탈출 2
	static int N, M;
	static char[][] map;
	static int holeX, holeY;
	static boolean[][][][] isVisited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Position blue, red;

	static class Position {
		int redX;
		int redY;
		int blueX;
		int blueY;
		int cnt;

		public Position(int redX, int redY, int blueX, int blueY, int cnt) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.cnt = cnt;
		}

		public Position() {
		}

		@Override
		public String toString() {
			return "Position [redX=" + redX + ", redY=" + redY + ", blueX=" + blueX + ", blueY=" + blueY + ", cnt="
					+ cnt + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		isVisited = new boolean[N][M][N][M];

		// x, y순으로 저장

		for (int i = 0; i < N; i++) {
			char[] cur = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = cur[j];

				// 빨간색, 파란색 구슬. 구멍 위치 저장
				if (map[i][j] == 'R') {
					red = new Position(j, i, 0, 0, 0);
				} else if (map[i][j] == 'B') {
					blue = new Position(0, 0, j, i, 0);
				} else if (map[i][j] == 'O') {
					holeX = j;
					holeY = i;
				}
			}
		}

		br.close();
		// input END
		int result = bfs();
		System.out.println(result);

	}

	public static int bfs() {
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(red.redX, red.redY, blue.blueX, blue.blueY, 1));
		isVisited[red.redY][red.redX][blue.redY][blue.redX] = true;

		while (!q.isEmpty()) {
			Position cur = q.poll();

			int curRx = cur.redX;
			int curRy = cur.redY;
			int curBx = cur.blueX;
			int curBy = cur.blueY;
			int curCnt = cur.cnt;
			if (curCnt > 10) {
				return -1;
			}
			for (int d = 0; d < 4; d++) {
				boolean isRedHole = false;
				boolean isBlueHole = false;
				int nRx = curRx;
				int nRy = curRy;
				int nBx = curBx;
				int nBy = curBy;

				while (map[nRy + dy[d]][nRx + dx[d]] != '#') {
					nRx += dx[d];
					nRy += dy[d];
					if (nRx == holeX && nRy == holeY) {
						isRedHole = true;
						break;
					}
				}
				while (map[nBy + dy[d]][nBx + dx[d]] != '#') {
					nBx += dx[d];
					nBy += dy[d];
					if (nBx == holeX && nBy == holeY) {
						isBlueHole = true;
						break;
					}
				}

				if (isBlueHole) {
					continue;
				}
				if (isRedHole && !isBlueHole) {
					return curCnt;
				}

				// 구슬이 같은 위치에 위치할 경우
				if (nRx == nBx && nRy == nBy) {
					// 상
					if (d == 0) {
						if (curRy > curBy) {
							nRy -= dy[d];
						} else {
							nBy -= dy[d];
						}
					} // 하
					else if (d == 1) {
						if (curRy > curBy) {
							nBy -= dy[d];
						} else {
							nRy -= dy[d];
						}

					} // 좌
					else if (d == 2) {
						if (curRx > curBx) {
							nRx -= dx[d];
						} else {
							nBx -= dx[d];
						}
					} // 우
					else if (d == 3) {
						if (curRx > curBx) {
							nBx -= dx[d];
						} else {
							nRx -= dx[d];
						}
					}
				}
				if (!isVisited[nRy][nRx][nBy][nBx]) {
					isVisited[nRy][nRx][nBy][nBx] = true;
					q.offer(new Position(nRx, nRy, nBx, nBy, curCnt + 1));
				}
			}
		}

		return -1;
	}

	// Is in Board?
	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= M || y >= N);
	}

}
