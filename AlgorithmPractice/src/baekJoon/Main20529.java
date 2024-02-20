package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main20529 {
	// 학생 수
	static int N;

	// ISTJ, ISFJ, INFJ, INTJ, ISTP, ISFP, INFP, INTP, ESTP, ESFP, ENFP, ENTP, ESTJ,
	// ESFJ, ENFJ, ENTJ
	static int answer;
	static int[] isChoosen;
	static boolean[] isVisited;
	static String[] MBTI;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			isChoosen = new int[3];
			// 비둘기집 원리
			// 입력이 33이상이면 3쌍을 이루는 MBTI가 무조건 하나는 있다.
			// 그러면 가장 가까운 세 사람의 심리적 거리는 0
			if (N >= 33) {
				sb.append(0).append("\n");
				br.readLine();
				continue;
			}
			MBTI = new String[N];
			answer = 100_000;

			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				String cur = st.nextToken();
				MBTI[i] = cur;
			}
			isVisited = new boolean[N];
			for (int i = 0; i <= N - 3; i++) {
				isVisited[i] = true;
				isChoosen[0] = i;
				Combination(1, i);
				isVisited[i] = false;

			}
			sb.append(answer).append("\n");

		}
		System.out.println(sb.toString());

	}

	// 3명 고르고 계산
	public static void Combination(int cnt, int start) {
		// 3명 다 골랐으면 계산하기
		if (cnt == 3) {
			int tmp = CalcDistance(isChoosen[0], isChoosen[1]) + CalcDistance(isChoosen[1], isChoosen[2])
					+ CalcDistance(isChoosen[0], isChoosen[2]);
			answer = (int) Math.min(answer, tmp);
			return;
		}

		for (int i = start + 1; i < N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				isChoosen[cnt] = i;
				Combination(cnt + 1, i);
				isVisited[i] = false;
			}
		}

	}

	// 두 MBTI끼리 심리적 거리 계산
	public static int CalcDistance(int A, int B) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (MBTI[A].charAt(i) != MBTI[B].charAt(i)) {
				result++;
			}
		}

		return result;
	}

}
