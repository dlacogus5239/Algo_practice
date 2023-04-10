package programmers;

public class Solution0410_1 {
	static int N;
	static int[] select;
	static boolean[] isVisited;
	static int result = Integer.MIN_VALUE;
	static int K;
	static int[][] input;

	class Solution {
		public int solution(int k, int[][] dungeons) {
			input = dungeons;
			K = k;
			isVisited = new boolean[dungeons.length];
			select = new int[dungeons.length];
			N = dungeons.length;

			permutation(0);

			return result;
		}

		public void permutation(int cnt) {
			if (cnt == N) {
				// 여기 검사 부분 들어갈 것
				check();
				return;
			}

			for (int i = 0; i < N; i++) {
				if (!isVisited[i]) {
					isVisited[i] = true;
					select[cnt] = i;
					permutation(cnt + 1);
					isVisited[i] = false;
				}
			}
		}

		public void check() {
			int cnt = 0;
			int tmp = K;
			for (int i = 0; i < select.length; i++) {
				int[] cur = input[select[i]];

				if (cur[0] <= tmp) {
					tmp -= cur[1];
				} else {
					break;
				}
				cnt++;
			}

			result = Math.max(cnt, result);
			// System.out.println(cnt);

		}
	}
}
