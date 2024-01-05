package codeTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	// 맵 크기, 턴, P명의 산타, 루돌프 힘, 산타 힘
	static int N, M, P, C, D;

	static class Rudolf {
		int r, c;

		public Rudolf(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static class Santa {
		int r, c;
		int score;
		boolean isOut;
		int stun;

		public Santa(int r, int c) {
			this.r = r;
			this.c = c;
			this.isOut = false;
			this.stun = -1;
			this.score = 0;
		}
	}

	static Santa[] Santas;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Rudolf rudolf = new Rudolf(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Santas = new Santa[P + 1];
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());

			Santas[Integer.parseInt(st.nextToken())] = new Santa(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		// 턴 진행

		for (int t = 1; t <= M; t++) {
			// 루돌프 이동

			// 충돌 계산

			// 산타 이동

			// 충돌 계산

			// 상호작용 계산

			// 기절?

			// 게임종료 계산?
		}
	}

}
