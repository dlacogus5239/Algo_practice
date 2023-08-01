package softeer;

import java.util.*;
import java.io.*;

public class Main1 {
	// 업무 처리
	
	// 조직도의 높이, 말단에 대기하는 업무의 수 K, 업무가 진행되는 날짜 수 R
	static int H, K, R;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		// N -> 총 직원 수
		int N = (int) Math.pow(2, H + 1) - 1;
		// 말단 직원의 수
		int tail = (int) Math.pow(2, H);

		// parent : n 일 경우 left = n * 2, right = n * 2 + 1

		// 업무 저장 리스트(이진 트리 구현)
		// 0 -> 오른쪽, 1 -> 왼쪽쪽
		// 0번은 안씀
		Queue<Integer>[][] arr = new LinkedList[N - tail + 1][2];
		// init
		for (int i = 1; i < N - tail + 1; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = new LinkedList<>();
			}
		}

		// 말단 직원은 따로 두자
		Queue<Integer>[] tailArr = new LinkedList[tail + 1];
		// 초기화와 동시에 입력
		for (int i = 1; i < tail + 1; i++) {
			st = new StringTokenizer(br.readLine());
			tailArr[i] = new LinkedList<>();
			for (int j = 0; j < K; j++) {
				tailArr[i].offer(Integer.parseInt(st.nextToken()));
			}
		}

		// 결과값
		int result = 0;

		// 날짜
		int day = 0;
		// 홀수 짝수 check.
		// 0 -> 오른쪽, 1 -> 왼쪽
		int check = 0;
		// 업무 처리
		while (day < R) {
			// 하루 시작
			day++;
			check = day % 2;

			// 부사장 업무 처리
			if (!arr[1][check].isEmpty()) {
				result += arr[1][check].poll();
			}
			// 중간 급 직원들 업무
			for (int i = 2; i < N - tail + 1; i++) {
				// 업무가 있을 경우 부모 노드로 넘겨줌
				// 왼쪽 노드인지 오른쪽 노드인지
				int curCheck = (i + 1) % 2;
				if (!arr[i][check].isEmpty()) {
					arr[i / 2][curCheck].offer(arr[i][check].poll());
				}

			}

			// 말단 직원 업무
			for (int i = 1; i < tail + 1; i++) {
				int curIdx = (i + (int) Math.pow(2, H)) - 1;
				int curCheck = (curIdx + 1) % 2;
				// System.out.println(curIdx);

				// 업무가 남아 있을 경우
				if (!tailArr[i].isEmpty()) {
					arr[curIdx / 2][curCheck].offer(tailArr[i].poll());
				}
			}

		}

		System.out.println(result);
	}
}