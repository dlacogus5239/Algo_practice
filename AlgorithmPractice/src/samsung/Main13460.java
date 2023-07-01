package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// tilt 기울이다
public class Main13460 {
	static int N, M;
	static char[][] map;

	static class Position {
		int redX;
		int redY;
		int blueX;
		int blueY;
		int holeX;
		int holeY;

		public Position(int redX, int redY, int blueX, int blueY, int holeX, int holeY) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.holeX = holeX;
			this.holeY = holeY;
		}

		public Position() {
		}

		@Override
		public String toString() {
			return "Position [redX=" + redX + ", redY=" + redY + ", blueX=" + blueX + ", blueY=" + blueY + ", holeX="
					+ holeX + ", holeY=" + holeY + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Position p = new Position();

		// x, y순으로 저장

		for (int i = 0; i < N; i++) {
			char[] cur = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = cur[j];

				// 빨간색, 파란색 구슬. 구멍 위치 저장
				if (map[i][j] == 'R') {
					p.redX = j;
					p.redY = i;
				} else if (map[i][j] == 'B') {
					p.blueX = j;
					p.blueY = i;
				} else if (map[i][j] == 'O') {
					p.holeX = j;
					p.holeY = i;
				}
			}
		}

		// bfs 수행
		Queue<Position> q = new LinkedList<>();
		q.offer(p);
		while (!q.isEmpty()) {
			Position cur = q.poll();
			
		}
		// input END

	}

	// Is in Board?
	public static boolean isIn(int x, int y) {
		return !(x < 0 || y < 0 || x >= M || y >= N);
	}

}
