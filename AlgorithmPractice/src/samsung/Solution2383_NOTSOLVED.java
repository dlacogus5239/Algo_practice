package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2383_NOTSOLVED {
	// SWEA 2383 점심 식사시간
	static class Person {
		int x, y;
		int stair;

		Person(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", stair=" + stair + "]";
		}

	}

	static ArrayList<Person> people;
	static int[][] stair;
	static ArrayList<Integer> ArriveTime1, ArriveTime2;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		// 출력용
		StringBuilder sb = new StringBuilder();

		// TEST CASE START
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			people = new ArrayList<>();
			stair = new int[2][3];
			StringTokenizer st;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int cur = Integer.parseInt(st.nextToken());

					if (cur == 1) {
						people.add(new Person(j, i));
					}
					if (cur > 1) {
						stair[cnt][0] = j;
						stair[cnt][1] = i;
						stair[cnt][2] = cur;
						cnt++;
					}
				}
			}

			DecideStair(0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		// TEST CASE END
		System.out.println(sb.toString());
	}

	// 계단 결정
	public static void DecideStair(int cnt) {
		if (cnt == people.size()) {
			CalcArrive();
			int tmp = (int) (Math.max(DownStair(1), DownStair(2)));
//			System.out.println(tmp);
			result = (int) Math.min(result, tmp);
			return;
		}

		people.get(cnt).stair = 1;
		DecideStair(cnt + 1);
		people.get(cnt).stair = 2;
		DecideStair(cnt + 1);
	}

	// 도착시간 계산
	public static void CalcArrive() {
		// 계단 1 도착시간 모음
		ArriveTime1 = new ArrayList();
		// 계단 2 도착시간 모음
		ArriveTime2 = new ArrayList();
		for (int i = 0; i < people.size(); i++) {
			int tmp = 0;
			Person cur = people.get(i);
			if (cur.stair == 1) {
				tmp = (int) (Math.abs(stair[0][0] - cur.x) + Math.abs(stair[0][1] - cur.y));
				ArriveTime1.add(tmp);
			} else {
				tmp = (int) (Math.abs(stair[1][0] - cur.x) + Math.abs(stair[1][1] - cur.y));
				ArriveTime2.add(tmp);
			}
		}
		// 정렬
		ArriveTime1.sort((o1, o2) -> (o1 - o2));
		ArriveTime2.sort((o1, o2) -> (o1 - o2));
//
//		System.out.println(ArriveTime1.toString());
//		System.out.println(ArriveTime2.toString());
//		System.out.println("=====");
		result = (int) Math.min(result, Math.max(DownStair(1), DownStair(2)));

	}

	// 각 계단에 대한 것 계산
	// 이부분 수정 씨 발
	public static int DownStair(int s) {
		int result1 = -1;
		int result2 = -1;
		// 가장 늦게 도착하는 시각
		if (s == 1 && ArriveTime1.size() != 0) {
			int time1 = ArriveTime1.get(ArriveTime1.size() - 1);
			if (ArriveTime1.size() > 3) {
				int[] dp = new int[ArriveTime1.size()];

				dp[0] = ArriveTime1.get(0) + stair[0][2] + 1;
				dp[1] = ArriveTime1.get(1) + stair[0][2] + 1;
				dp[2] = ArriveTime1.get(2) + stair[0][2] + 1;
				for (int i = 3; i < ArriveTime1.size(); i++) {
					// 대기시간
					int tmp = dp[i - 3] - (ArriveTime1.get(i) + 1) > 0 ? dp[i - 3] - ArriveTime1.get(i) : 0;
					dp[i] = ArriveTime1.get(i) + tmp + stair[0][2];
				}
				result1 = dp[ArriveTime1.size() - 1];

			} else {
				result1 = time1 + stair[0][2] + 1;
			}

			return result1;
		} else if (ArriveTime2.size() != 0) {
			int time2 = ArriveTime2.get(ArriveTime2.size() - 1);
			if (ArriveTime2.size() > 3) {
				int[] dp = new int[ArriveTime2.size()];

				dp[0] = ArriveTime2.get(0) + stair[1][2] + 1;
				dp[1] = ArriveTime2.get(1) + stair[1][2] + 1;
				dp[2] = ArriveTime2.get(2) + stair[1][2] + 1;
				for (int i = 3; i < ArriveTime2.size(); i++) {
					int tmp = dp[i - 3] - (ArriveTime2.get(i) + 1) > 0 ? dp[i - 3] - ArriveTime2.get(i) : 0;
					dp[i] = ArriveTime2.get(i) + tmp + stair[1][2];
				}
				result2 = dp[ArriveTime2.size() - 1];
			} else {
				result2 = time2 + stair[0][2] + 1;
			}

			return result2;
		}
		return -1;
	}

}
