package programmers;

import java.lang.StringBuilder;

public class Solution0410_2 {

	static String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	class Solution {
		public String solution(int n, int t, int m, int p) {
			StringBuilder answer = new StringBuilder();
			int cnt = 0;
			StringBuilder tmp = new StringBuilder();

			// 최대 16진법이니까
			int i = 0;
			int end = t * m + p;
			while (end >= 0) {
				String cur = convert(i, n);
				end -= cur.length();
				i++;
				tmp.append(cur);
			}
			String res = tmp.toString();
			for (int k = 0; k < t * m - 1; k += m) {
				answer.append(res.charAt(k + p - 1));
			}

			return answer.toString();
		}

		public String convert(int num, int n) {
			// num 은 n진법으로 바꿀 "수"
			StringBuilder sb = new StringBuilder();

			while (num >= n) {
				sb.append(numbers[num % n]);
				num /= n;
			}
			sb.append(numbers[num]);

			return sb.reverse().toString();

		}
	}
}
