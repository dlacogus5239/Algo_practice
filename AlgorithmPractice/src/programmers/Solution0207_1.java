package programmers;

import java.util.*;

class Solution0207_1 {
	// 최댓값과 최솟값
	public String solution(String s) {
		String answer = "";
		StringTokenizer st = new StringTokenizer(s);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int length = st.countTokens();
		for (int i = 0; i < length; i++) {
			String curStr = st.nextToken();
			int tmp = Integer.parseInt(curStr);
			// System.out.println(curStr);
			min = Math.min(min, tmp);
			max = Math.max(max, tmp);
		}
		answer = min + " " + max;

		return answer;
	}
}