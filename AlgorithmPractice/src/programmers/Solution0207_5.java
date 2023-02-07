package programmers;

public class Solution0207_5 {
	static int delZero = 0;
	static int count = 0;

	public int[] solution(String s) {
		int[] answer = new int[2];
		String tmp = "";
		String resChange = s;
		while (true) {
			resChange = change(resChange);
			// System.out.println(resChange);
			if (resChange.equals("1")) {
				break;
			}
		}
		answer[1] = delZero;
		answer[0] = count;

		return answer;
	}

	public static String change(String s) {
		String tmp = "";
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '0') {
				delZero += 1;
			} else {
				tmp += cur;
			}
		}
		String res = "";
		int resLen = tmp.length();
		res = Integer.toString(resLen, 2);
		// System.out.println(res);
		count += 1;

		return res;
	}
}
