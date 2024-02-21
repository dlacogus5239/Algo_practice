package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14891 {
	static int[] Gear = new int[5];
	static int N;
	static boolean[] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Binary Integer 변환 ########## 중요
		for (int i = 1; i < 5; i++) {
			Gear[i] = Integer.parseInt(br.readLine(), 2);
		}

		// Gear input END
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		// 명령 수행
		for (int t = 0; t < N; t++) {
			isVisited = new boolean[5];
			st = new StringTokenizer(br.readLine());
			int GearNum = Integer.parseInt(st.nextToken());
			// Clockwise or Anticlockwise
			boolean CorAC = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			Rotate(GearNum, CorAC);
		}
		int answer = Score();
		System.out.println(answer);
	}

	// 회전할 기어, 방향
	public static void Rotate(int GearNum, boolean CorAC) {
		isVisited[GearNum] = true;
		// 다음 기어 회전시킬건지 검사 (+- 1기어 검사 )
		// S극 : 1, N극 : 0
		// 왼쪽 기어--> 현재 기어 (7번째 검사, Bit로는 1번째) # 왼쪽 기어 (3번째, Bit로는 5번째)
		if (isIn(GearNum - 1)) {
			if (((1 << 1) & Gear[GearNum]) > 0 != ((1 << 5) & Gear[GearNum - 1]) > 0) {
				if (!isVisited[GearNum - 1]) {
					// 방향 반대로 넘겨주기
					Rotate(GearNum - 1, !CorAC);
				}
			}

		}
		// 오른쪽 기어--> 현재 기어 (3번째 검사, Bit로는 5번째) # 오른쪽 기어 (7번째, Bit로는 1번째)
		if (isIn(GearNum + 1)) {
			if (((1 << 1) & Gear[GearNum + 1]) > 0 != ((1 << 5) & Gear[GearNum]) > 0) {
				if (!isVisited[GearNum + 1]) {
					// 방향 반대로 넘겨주기
					Rotate(GearNum + 1, !CorAC);
				}
			}
		}

		// 현재 기어 회전
		// 시계방향
		if (CorAC) {
			if ((Gear[GearNum] & 1) > 0) {
				Gear[GearNum] >>>= 1;
				Gear[GearNum] |= (1 << 7);
			} else {
				Gear[GearNum] >>>= 1;
			}
		} // 반시계방향
		else {
			if ((Gear[GearNum] & (1 << 7)) > 0) {
				Gear[GearNum] <<= 1;
				Gear[GearNum] |= 1;
			} else {
				Gear[GearNum] <<= 1;
			}
		}

	}

	// DONE
	// 배열 밖인지 검사
	public static boolean isIn(int n) {
		return !(n <= 0 || n > 4);
	}

	// DONE
	public static int Score() {
		int result = 0;

		result += (Gear[1] & (1 << 7)) == 0 ? 0 : 1;
		result += (Gear[2] & (1 << 7)) == 0 ? 0 : 2;
		result += (Gear[3] & (1 << 7)) == 0 ? 0 : 4;
		result += (Gear[4] & (1 << 7)) == 0 ? 0 : 8;

		return result;
	}

}
