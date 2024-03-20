package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 1208 부분수열의 합 2
// 연속된 부분수열만 따져서 틀림
// 연속하지 않아도 되는 걸로 수정
public class Main1208 {
	// 정수의 개수, 합 S
	static int N, S;
	static int[] nums;
	static ArrayList<Integer> A = new ArrayList<>();
	static ArrayList<Integer> B = new ArrayList<>();
	static Long answer = 0L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			nums[i] = Integer.parseInt(st.nextToken());
		} // input END

		// 배열 두개로 나누기
		int mid = N / 2;
		makeSum(0, 0, mid, A);
		makeSum(0, mid, N, B);
		Collections.sort(A);
		Collections.sort(B);
		findAnswer();
		if (S == 0) {
			answer -= 1;
		}

		System.out.println(answer);

	}

	static void makeSum(int sum, int start, int end, ArrayList<Integer> list) {
		if (start == end) {
			list.add(sum);
			return;
		}
		makeSum(sum, start + 1, end, list);
		makeSum(sum + nums[start], start + 1, end, list);
	}

	static void findAnswer() {
		int pL = 0;
		int pR = B.size() - 1;

		while (pL < A.size() && pR >= 0) {
			int vL = A.get(pL);
			int vR = B.get(pR);

			if (vL + vR == S) {
				long cntL = 0;
				long cntR = 0;
				while (pL < A.size() && vL == A.get(pL)) {
					cntL++;
					pL++;
				}
				while (pR >= 0 && vR == B.get(pR)) {
					cntR++;
					pR--;
				}
				answer += cntL * cntR;

			}

			if (vL + vR < S) {
				pL++;
			}
			if (vL + vR > S) {
				pR--;
			}
		}
	}

}
