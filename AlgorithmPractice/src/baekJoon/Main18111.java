package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18111 {
	static int Time, Height;
	static int[][] map;
	static int N, M;

	// 마인크래프트
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 세로, 가로, 인벤토리 블럭 수
		int B;
		Time = Integer.MAX_VALUE;
		Height = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 중복값을 피하기 위해서
		// 높이 최소, 최댓값을 가져와서
		// 최소 ~ 최댓값으로 평탄화 시키는 작업을 수행
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				start = Math.min(start, map[i][j]);
				end = Math.max(end, map[i][j]);
			}
		}
		// input END

		for (int h = start; h <= end; h++) {
			Flation(h, B);

		}

		System.out.println(Time + " " + Height);

	}

	// 어떤 높이 기준으로 평탄화 할건지 (h) 인벤토리 init
	public static void Flation(int h, int B) {
		// 총 파내야 하는 개수랑 쌓아야 하는 개수랑 인벤토리 비교 !
		int curTime = 0;
		int curDig = 0;
		int curAdd = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == h) {
					continue;
				} else if (map[i][j] > h) {
					curDig += map[i][j] - h;
				} else {
					curAdd += h - map[i][j];
				}
			}
		}

		if (curAdd > curDig + B) {
			return;
		} else {
			curTime = curDig * 2 + curAdd;
		}

		if (curTime < Time) {
			Time = curTime;
			Height = h;
		} else if (curTime == Time) {
			if (Height > h) {
				return;
			} else {
				Height = h;
				return;
			}
		}

		return;
	}

}
