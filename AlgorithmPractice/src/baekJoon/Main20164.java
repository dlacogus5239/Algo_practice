package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main20164 {
	static int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NUM = br.readLine();
		int answer = 0;
		Operation(NUM, 0);
		System.out.println(MIN + " " + MAX);
	}

	public static int Operation(String num, int cnt) {
		// 하위 전부 측정 후 반환할 값
		int result = 0;

		// 일단 카운트
		// 현재 수 홀수 카운트
		int curCnt = 0;
		for (int i = 0; i < num.length(); i++) {
			int tmp = CharToInt(num.charAt(i));
			// Odd Num
			if (tmp % 2 != 0) {
				curCnt++;
			}
		}

		// 두 자리일 경우
		if (num.length() == 2) {
			// 다음 수
			int next = CharToInt(num.charAt(0)) + CharToInt(num.charAt(1));
			// 다음 수 탐색(다음 수, 현재 단계에서의 카운트(이번 수 카운트 + 그 전 윗단계의 카운트))
			result = Operation(Integer.toString(next), curCnt + cnt);
		}
		// 세 자리 이상
		else if (num.length() >= 3) {
			// 3등분 후 더하기
			String[] tmpNum = new String[3];

			for (int i = 1; i < num.length() - 1; i++) {
				int tmp;
				for (int j = i + 1; j < num.length(); j++) {
					int divByThree = 0;
					// 3등분 후 더해서 새로운 수 만듦
					tmpNum[0] = num.substring(0, i);
					tmpNum[1] = num.substring(i, j);
					tmpNum[2] = num.substring(j);
					for (int j2 = 0; j2 < 3; j2++) {
						divByThree += Integer.parseInt(tmpNum[j2]);
					}
					// 새로 만든 수 다음단계
					// (만든 수, (현재 수 카운트, 이전 단계 카운트))
					result = Operation(Integer.toString(divByThree), curCnt + cnt);

				}
			}

		}

		// 하나일 경우
		if (num.length() == 1) {
			// 전 단계 카운트와 현재 수 카운트 후 반환
			result = cnt + curCnt;
			// 최종 최소 최대값 찾기
			MAX = Math.max(MAX, result);
			MIN = Math.min(MIN, result);

			return result;
		}

		return result;
	}

	// Character --> Int
	public static int CharToInt(char n) {
		return Character.getNumericValue(n);
	}

}
