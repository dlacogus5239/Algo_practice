package dx_pre;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution2 {
	// N * M 크기의 셀
	// Q 명령어의 개수
	static int N, M, Q;
	static long[][] map;
	static int cnt;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			map = new long[N][M];

			// 처음 맵 구성
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Long.parseLong(st.nextToken());
				}
			}

			// 안전지대 계산 START
			boolean[] isExist = new boolean[200_000];
			// 처음 안전지대 계산
			long[] maxCol = new long[M];
			long[] maxRow = new long[N];
			for (int i = 0; i < N; i++) {
				long tmp = -1;
				for (int j = 0; j < M; j++) {
					tmp = Math.max(tmp, map[i][j]);
				}
				maxRow[i] = tmp;
				System.out.print(maxRow[i] + " ");
				isExist[(int) tmp] = true;
			}
			System.out.println();
			for (int i = 0; i < M; i++) {
				long tmp = -1;
				for (int j = 0; j < N; j++) {
					tmp = Math.max(tmp, map[j][i]);
				}
				maxCol[i] = tmp;
				System.out.print(maxCol[i] + " ");
				if (isExist[(int) tmp]) {
					cnt++;
				}
			}

			System.out.println();
			// 다음 바뀐거에 대한 안전지대 계산
			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long cost = Long.parseLong(st.nextToken());

				if (maxRow[r - 1] < cost) {
					maxRow[r - 1] = cost;
				}
				if (maxCol[c - 1] < cost) {
					maxCol[c - 1] = cost;
				}
				for (int m = 0; m < maxCol.length; m++) {
					System.out.print(maxCol[m] + " ");
				}
				System.out.println();
				for (int m = 0; m < maxRow.length; m++) {
					System.out.print(maxRow[m] + " ");
				}
				System.out.println();

				SafeZone(maxRow, maxCol);
			}
			// 안전지대 계산 END
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());

	}

	public static void SafeZone(long[] maxRow, long[] maxCol) {
		boolean[] isExist = new boolean[200_000];
		for (int i = 0; i < maxCol.length; i++) {
			isExist[(int) maxCol[i]] = true;
		}
		for (int i = 0; i < maxRow.length; i++) {
			if (isExist[(int) maxRow[i]])
				cnt++;
		}
	}

}
