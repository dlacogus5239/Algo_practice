package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14499 {
	// 백준 14499 주사위 굴리기
	// 맵의 크기 N, M 주사위 좌표 x, y 명령의 개수 K
	static int N, M, x, y, K;
	static int[][] map;
	// 동, 서, 북, 남
	// 우, 좌, 상, 하
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	// 주사위 정보는 북->남으로만 저장하고 왼쪽 오른쪽 따로 저장
	static int[] dice;
	static int diceL, diceR;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 주사위 초기화
		// dice[1] -> Top
		// dice[3] -> Bottom
		dice = new int[4];
		diceL = 0;
		diceR = 0;

		int[] operation = new int[K];

		st = new StringTokenizer(br.readLine());
		// 명령 입력(동 : 1, 서 : 2, 북 : 3 , 남 : 4)
		for (int i = 0; i < K; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// input END

		// 굴려굴려
		for (int i = 0; i < K; i++) {
			roll(operation[i], x, y);
		}

	}

	// 맵 안인지
	public static boolean isIn(int r, int c) {
		return !(r < 0 || c < 0 || r >= M || c >= N);
	}

	public static void roll(int oper, int r, int c) {
		int nr = dx[oper - 1] + x;
		int nc = dy[oper - 1] + y;

		// map 바깥인 경우
		if (!isIn(nr, nc)) {
			return;
		}
		// 좌표 이동 및 주사위 전개도 갱신
		int tmp, tmpL, tmpR, tmpT, tmpB;
		tmpL = diceL;
		tmpR = diceR;
		tmpT = dice[1];
		tmpB = dice[3];
		switch (oper) {
		// 동쪽
		case 1:
			dice[1] = tmpL;
			dice[3] = tmpR;
			diceL = tmpB;
			diceR = tmpT;
			break;
		// 서쪽
		case 2:
			dice[1] = tmpR;
			dice[3] = tmpL;
			diceL = tmpT;
			diceR = tmpB;
			break;
		// 북쪽
		case 3:
			tmp = dice[0];
			for (int i = 0; i < 3; i++) {
				dice[i] = dice[i + 1];
			}
			dice[3] = tmp;
			break;
		// 남쪽
		case 4:
			tmp = dice[3];
			for (int i = 3; i > 0; i--) {
				dice[i] = dice[i - 1];
			}
			dice[0] = tmp;
			break;
		default:
			break;
		}

		// 이동한 칸이 0일 경우
		if (map[nc][nr] == 0) {
			map[nc][nr] = dice[3];
		}
		// 아닐경우
		else {
			dice[3] = map[nc][nr];
			map[nc][nr] = 0;
		}
		x = nr;
		y = nc;
//		System.out.println("x : " + x + " , " + "y : " + y);

		System.out.println(dice[1]);

	}

}
