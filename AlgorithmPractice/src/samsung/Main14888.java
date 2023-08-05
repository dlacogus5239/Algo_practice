package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {
	// 백준 14888 연산자 끼워넣기
	// 수열의 개수
	static int N;

	// 수열
	static int[] nums;

	// -10억 < 최대, 최솟값 < 10억
	// 최대, 최솟값 저장
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];

		// 연산자들 저장(+, -, *, /)
		int[] operations = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operations[i] = Integer.parseInt(st.nextToken());
		}

		br.close();
		// input END

		// 백트레킹 시작
		for (int i = 0; i < 4; i++) {
			if (operations[i] != 0) {
				int[] nextOper = operations.clone();
				nextOper[i] -= 1;
				BackTracking(nums[0], 1, i, nextOper);
			}
		}

		System.out.println(max);
		System.out.println(min);

	}

	// num -> 현재까지의 계산 값
	// cnt -> 수열의 cnt번째 수까지 계산함
	// oper -> 현재 넣을 Operation 번호
	// operation -> 현재까지의 Operation 개수
	public static void BackTracking(int num, int cnt, int oper, int[] operations) {
		// 마지막 숫자까지 넣었으면 최대 최소 계산해주기
		if (cnt == N - 1) {
			int tmp = Calc(num, nums[cnt], oper);
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
			return;
		}
		// 다음수와 현재 입력받은 operation 계산한 값
		int next = Calc(num, nums[cnt], oper);
		for (int i = 0; i < 4; i++) {
			if (operations[i] >= 1) {
				int[] nextOper = operations.clone();
				nextOper[i] -= 1;
				BackTracking(next, cnt + 1, i, nextOper);
			}
		}

	}

	// a, b operation에 대한 결과값 도출
	public static int Calc(int a, int b, int oper) {
		int result = 0;
		switch (oper) {
		case 0:
			result = a + b;
			break;
		case 1:
			result = a - b;
			break;
		case 2:
			result = a * b;
			break;
		case 3:
			result = a / b;
			break;
		}

		return result;
	}

}
