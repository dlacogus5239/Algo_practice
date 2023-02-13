package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1918 {
	// 백준 1918 후위 표기식
	/*
	 * 스택에는 연산자만 사용하고, 피연산자는 바로바로 출력한다 연산자의 우선 순위 지정 현재 연산자의 우선순위보다 큰 연산자가 stack의 맨
	 * 위에 있다면 없을 때까지 pop ")"일 경우 "("가 나올 때까지 stack안의연산자를 pop 피연산자는 따로 스택에 넣지 않고 그냥
	 * 출력하기 위해 붙여주자
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			switch (now) {
			case '+':
			case '-':
			case '*':
			case '/':
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
					sb.append(stack.pop());
				}
				stack.add(now);
				break;
			case '(':
				stack.add(now);
				break;
			case ')':
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				sb.append(now);
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}

	public static int priority(char operator) {

		if (operator == '(' || operator == ')') {
			return 0;
		} else if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		}
		return -1;
	}
}
