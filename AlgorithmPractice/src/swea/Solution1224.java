package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution1224 {
	public static String infix;
	public static Stack<Character> postfix;
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= T; test_case++) {
			postfix = new Stack<Character>();
			N = Integer.parseInt(br.readLine());
			infix = br.readLine();
//			System.out.println("Before : " + infix);
			toPostfix();
//			System.out.print("After : ");
//			for (int i = 0; i < postfix.size(); i++) {
//				System.out.print(postfix.get(i));
//			}
//			System.out.println();
			calc(test_case);
		}
	}

	public static void toPostfix() {
		Stack<Character> stack = new Stack<Character>();
		
 
		for (int i = 0; i < infix.length(); i++) {
			char ch = infix.charAt(i);
 
			if (Character.isDigit(ch)) { // 숫자인 경우
				postfix.add(ch);
			} else if (stack.isEmpty() || ch == '(') { // 스택이 비어있거나 '('인 경우
				stack.add(ch);
			} else if (ch == ')') { // ')'인 경우
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix.add(stack.pop());
				}
				stack.pop(); // '(' 버리기
			} else { // 연산자가 들어오는 경우
				while (!stack.isEmpty() && prior(stack.peek()) >= prior(ch)) {
					postfix.add(stack.pop());
				}
				stack.add(ch);
			}
		}
 
		while (!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
		
	}

	public static int prior(char s) {
		switch (s) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		default:
			return 0;
		}
	}

	public static void calc(int test_case) {
		Stack<Integer> result = new Stack<Integer>();
		int i = 0;
		do {
			char tmp = postfix.get(i);
			int a = 0;
			int b = 0;
			switch (tmp) {
			case '*':
				b = result.pop();
				a = result.pop();
				result.push(a * b);
				break;
			case '+':
				a = result.pop();
				b = result.pop();
				result.push(a + b);
				break;
			case '-':
				a = result.pop();
				b = result.pop();
				result.push(a - b);
				break;
			case '/':
				a = result.pop();
				b = result.pop();
				result.push(a / b);
				break;
			default:
				result.push(tmp - '0');
				break;
			}
			i++;
		} while (i < postfix.size());
		// System.out.println(result.toString());
		 System.out.println("#" + test_case + " " + result.pop());
	}
}
