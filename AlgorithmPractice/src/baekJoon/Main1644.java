package baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1644 {
	static int[] primeNum;
	static List<Integer> prime = new ArrayList<Integer>(); // N 이하의 소수들로만 구성된 배열
	static int N, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		primeNum = new int[N + 1];
		cnt = N;
		CalcPrimeNum();

		// 투 포인터 이용
		int result = 0;

		int start = 0;
		int end = 0;

		int sum = 0;
		for (start = 0; start < prime.size(); start++) {
			while (sum < N && end < prime.size()) {
				sum += prime.get(end);
				end++;
			}
			if (sum == N) {
				result++;
			}
			sum -= prime.get(start);
		}

		System.out.println(result);
	}

	// 에라토스테네스의 체를 이용한 소수 계산
	public static void CalcPrimeNum() {

		// 초기화
		for (int i = 1; i <= N; i++) {
			primeNum[i] = i;
		}
		for (int i = 2; i <= N; i++) {
			if (primeNum[i] == 0) {
				continue;
			}
			for (int j = i * 2; j <= N; j += i) {
				primeNum[j] = 0;
				cnt--;
			}
		}
		for (int i = 2; i <= N; i++) {
			if (primeNum[i] != 0) {
				prime.add(primeNum[i]);
			}
		}
	}
}