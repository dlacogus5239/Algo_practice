package programmers;

public class Solution0407_02 {
	class Solution {
		public long solution(int n) {
			long answer = 0;
			long[] map = new long[n + 1];
			if (n == 1) {
				return 1;
			}
			if (n == 2) {
				return 2;
			}
			map[0] = 0L;
			map[1] = 1L;
			map[2] = 2L;

			for (int i = 3; i <= n; i++) {
				map[i] = (map[i - 1] + map[i - 2]) % 1234567;
			}

			return map[n];
		}
	}
}
