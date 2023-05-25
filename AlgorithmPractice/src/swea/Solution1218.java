package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1218 {
	// SWEA 괄호 짝짓기
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] brackets = br.readLine().toCharArray();
			// input END

			Stack<Character> stack = new Stack<>();
			boolean answer = true;
			for (int i = 0; i < N; i++) {
				if (brackets[i] == '(' || brackets[i] == '[' || brackets[i] == '{' || brackets[i] == '<') {
					stack.add(brackets[i]);
				} else {
					if (stack.isEmpty()) {
						answer = false;
						break;
					}

					switch (brackets[i]) {
					case ')':
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							answer = false;
							break;
						}
						break;
					case '}':
						if (stack.peek() == '{') {
							stack.pop();
						} else {
							answer = false;
							break;
						}
						break;
					case ']':
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							answer = false;
							break;
						}
						break;
					case '>':
						if (stack.peek() == '<') {
							stack.pop();
						} else {
							answer = false;
							break;
						}
						break;
					}
				}

			}
			sb.append("#" + t + " ").append(answer ? "1" : "0").append("\n");

		}
		System.out.println(sb.toString());
	}

}
