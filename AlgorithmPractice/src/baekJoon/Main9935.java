package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9935 {
	// 백준 9935 문자열 폭발
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String boom = br.readLine();

		int length = input.length();
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < length; i++) {
			s.push(input.charAt(i));

			if (s.size() >= boom.length()) {
				boolean flag = true;

				for (int j = 0; j < boom.length(); j++) {
					if (s.get(s.size() - boom.length() + j) != boom.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < boom.length(); j++) {
						s.pop();
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (Character c : s) {
			sb.append(c);
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}

}
