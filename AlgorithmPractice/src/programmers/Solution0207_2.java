package programmers;

import java.util.*;

class Solution0207_2 {
	// JadenCase 문자열 만들기
	public String solution(String s) {
		String answer = "";
		if (Character.isLetter(s.charAt(0))) {
			answer += Character.toUpperCase(s.charAt(0));
		} else {
			answer += s.charAt(0);
		}
		for (int i = 1; i < s.length(); i++) {
			char tmp = s.charAt(i);
			// System.out.println(tmp);
			if (s.charAt(i - 1) == ' ' && Character.isLetter(tmp)) {
				answer += Character.toUpperCase(tmp);
			} else {
				answer += Character.toLowerCase(tmp);
			}
		}

		return answer;
	}
}
