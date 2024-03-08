package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2143 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// A, B 부배열 합을 저장할 리스트
		ArrayList<Integer> ASum = new ArrayList<>();
		ArrayList<Integer> BSum = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < M + 1; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		// input END

		// 부배열의 합들 저장(크기는 각각 시그마(배열의 길이))
		int tmpSum = 0;
		for (int i = 1; i <= N; i++) {
			tmpSum = 0;
			for (int j = i; j <= N; j++) {
				tmpSum += A[j];
				ASum.add(tmpSum);
			}
		}
		for (int i = 1; i <= M; i++) {
			tmpSum = 0;
			for (int j = i; j <= M; j++) {
				tmpSum += B[j];
				BSum.add(tmpSum);
			}
		}


		ASum.sort(null);
		BSum.sort(null);

		// ASum + BSum 조합 합 이분탐색으로 진행
		int pa = 0;
		int pb = BSum.size() - 1;
		long cnt = 0;

		while (pa < ASum.size() && 0 <= pb) {
			int sum = ASum.get(pa) + BSum.get(pb);

			if (sum == T) {
				long a = ASum.get(pa);
				long b = BSum.get(pb);
				long cntA = 0;
				long cntB = 0;

				while (pa < ASum.size() && ASum.get(pa) == a) {
					cntA++;
					pa++;
				}
				while (0 <= pb && BSum.get(pb) == b) {
					cntB++;
					pb--;
				}
				cnt += cntA * cntB;
			} else if (sum > T) {
				pb--;
			} else if (sum < T) {
				pa++;
			}

		}

		System.out.println(cnt);

	}

}
